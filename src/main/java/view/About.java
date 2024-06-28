package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Account;
import user.AccountFunctionImp;

/**
 * Servlet implementation class About
 */
@WebServlet("/About")
public class About extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset = utf-8;";     
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public About() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
	
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
		out.append("<header id=\"header\" class=\"d-flex align-items-center\">");
		out.append("<div class=\"container-fluid container-xl d-flex align-items-center justify-content-between\">");
		out.append("");
		out.append("<div class=\"logo d-flex align-items-center\">");
		out.append("<a href=\"Home?id="+id+"\"><img src=\"/MyWeb/img/logo_name.png\" alt=\"\" class=\"img-fluid\"></a>");
		out.append("</div>");
		out.append("");
		out.append("<nav id=\"navbar\" class=\"navbar order-last order-lg-0\">");
		out.append("<ul class=\"nav-left\">");
		out.append("<li><a class=\"nav-link scrollto active\" href=\"Home?id="+id+"#hero\">Trang chủ</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"About?id="+id+"\">Giới thiệu</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"Home?id="+id+"#portfolio\">Thực đơn</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"Home?id="+id+"#events\">Sự kiện</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"Home?id="+id+"#chefs\">Đầu bếp</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"#Home?id="+id+"#gallery\">Kho ảnh</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"#Home?id="+id+"#contact\">Liên hệ</a></li>");
		out.append("</ul>");
		out.append("<ul class=\"nav-right\">");
		out.append("<li><a class=\"nav-link cart-icon\" href=\"Cart?id="+id+"\"><i class=\"fa-solid fa-cart-shopping\"></i><span class=\"cart-count\">0</span></a></li>");		out.append("</ul>");
		out.append("<i class=\"bi bi-list mobile-nav-toggle\"></i>");
		out.append("</nav><!-- .navbar -->");
		out.append("");
		out.append("</div>");
		out.append("</header><!-- End Header -->");
		out.append("");
		out.append("");
		out.append("<main id=\"main\">");
		out.append("");
		out.append("<!-- ======= About Section ======= -->");
		out.append("<section id=\"about\" class=\"about\">");
		out.append("<div class=\"container-fluid\">");
		out.append("");
		out.append("<div class=\"row\">");
		out.append("");
		out.append("<div class=\"col-lg-5 align-items-stretch video-box\" style='background-image: url(\"/MyWeb/img/about.jpg\");'>");
		out.append("<<a href=\"https://www.youtube.com/watch?v=tJlzIJaokVY\" class=\"play-btn mb-4\" target=\"_blank\"></a>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-7 d-flex flex-column justify-content-center align-items-stretch\">");
		out.append("");
		out.append("<div class=\"content\">");
		out.append("<h3>Triết lý <strong>thương hiệu</strong></h3>");
		out.append("<p>");
		out.append("Nhà hàng Tasty mang đến trải nghiệm ẩm thực bằng triết lý và niềm tin về tính \"Trọn Vẹn\".");
		out.append("</p>");
		out.append("<p>");
		out.append("Tinh hoa văn hoá ẩm thực Việt Nam mang nhiều dấu ấn độc đáo, phản ánh đời sống tinh thần cũng như quan niệm sống nhân văn của người Việt từ bao thế hệ đã trở thành nguồn cảm hứng cho triết lý về tính \"Trọn Vẹn\" trong trải nghiệm ẩm thực của Tasty.");
		out.append("</p>");
		out.append("<ul>");
		out.append("<li><i class=\"bx bx-check-double\"></i> Trải nghiệm ẩm thực \"Trọn Vẹn\" là sáng tạo trong chế biến nhưng vẫn tôn trọng những nguyên lý đã được đúc kết ngàn đời nhằm lưu giữ hương vị truyền thống</li>");
		out.append("<li><i class=\"bx bx-check-double\"></i> Tính \"Trọn Vẹn\" đến từ sự chu đáo và tận tình của người đầu bếp, người phục vụ</li>");
		out.append("<li><i class=\"bx bx-check-double\"></i> Tính \"Trọn Vẹn\" từ bầu không khí ấm áp và gần gũi, khơi gợi những xúc cảm gắn kết và sẻ chia trong từng khoảnh khắc</li>");
		out.append("</ul>");
		out.append("<p>");
		out.append("Tasty lan tỏa giá trị nhân văn sâu sắc của văn hoá ẩm thực Việt qua những bữa ăn trọn vẹn hương vị cùng khoảnh khắc của yêu thương và sẻ chia");
		out.append("</p>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</section><!-- End About Section -->");
		out.append("");
		out.append("<!-- ======= Whu Us Section ======= -->");
		out.append("<section id=\"why-us\" class=\"why-us\">");
		out.append("<div class=\"container\">");
		out.append("");
		out.append("<div class=\"section-title\">");
		out.append("<h2>Những điểm <span>nổi bật</span></h2>");
		out.append("<p>Thưởng thức tinh hoa ẩm thực truyền thống Việt Nam giữa lòng Hà Nội tại Tasty</p>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-4\">");
		out.append("<div class=\"box\">");
		out.append("<div class=\"icon icon-lg\">");
		out.append("<i class=\"fa-solid fa-tree-city\"></i>");
		out.append("</div>");
		out.append("");
		out.append("<h4>Vị trí và không gian</h4>");
		out.append("<p>Nằm trong lòng Hà Nội, Tasty với không gian bên trong được thiết kế mộc mạc nhưng vẫn đầy phong cách, tạo cảm giác thoải mái và dễ chịu cho thực khách.</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-4 mt-4 mt-lg-0\">");
		out.append("<div class=\"box\">");
		out.append("<div class=\"icon icon-lg\">");
		out.append("<i class=\"fa-solid fa-utensils\"></i>");
		out.append("</div>");
		out.append("<h4>Thực đơn phong phú</h4>");
		out.append("<p>Tasty luôn tự hào là điểm đến đa dạng về thực đơn món ăn Việt. Thực phẩm tại Tasty luôn được chế biến tinh tế, đảm bảo chất lượng và hương vị tốt nhất.</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-4 mt-4 mt-lg-0\">");
		out.append("<div class=\"box\">");
		out.append("<div class=\"icon icon-lg\">");
		out.append("<i class=\"fa-solid fa-dollar-sign\"></i>");
		out.append("</div>");
		out.append("<h4>Giá cả hợp lý</h4>");
		out.append("<p>Tasty  hiểu rằng việc thưởng thức ẩm thực là một phần quan trọng của cuộc sống, vì vậy nhà hàng luôn cố gắng duy trì mức giá hợp lý cho khách hàng.</p>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("");
		out.append("</div>");
		out.append("</section><!-- End Whu Us Section -->");
		out.append("</main>");
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
		out.append("");
		out.append("</body>");
		out.append("");
		out.append("</html>");
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
