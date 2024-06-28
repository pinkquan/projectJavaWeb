package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Account;
import object.ProductObject;
import user.AccountFunctionImp;
import user.ProductFunction;
import user.ProductFunctionImpl;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset = utf-8;";  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		
		PrintWriter out = response.getWriter();
		
		
		 // Lấy ID sản phẩm từ request
 
        String id = request.getParameter("id");
        String productIdStr = request.getParameter("productId");
		
		
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
		out.append("<link href=\"img/logo1.png\" rel=\"icon\">");
		out.append("<link href=\"img/apple_logo.png\" rel=\"apple-touch-icon\">");
		out.append("<link rel=\"icon\" type=\"img/android.png\" href=\"android-chrome-192x192.png\">");
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
		out.append("<link href=\"/MyWeb/css/productdetail.css\" rel=\"stylesheet\">");
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
		
		
        out.append("<main id=\"main\">");
        
       
        int productId = Integer.parseInt(productIdStr);
        
        // Khởi tạo ProductFunction
        ProductFunction pf = new ProductFunctionImpl(null);

        // Lấy thông tin sản phẩm
        ProductObject product = pf.getProduct(productId);

        // Giải phóng kết nối
        pf.releaseConnection();


    	String imgPath = "/MyWeb/img/menu/menu" + product.getProductImg() + ".jpg";
        out.append("<div class=\"container\">");
        out.append("<div class=\"row justify-content-center\">");

    	out.append("<div class=\"product-detail col-md-12\">");
        out.append("<div class=\"product-image col-md-6\">");
        out.append("<img src=\"" + imgPath + "\" alt=\"" + product.getProductName() + "\">");
        if (product.getProductQuantity() == 0) {
            out.append("<span class=\"out-of-stock\" id=\"outOfStockLabel\">HẾT HÀNG</span>");
        }
        out.append("</div>");
        out.append("<div class=\"product-info col-md-6\">");
        out.append("<h1>" + product.getProductName() + "</h1>");
        out.append("<hr class=\"dashed\">");
        out.append("<div class=\"stock\">");
        out.append("<span class=\"stock\">Còn " + product.getProductQuantity() + " sản phẩm</span>");
        out.append("</div>");
        out.append("<hr class=\"dashed\">");
        out.append("<div class=\"price\">" + product.getProductPrice() + " đ</div>");
        out.append("<hr class=\"dashed\">");
        out.append("<a href=\"AddProductItem?id="+id+"&productId="+productIdStr+"\" class=\"btn btn-danger add-to-cart-btn\">THÊM VÀO GIỎ HÀNG</a>");

        out.append("<hr class=\"dashed\">");
        out.append("<div class=\"details\">");
        out.append("<h3><i class=\"fa-solid fa-cubes-stacked\"></i> Thành phần:</h3>");
        out.append("<p>" + product.getProductIngredient() + "</p>");
        out.append("<hr class=\"dashed\">");
        out.append("<h3><i class=\"fa-solid fa-utensils\"></i> Khẩu phần:</h3>");
        out.append("<p>" + product.getProductPortion() + "</p>");
        out.append("<hr class=\"dashed\">");
        out.append("<h3><i class=\"fa-solid fa-fire\"></i> Năng lượng:</h3>");
        out.append("<p>" + product.getProductEnergy() + "</p>");
        out.append("<hr class=\"dashed\">");
        out.append("<h3><i class=\"fa-solid fa-clock\"></i> Thời gian hoàn tất:</h3>");
        out.append("<p>" + product.getProductTimeComplete() + "</p>");
        out.append("<hr class=\"dashed\">");
        out.append("<h3><i class=\"fa-solid fa-book-open\"></i> Mô tả món:</h3>");
        out.append("<p>" + product.getProductDescription() + "</p>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");
        out.append("</div>");

            
        

		
		
		
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
//		out.append("<script src=\"/MyWeb/js/detail.js\"></script>");
//		out.append("<script src=\"/MyWeb/js/cart.js\"></script>");
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
