package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.Account;
import object.CartItemObject;
import object.CartObject;
import object.ProductObject;
import object.ShipObject;
import user.AccountFunctionImp;
import user.CartFunctionImpl;
import user.ProductFunctionImpl;
import user.ShipFunction;
import user.ShipFunctionImpl;
import util.ConnectionPool;


/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String CONTENT_TYPE = "text/html; charset = utf-8;";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		AccountFunctionImp oper = new AccountFunctionImp(cp);
        if (cp == null) {
            getServletContext().setAttribute("CPool", oper.getCP());
        }
		Account acc = oper.getAccount(id);
		CartFunctionImpl cf = new CartFunctionImpl(cp);
        if (cp == null) {
            getServletContext().setAttribute("CPool", cf.getCP());
        }
		int idInt = Integer.parseInt(id);
		CartObject cart = cf.getCartByUserId(idInt);
		
		ArrayList<CartItemObject> list = cf.getCartItemsByCartId(cart.getCartId());
		
		out.append("<!DOCTYPE html>");
		out.append("<html lang=\"en\">");
		out.append("");
		out.append("<head>");
		out.append("<meta charset=\"utf-8\">");
		out.append("<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">");
		out.append("");
		out.append("<title>Tasty Restaurant</title>");
		out.append("<meta content=\"Nhà hàng 5 sao sang trọng — Tasty tự tin làm hài lòng những thực khách khó tính nhất từ chất lượng đến phục vụ.\" name=\"description\">");
		out.append("<meta content=\"nhà hàng, restaurant, ẩm thực, food\" name=\"keywords\">");
		out.append("");
		out.append("<!-- Favicons -->");
		out.append("<link href=\"/MyWeb/img/logo1.png\" rel=\"icon\">");
		out.append("<link href=\"/MyWeb/img/apple_logo.png\" rel=\"apple-touch-icon\">");
		out.append("<link rel=\"icon\" type=\"/MyWeb/img/android.png\" href=\"android-chrome-192x192.png\">");
		out.append("");
		out.append("<!-- Google Fonts -->");
		out.append("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">");
		out.append("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>");
		out.append("<link href=\"https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,100..900;1,100..900&display=swap\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- Vendor CSS Files -->");
		out.append("<link href=\"/MyWeb/css/animate.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/bootstrap-icons.css\" rel=\"stylesheet\">");
		out.append("<link href=\"https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.0.7/css/boxicons.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/glightbox.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/swiper-bundle.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/all.min.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- Template Main CSS File -->");
		out.append("<link href=\"/MyWeb/css/difhome.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("");
		out.append("<link href=\"/MyWeb/css/cart.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- =======================================================");
		out.append("* Template Name: Delicious");
		out.append("* Template URL: https://bootstrapmade.com/delicious-free-restaurant-bootstrap-theme/");
		out.append("* Updated: Mar 17 2024 with Bootstrap v5.3.3");
		out.append("* Author: BootstrapMade.com");
		out.append("* License: https://bootstrapmade.com/license/");
		out.append("======================================================== -->");
		out.append("");
		out.append("</head>");
		out.append("");
		out.append("<body>");
		out.append("");
		out.append("<!-- ======= Header ======= -->");
		out.append("<header id=\"header\" class=\"fixed-top d-flex align-items-center header-transparent\">");
		out.append("<div class=\"container-fluid container-xl d-flex align-items-center justify-content-between\">");
		out.append("");
		out.append("<div class=\"logo d-flex align-items-center\">");
		out.append("<a href=\"Index\"><img src=\"/MyWeb/img/logo_name.png\" alt=\"\" class=\"img-fluid\"></a>");
		out.append("</div>");
		out.append("");
		out.append("<nav id=\"navbar\" class=\"navbar\">");

		out.append("<ul class=\"nav-left\">");
		out.append("<li><a class=\"nav-link scrollto active\" href=\"Index#hero\">Trang chủ</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"About\">Giới thiệu</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"Index#portfolio\">Thực đơn</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"Index#events\">Sự kiện</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"Index#chefs\">Đầu bếp</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"Index#gallery\">Kho ảnh</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"Index#contact\">Liên hệ</a></li>");
		out.append("</ul>");
		
		out.append("<ul class=\"nav-right\">");
		out.append("<li><a class=\"nav-link\" href=\"login\"><i class=\"fa-solid fa-user\"></i></a></li>");
		out.append("<li><a class=\"nav-link cart-icon\" href=\"Cart1\"><i class=\"fa-solid fa-cart-shopping\"></i><span class=\"cart-count\">0</span></a></li>");
		out.append("</ul>");
		out.append("<i class=\"bi bi-list mobile-nav-toggle\"></i>");
		out.append("</nav><!-- .navbar -->");
		out.append("");
		out.append("</div>");
		out.append("</header><!-- End Header -->");
		out.append("");
		out.append("");
		out.append("<main id=\"main\">");
        out.append("<div class=\"cart-container\">");
        out.append("<div class=\"cart-left\">");
        out.append("<div class=\"cart-items-container\">");
        out.append("<h2>Giỏ hàng của bạn</h2>");
        out.append("<table id=\"cart-items\">");
        out.append("<thead>");
        out.append("<tr>");
        out.append("<th></th>");
        out.append("<th>Sản phẩm</th>");
        out.append("<th>Giá</th>");
        out.append("<th>Số lượng</th>");
        out.append("<th>Tổng</th>");
        out.append("<th></th>");
        out.append("</tr>");
        out.append("</thead>");
        out.append("<tbody>");

        // Tính tổng tiền của các sản phẩm trong giỏ hàng
        ProductFunctionImpl pf = new ProductFunctionImpl(cp);
        int subtotal = 0;
        for (CartItemObject item : list) {
            ProductObject product = pf.getProduct(item.getProductId());
            String imgPath = "/MyWeb/img/menu/menu" + product.getProductImg() + ".jpg";
            out.append("<tr>");
            out.append("<td><img src=\"" + imgPath + "\" alt=\"Product Image\" style=\"max-width: 100px; max-height: 100px;\"></td>");
            out.append("<td>" + product.getProductName() + "</td>");
            int money = product.getProductPrice(), sL = item.getCartItemQuantity();
            out.append("<td>" + money + " đ</td>");
            out.append("<td>" + sL + "</td>");
            out.append("<td>" + (money * sL) + " đ</td>");
            out.append("<td><a href=\"DelCartItem?id=" + acc.get_id() + "&itemId=" + item.getCartItemId() + "\">Xóa</a></td>");
            out.append("</tr>");
            subtotal += money * sL;
        }

        out.append("</tbody>");
        out.append("</table>");
        out.append("</div>");
        out.append("</div>");
        out.append("<div class=\"cart-divider\"></div>");
        out.append("<div class=\"cart-right\">");
        out.append("<div class=\"shipping-method-container\">");
        out.append("<h2>Phương thức vận chuyển</h2>");
        out.append("<form id=\"shipping-form\">");
        out.append("<div class=\"form-group\">");
        out.append("<input type=\"radio\" id=\"standard\" name=\"shipping\" value=\"standard\" checked>");
        out.append("<label for=\"standard\">Giao hàng tiêu chuẩn (0)</label>");
        out.append("</div>");
        out.append("<div class=\"form-group\">");
        out.append("<input type=\"radio\" id=\"express\" name=\"shipping\" value=\"express\">");
        out.append("<label for=\"express\">Giao hàng nhanh (50000)</label>");
        out.append("</div>");
        out.append("</form>");
        out.append("</div>");
        
        
        HttpSession session = request.getSession();
        String shippingMethod = request.getParameter("shipping");

        // Lưu thông tin vào session
        session.setAttribute("shippingMethod", shippingMethod);

        // Tách tên vận chuyển và giá vận chuyển từ chuỗi shippingMethod
        String shippingMethodName = null;
        int shippingCost = 0;

        if (shippingMethod != null) {
            if (shippingMethod.equals("standard")) {
                shippingMethodName = "Giao hàng tiêu chuẩn";
                shippingCost = 0;
            } else if (shippingMethod.equals("express")) {
                shippingMethodName = "Giao hàng nhanh";
                shippingCost = 50000;
            }
        }

        // Lưu tên vận chuyển và giá vận chuyển vào session
        session.setAttribute("shippingMethodName", shippingMethodName);
        session.setAttribute("shippingCost", shippingCost);

        
        // Hiển thị tổng tiền và phí vận chuyển
        out.append("<div id=\"cart-summary\">");
        out.append("<div id=\"cart-subtotal\">Tạm tính: " + subtotal + " đ</div>");
        out.append("<div id=\"shipping-cost\">Phí vận chuyển: 0 đ</div>");
        out.append("<div id=\"cart-total\">Tổng cộng: " + subtotal + " đ</div>");
        out.append("<a href=\"Pay?id="+acc.get_id()+"&cartId="+cart.getCartId()+"\" class=\"btn btn-primary\" id=\"checkout-button\">Thanh toán</a>");
        out.append("</div>");

        out.append("</div>"); // Đóng div cart-right và cart-container
        out.append("</div>"); // Đóng main

        out.append("<template id=\"cart-item-template\">");
        out.append("<tr class=\"cart-item\">");
        out.append("<td>");
        out.append("<img src=\"\" alt=\"\" class=\"item-image\">");
        out.append("<span class=\"item-name\"></span>");
        out.append("</td>");
        out.append("<td class=\"item-price\"></td>");
        out.append("<td>");
        out.append("<input type=\"number\" class=\"item-quantity\" min=\"1\" value=\"1\">");
        out.append("</td>");
        out.append("<td class=\"item-total\"></td>");
        out.append("<td>");
        out.append("<button class=\"remove-item\">&times;</button>");
        out.append("</td>");
        out.append("</tr>");
        out.append("</template>");
		out.append("");
		out.append("");
		out.append("");
		out.append("<!-- ======= Footer ======= -->");
		out.append("<footer id=\"footer\">");
		out.append("<div class=\"container\">");
		out.append("<h3>Tasty Restaurant</h3>");
		out.append("<p>Theo dõi nhà hàng để biết nhiều sự kiện ưu đãi hơn.</p>");
		out.append("<div class=\"social-links\">");
		out.append("<a href=\"#\" class=\"twitter\"><i class=\"bx bxl-twitter\"></i></a>");
		out.append("<a href=\"#\" class=\"facebook\"><i class=\"bx bxl-facebook\"></i></a>");
		out.append("<a href=\"#\" class=\"instagram\"><i class=\"bx bxl-instagram\"></i></a>");
		out.append("<a href=\"#\" class=\"google-plus\"><i class=\"bx bxl-skype\"></i></a>");
		out.append("<a href=\"#\" class=\"linkedin\"><i class=\"bx bxl-linkedin\"></i></a>");
		out.append("</div>");
		out.append("<div class=\"copyright\">");
		out.append("&copy; Copyright <strong><span>Tasty</span></strong>. All Rights Reserved");
		out.append("</div>");
		out.append("<div class=\"credits\">");
		out.append("<!-- All the links in the footer should remain intact. -->");
		out.append("<!-- You can delete the links only if you purchased the pro version. -->");
		out.append("<!-- Licensing information: https://bootstrapmade.com/license/ -->");
		out.append("<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/delicious-free-restaurant-bootstrap-theme/ -->");
		out.append("Designed by <a href=\"#\">Hồng Quân and Nguyễn Việt</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("</footer><!-- End Footer -->");
		out.append("");
		out.append("<a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>");
		out.append("");
		out.append("<!-- Vendor JS Files -->");
		out.append("<script src=\"/MyWeb/js/bootstrap.bundle.min.js\"></script>");
		out.append("<script src=\"/MyWeb/js/glightbox.min.js\"></script>");
		out.append("<script src=\"/MyWeb/js/isotope.pkgd.min.js\"></script>");
		out.append("<script src=\"/MyWeb/js/swiper-bundle.min.js\"></script>");
		out.append("<script src=\"/MyWeb/js/validate.js\"></script>");
		out.append("");
		out.append("<!-- Template Main JS File -->");
		out.append("<script src=\"/MyWeb/js/main.js\"></script>");
		out.append("<script src=\"/MyWeb/js/cartItem.js\"></script>");
//		out.append("<script src=\"/MyWeb/js/cart.js\"></script>");

		out.append("");
		out.append("</body>");
		out.append("");
		out.append("</html>");
		out.append("");
		out.append("");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
