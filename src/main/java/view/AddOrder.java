package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.Account;
import object.CartItemObject;
import object.OrderDetail;
import object.ProductObject;
import user.AccountFunctionImp;
import user.CartFunctionImpl;
import user.OrderFunction;
import user.OrderFunctionImpl;
import user.ProductFunctionImpl;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

/**
 * Servlet implementation class AddOrder
 */
@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset = utf-8;";     

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Lấy ConnectionPool từ ServletContext
        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
        if (cp == null) {
            cp = new ConnectionPoolImpl(); // Khởi tạo ConnectionPool nếu chưa tồn tại
            getServletContext().setAttribute("CPool", cp);
        }
        
        // Lấy thông tin từ request
        String idUser = request.getParameter("id");
        String idCart = request.getParameter("cartId");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String paymentMethod = request.getParameter("select"); // Thay "select" bằng name của thẻ select
        String orderMessage = request.getParameter("txtMessage");

        // Chuyển đổi idUser và idCart sang kiểu số nguyên
        int userId = Integer.parseInt(idUser);
        int cartId = Integer.parseInt(idCart);

        // Lấy thông tin vận chuyển từ session
        HttpSession session = request.getSession();
        String shippingMethodName = (String) session.getAttribute("shippingMethodName");
        int shippingCost = (int) session.getAttribute("shippingCost");

        // Tạo đối tượng OrderDetail và thiết lập các thông tin
        OrderDetail newOrder = new OrderDetail();
        newOrder.setOrderCreatedDate("2024-06-29"); // Thay bằng ngày hiện tại hoặc ngày được chọn
        newOrder.setOrderTotalPrice(calculateOrderTotalPrice(cp, userId, cartId)); // Tính tổng tiền từ giỏ hàng
        newOrder.setOrderStatus("Đang xử lý"); // Hoặc "Chờ xác nhận" tùy theo logic của bạn
        newOrder.setOrderAddressShipping(address); // Sử dụng địa chỉ từ form
        newOrder.setOrderShipName(shippingMethodName); // Tên phương thức vận chuyển
        newOrder.setOrderShipPrice(shippingCost); // Phí vận chuyển
        newOrder.setUserId(idUser);
        newOrder.setPaymentId(1); // Thay bằng phương thức thanh toán từ form (cần xử lý thêm)
        
        
        UUID uuid = UUID.randomUUID();
        long longId = uuid.getMostSignificantBits() & Long.MAX_VALUE;
        int idOrder = (int) longId;
        newOrder.setOrderId(idOrder);
        
        
        // Thêm thông tin mới: tên người nhận, email, số điện thoại và phương thức thanh toán
        newOrder.setCustomerName(fullName);
        newOrder.setEmail(email);
        newOrder.setPhone(phone);
        newOrder.setPaymentMethod(paymentMethod);
        
        // Thêm thông tin ghi chú đơn hàng
        newOrder.setOrderMessage(orderMessage);

        // Gọi phương thức addOrder từ OrderFunction để thêm vào CSDL
        OrderFunctionImpl of = new OrderFunctionImpl(cp);
        boolean added = of.addOrder(newOrder);

        if (added) {
            out.println("<p>Đã thêm đơn hàng thành công!</p>");
            
        } else {
            out.println("<p>Không thể thêm đơn hàng.</p>");
            
        }
        
        out.flush();
        out.close();
        response.sendRedirect("Home?id="+idUser);
    }

    // Phương thức tính tổng tiền đơn hàng từ giỏ hàng
    private int calculateOrderTotalPrice(ConnectionPool cp, int userId, int cartId) {
        int subtotal = 0;
        CartFunctionImpl cf = new CartFunctionImpl(cp);
        ArrayList<CartItemObject> list = cf.getCartItemsByCartId(cartId);
        ProductFunctionImpl pf = new ProductFunctionImpl(cp);
        for (CartItemObject item : list) {
            ProductObject product = pf.getProduct(item.getProductId());
            int money = product.getProductPrice();
            int quantity = item.getCartItemQuantity();
            subtotal += money * quantity;
        }
        return subtotal;
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}
