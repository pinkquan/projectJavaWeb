package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.CartItemObject;
import object.CartObject;
import object.ProductObject;
import user.CartFunctionImpl;
import user.ProductFunctionImpl;
import util.ConnectionPool;

/**
 * Servlet implementation class AddProductItem
 */
@WebServlet("/AddProductItem")
public class AddProductItem extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	private static final String CONTENT_TYPE = "text/html; charset = utf-8;";  

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        try {
            String id = request.getParameter("id");
            String productIdStr = request.getParameter("productId");
            
            // Tim bo quan ly ket noi
            ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
            
            CartFunctionImpl cf = new CartFunctionImpl(cp);
            if (cp == null) {
                getServletContext().setAttribute("CPool", cf.getCP());
            }
            ProductFunctionImpl pf = new ProductFunctionImpl(cp);
            if (cp == null) {
                getServletContext().setAttribute("CPool", pf.getCP());
            }
            
            int userIdInt = Integer.parseInt(id);
            int productIdInt = Integer.parseInt(productIdStr);
            
            // Lấy sản phẩm và giảm số lượng
            ProductObject product = pf.getProduct(productIdInt);
            product.setProductQuantity(product.getProductQuantity() - 1);
            pf.editProduct(product);
            
            // Lấy giỏ hàng của người dùng
            CartObject co = cf.getCartByUserId(userIdInt);
            
            // Kiểm tra xem sản phẩm đã có trong giỏ hàng hay chưa
            CartItemObject cio = cf.getCartItemByCartProduct(co.getCartId(), productIdInt);
            
            if (cio != null) {
                // Sản phẩm đã tồn tại trong giỏ hàng, tăng số lượng
                cio.setCartItemQuantity(cio.getCartItemQuantity() + 1);
                cf.updateCartItem(cio);
            } else {
                // Sản phẩm chưa tồn tại trong giỏ hàng, thêm mới
                cio = new CartItemObject();
                cio.setCartId(co.getCartId());
                cio.setCartItemQuantity(1);
                cio.setProductId(productIdInt);
                cf.addCartItem(cio);
            }
            
            response.sendRedirect("Home?id=" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
