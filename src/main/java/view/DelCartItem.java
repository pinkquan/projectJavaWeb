package view;

import java.io.IOException;
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
 * Servlet implementation class DelCartItem
 */
@WebServlet("/DelCartItem")
public class DelCartItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset = utf-8;"; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCartItem() {
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
            String itemId = request.getParameter("itemId");

            // Tim bo quan ly ket noi
            ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
            
            CartFunctionImpl cf = new CartFunctionImpl(cp);
            if (cp == null) {
                getServletContext().setAttribute("CPool", cf.getCP());
            }
           
            int cartItemId = Integer.parseInt(itemId);
            
            cf.deleteCartItem(cartItemId);
            
            
            response.sendRedirect("Cart?id=" + id);
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
