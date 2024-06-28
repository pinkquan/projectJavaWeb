package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.attribute.BasicFileAttributes;
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
import object.CartObject;
import object.OrderDetail;
import object.OrderObject;
import user.AccountFunctionImp;
import user.CartFunctionImpl;
import user.OrderFunctionImpl;
import util.ConnectionPool;

/**
 * Servlet implementation class Pay
 */
@WebServlet("/Pay")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset = utf-8;";     
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		AccountFunctionImp user = new AccountFunctionImp(cp);
		Account acc = user.getAccount(id);
		
		out.append("<!DOCTYPE html>");
		out.append("<html lang=\"en\">");
		out.append("<head>");
		out.append("<meta charset=\"UTF-8\">");
		out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.append("<title>Thanh toán</title>");
		out.append("");
		out.append("<link href=\"/MyWeb/css/all.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.append("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">");
		out.append("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>");
		out.append("<link href=\"https://fonts.googleapis.com/css2?family=AR+One+Sans:wght@400..700&family=Noto+Sans+HK:wght@100..900&display=swap\" rel=\"stylesheet\">");
		out.append("");
		out.append("<link href=\"/MyWeb/css/pay.css\" rel=\"stylesheet\">");
		out.append("</head>");
		out.append("<body>");
		out.append("<div class=\"container-fluid vh-100 d-flex justify-content-center align-items-center\">");
		out.append("<div class=\"row w-100\">");
		out.append("<div class=\"col-md-6 offset-md-3\">");
		out.append("<div class=\"bg-light p-4 view\" id=\"view\">");
		out.append("<form class=\"needs-validation\" method=\"POST\">");
		out.append("<div class=\"mb-4\">");
		out.append("<h3>Chi tiết thanh toán</h3>");
		out.append("<div class=\"mb-3\">");
		out.append("<label for=\"fullName\" class=\"form-label\">Họ tên:</label>");
		out.append("<input type=\"text\" class=\"form-control\" id=\"fullName\" name=\"firstName\"  placeholder=\""+acc.getFirst_name()+"\" required>");
		out.append("<div class=\"invalid-feedback\">Vui lòng nhập họ tên!</div>");
		out.append("</div>");
		out.append("<div class=\"mb-3\">");
		out.append("<label for=\"address\" class=\"form-label\">Địa chỉ:</label>");
		out.append("<input type=\"text\" class=\"form-control\" id=\"address\" name=\"addressShip\" placeholder=\""+acc.getAddress()+"\" required>");
		out.append("<div class=\"invalid-feedback\">Vui lòng nhập địa chỉ!</div>");
		out.append("</div>");
		out.append("<div class=\"mb-3\">");
		out.append("<label for=\"email\" class=\"form-label\">Email:</label>");
		out.append("<input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\""+acc.getEmail()+"\" autocomplete=\"off\" required>");
		out.append("<div class=\"invalid-feedback\">Vui lòng nhập email!</div>");
		out.append("</div>");
		out.append("<div class=\"mb-3\">");
		out.append("<label for=\"phone\" class=\"form-label\">Số điện thoại:</label>");
		out.append("<input type=\"text\" class=\"form-control\" id=\"phone\" name=\"phone\" placeholder=\""+acc.getPhone_number()+"\" required>");
		out.append("<div class=\"invalid-feedback\">Vui lòng nhập số điện thoại!</div>");
		out.append("</div>");
		out.append("<div>");
		out.append("<label for=\"select\">Phương thức:</label>");
		out.append("<select name=\"select\" class=\"form-select\" id=\"select\">");
		out.append("<option value=\"1\">VN Pay</option>");
		out.append("<option value=\"2\">Thanh toán khi nhận hàng</option>");
		out.append("<option value=\"3\">Chuyển khoản qua ngân hàng</option>");
		out.append("<option value=\"4\">Thanh toán bằng thẻ ngân hàng</option>");
		out.append("</select>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"mb-4\">");
		out.append("<h3>Thông tin thêm</h3>");
		out.append("<p>Ghi chú đơn hàng (Tùy chọn)</p>");
		out.append("<div class=\"mb-3\">");
		out.append("<textarea class=\"form-control\" name=\"txtMessage\" id=\"txtMessage\" rows=\"4\" placeholder=\"Ghi chú về đơn hàng của bạn\"></textarea>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<button class=\"btn btn-outline-danger border-primary w-100 shadow-lg\" type=\"submit\">Thanh toán</button>");
		out.append("</form>  ");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>   ");
		out.append("");
		

		
		out.append("<script src=\"/MyWeb/js/bootstrap.bundle.min.js\"></script>");
		out.append("<script src=\"/MyWeb/js/pay.js\"></script>");
		out.append("");
		out.append("</body>");
		out.append("</html>");
		out.append("");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		 HttpSession session = request.getSession();
	        String shippingMethod = (String) session.getAttribute("shippingMethod");
	        String shippingMethodName = (String) session.getAttribute("shippingMethodName");
	        int shippingCost = (int) session.getAttribute("shippingCost");
		
		
		String idUser = request.getParameter("id");
		int idInt = Integer.parseInt(idUser);
		String nameString = request.getParameter("firstName");
		String addressShipString = request.getParameter("addressShip");
		String emailString = request.getParameter("email");
		String phoneString = request.getParameter("phone");
		String textString = request.getParameter("txtMessage");
		
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		OrderFunctionImpl of = new OrderFunctionImpl(cp);
		if (cp == null) {
            getServletContext().setAttribute("CPool", of.getCP());
        }
		OrderDetail newOrder = new OrderDetail();
		UUID uuid = UUID.randomUUID();
        long longId = uuid.getMostSignificantBits() & Long.MAX_VALUE;
        int idOrder = (int) longId;
        
//		int idOrder = 90;
		
        newOrder.setOrderId(idOrder);
		newOrder.setOrderCreatedDate("28/06/2024");
		newOrder.setOrderStatus("Dang duyet");
		newOrder.setOrderTotalPrice(500000);
		newOrder.setOrderShipName(shippingMethodName);
		newOrder.setOrderShipPrice(shippingCost);
		newOrder.setUserId(idUser);
		newOrder.setPaymentId(1);
		newOrder.setOrderMessage(textString);
		newOrder.setOrderAddressShipping(addressShipString);

		
		boolean added = of.addOrder(newOrder);
		if (added) {
			out.append("Thanh Cong");
		}else {
			out.append("Khong thanh cong");
		}
		
	}

}
