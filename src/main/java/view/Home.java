package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Account;
import object.Bill;
import object.CartItemObject;
import object.CartObject;
import object.ProductObject;
import user.ProductFunction;
import user.ProductFunctionImpl;
import user.AccountFunctionImp;
import util.ConnectionPool;
import user.BillFunctionImp;
import user.CartFunctionImpl;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset = utf-8;";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		
		// Tim bo quan ly ket noi
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
		
		if (cart == null) {
			CartObject cartUser = new CartObject();
			cartUser.setUserId(idInt);
			cartUser.setCartId(idInt+1);
			cf.addCart(cartUser);
		}
		
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
		out.append("<link href=\"/MyWeb/css/style.css\" rel=\"stylesheet\">");
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
		out.append("</head>");
		out.append("");
		out.append("<body>");
		out.append("");
		out.append("<!-- ======= Top Bar ======= -->");
		out.append("<section id=\"topbar\" class=\"d-flex align-items-center fixed-top topbar-transparent\">");
		out.append("<div class=\"container-fluid container-xl d-flex align-items-center justify-content-center justify-content-lg-start\">");
		out.append("<i class=\"bi bi-phone d-flex align-items-center\"><span>+1 5589 55488 55</span></i>");
		out.append("<i class=\"bi bi-clock ms-4 d-none d-lg-flex align-items-center\"><span>Thứ 2-Chủ nhật: 6:30 - 22:00</span></i>");
		out.append("</div>");
		out.append("</section>");
		out.append("");
		out.append("<!-- ======= Header ======= -->");
		out.append("<header id=\"header\" class=\"fixed-top d-flex align-items-center header-transparent\">");
		out.append("<div class=\"container-fluid container-xl d-flex align-items-center justify-content-between\">");
		out.append("");
		out.append("<div class=\"logo d-flex align-items-center\">");
		out.append("<a href=\"Home?id="+acc.get_id()+"\"><img src=\"/MyWeb/img/logo_name.png\" alt=\"\" class=\"img-fluid\"></a>");
		out.append("</div>");
		out.append("");
		out.append("<nav id=\"navbar\" class=\"navbar order-last order-lg-0\">");
		out.append("<ul class=\"nav-left\">");
		out.append("<li><a class=\"nav-link scrollto active\" href=\"Home?id="+acc.get_id()+"#hero\">Trang chủ</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"About?id="+acc.get_id()+"\">Giới thiệu</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"Home?id="+acc.get_id()+"#portfolio\">Thực đơn</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"Home?id="+acc.get_id()+"#events\">Sự kiện</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"Home?id="+acc.get_id()+"#chefs\">Đầu bếp</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"#Home?id="+acc.get_id()+"#gallery\">Kho ảnh</a></li>");
		out.append("<li><a class=\"nav-link scrollto\" href=\"#Home?id="+acc.get_id()+"#contact\">Liên hệ</a></li>");
		out.append("</ul>");
		out.append("<ul class=\"nav-right\">");
		out.append("<li><a class=\"nav-link cart-icon\" href=\"Cart?id="+acc.get_id()+"\"><i class=\"fa-solid fa-cart-shopping\"></i><span class=\"cart-count\">0</span></a></li>");
		out.append("</ul>");
		out.append("<i class=\"bi bi-list mobile-nav-toggle\"></i>");
		out.append("</nav><!-- .navbar -->");
		out.append("");
		out.append("</div>");
		out.append("</header><!-- End Header -->");
		out.append("");
		out.append("");
		out.append("<!-- ======= Hero Section ======= -->");
		out.append("<section id=\"hero\">");
		out.append("<div class=\"hero-container\">");
		out.append("<div id=\"heroCarousel\" data-bs-interval=\"5000\" class=\"carousel slide carousel-fade\" data-bs-ride=\"carousel\">");
		out.append("");
		out.append("<ol class=\"carousel-indicators\" id=\"hero-carousel-indicators\"></ol>");
		out.append("");
		out.append("<div class=\"carousel-inner\" role=\"listbox\">");
		out.append("");
		out.append("<!-- Slide 1 -->");
		out.append("<div class=\"carousel-item active\" style=\"background-image: url(/MyWeb/img/slide/slide-1.jpg);\">");
		out.append("<div class=\"carousel-container\">");
		out.append("<div class=\"carousel-content\">");
		out.append("<h2 class=\"animate__animated animate__fadeInDown\">Nhà hàng <span>Tasty</span></h2>");
		out.append("<p class=\"animate__animated animate__fadeInUp\">Thỏa mãn niềm đam mê ẩm thực đỉnh cao</p>");
		out.append("<div>");
		out.append("<a href=\"#menu\" class=\"btn-menu animate__animated animate__fadeInUp scrollto\">Thực đơn</a>");
		out.append("<a href=\"#book-a-table\" class=\"btn-book animate__animated animate__fadeInUp scrollto\">Đặt bàn</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<!-- Slide 2 -->");
		out.append("<div class=\"carousel-item\" style=\"background-image: url(/MyWeb/img/slide/slide-2.jpg);\">");
		out.append("<div class=\"carousel-container\">");
		out.append("<div class=\"carousel-content\">");
		out.append("<h2 class=\"animate__animated animate__fadeInDown\">Nhà hàng <span>Tasty</span></h2>");
		out.append("<p class=\"animate__animated animate__fadeInUp\">Bản giao hưởng hài hòa của những hương vị tinh túy</p>");
		out.append("<div>");
		out.append("<a href=\"#menu\" class=\"btn-menu animate__animated animate__fadeInUp scrollto\">Thực đơn</a>");
		out.append("<a href=\"#book-a-table\" class=\"btn-book animate__animated animate__fadeInUp scrollto\">Đặt bàn</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<!-- Slide 3 -->");
		out.append("<div class=\"carousel-item\" style=\"background-image: url(/MyWeb/img/slide/slide-3.jpg);\">");
		out.append("<div class=\"carousel-container\">");
		out.append("<div class=\"carousel-content\">");
		out.append("<h2 class=\"animate__animated animate__fadeInDown\">Nhà hàng <span>Tasty</span></h2>");
		out.append("<p class=\"animate__animated animate__fadeInUp\">Mang đến những trải nghiệm ẩm thực ấn tượng nhất tại thủ đô Hà Nội</p>");
		out.append("<div>");
		out.append("<a href=\"#menu\" class=\"btn-menu animate__animated animate__fadeInUp scrollto\">Thực đơn</a>");
		out.append("<a href=\"#book-a-table\" class=\"btn-book animate__animated animate__fadeInUp scrollto\">Đặt bàn</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("<a class=\"carousel-control-prev\" href=\"#heroCarousel\" role=\"button\" data-bs-slide=\"prev\">");
		out.append("<span class=\"carousel-control-prev-icon bi bi-chevron-left\" aria-hidden=\"true\"></span>");
		out.append("</a>");
		out.append("");
		out.append("<a class=\"carousel-control-next\" href=\"#heroCarousel\" role=\"button\" data-bs-slide=\"next\">");
		out.append("<span class=\"carousel-control-next-icon bi bi-chevron-right\" aria-hidden=\"true\"></span>");
		out.append("</a>");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("</section><!-- End Hero -->");
		out.append("");
		out.append("<main id=\"main\">");
		out.append("");
		
		
		out.append("<!-- ======= Portfolio Section ======= -->");
        out.append("<section id=\"portfolio\" class=\"portfolio\">");
        out.append("");
        out.append("<div class=\"container\" data-aos=\"fade-up\">");
        out.append("");
        out.append("<header class=\"section-title\">");
        out.append("<h2><span>Thực đơn</span></h2>");
        out.append("<p>Chạm vào tinh hoa ẩm thực Việt với thực đơn đa dạng, phong phú mà đậm chất truyền thống Việt Nam tại Tasty.</p>");
        out.append("</header>");
        out.append("");
        out.append("<div class=\"row\" data-aos=\"fade-up\" data-aos-delay=\"100\">");
        out.append("<div class=\"col-lg-12 d-flex justify-content-center\">");
        out.append("<ul id=\"portfolio-flters\">");
        out.append("<li data-filter=\"*\" class=\"filter-active\">Tất cả</li>");
        out.append("<li data-filter=\".filter-1\">Bánh&Tráng Miệng</li>");
        out.append("<li data-filter=\".filter-2\">Món khai vị</li>");
        out.append("<li data-filter=\".filter-3\">Đồ uống</li>");
        out.append("</ul>");
        out.append("</div>");
        out.append("</div>");
        out.append("");
        

        // Tao doi tuong thuc thi chuc nang
        ProductFunction pf = new ProductFunctionImpl(cp);

        if (cp == null) {
            getServletContext().setAttribute("CPool", pf.getCP());
        }
        // Lay danh sach Product tu co so du lieu
        ArrayList<ProductObject> list1 = pf.getProducts(1);

        // Gan danh sach thuoc tinh vao thuoc tinh request
        request.setAttribute("product", list1);

        ArrayList<ProductObject> productList1 = (ArrayList<ProductObject>) request.getAttribute("product");



        out.append("<div class=\"row gy-4 portfolio-container\" data-aos=\"fade-up\" data-aos-delay=\"200\">");

        for (ProductObject itemObject : productList1) {
            // Ensure the product image path is correct
            String imgPath = "/MyWeb/img/menu/menu" + itemObject.getProductImg() + ".jpg";

            out.append("<div class=\"col-lg-4 col-md-6 portfolio-item filter-1\">");
            out.append("<div class=\"portfolio-wrap\">");
            out.append("<img src=\"" + imgPath + "\" class=\"img-fluid\" alt=\"\">");
            out.append("<div class=\"portfolio-info\">");
            out.append("<h4>" + itemObject.getProductName() + "</h4>");
            out.append("<p>" + itemObject.getProductPrice() + " đồng </p>");
            out.append("<div class=\"portfolio-links\">");
            out.append("<a href=\"AddProductItem?id="+id+"&productId="+itemObject.getProductId()+"\" class=\"add-to-cart-btn\" title=\"Thêm vào giỏ\">");
            out.append("<i class=\"fa-solid fa-cart-arrow-down\"></i>");
            out.append("</a>");
            out.append("<a href=\"ProductDetail?id="+ id+"&productId=" + itemObject.getProductId() + "\" title=\"Xem chi tiết\"><i class=\"fa-solid fa-circle-info\"></i></a>");
            out.append("</div>");
            out.append("</div>");
            out.append("</div>");
            out.append("</div>");
        }

     // Lay danh sach Product tu co so du lieu
        ArrayList<ProductObject> list2 = pf.getProducts(2);

        // Gan danh sach thuoc tinh vao thuoc tinh request
        request.setAttribute("product", list2);

        ArrayList<ProductObject> productList2 = (ArrayList<ProductObject>) request.getAttribute("product");

        
        out.append("<div class=\"row gy-4 portfolio-container\" data-aos=\"fade-up\" data-aos-delay=\"200\">");

        for (ProductObject itemObject : productList2) {
            // Ensure the product image path is correct
            String imgPath = "/MyWeb/img/menu/menu" + itemObject.getProductImg() + ".jpg";

            out.append("<div class=\"col-lg-4 col-md-6 portfolio-item filter-2\">");
            out.append("<div class=\"portfolio-wrap\">");
            out.append("<img src=\"" + imgPath + "\" class=\"img-fluid\" alt=\"\">");
            out.append("<div class=\"portfolio-info\">");
            out.append("<h4>" + itemObject.getProductName() + "</h4>");
            out.append("<p>" + itemObject.getProductPrice() + " đồng </p>");
            out.append("<div class=\"portfolio-links\">");
            out.append("<a href=\"AddProductItem?id="+id+"&productId="+itemObject.getProductId()+"\" class=\"add-to-cart-btn\" title=\"Thêm vào giỏ\">");
            out.append("<i class=\"fa-solid fa-cart-arrow-down\"></i>");
            out.append("</a>");
            out.append("<a href=\"ProductDetail?id="+ id+"&productId=" + itemObject.getProductId() + "\" title=\"Xem chi tiết\"><i class=\"fa-solid fa-circle-info\"></i></a>");
            out.append("</div>");
            out.append("</div>");
            out.append("</div>");
            out.append("</div>");
        }

        
     // Lay danh sach Product tu co so du lieu
        ArrayList<ProductObject> list3 = pf.getProducts(3);

        // Gan danh sach thuoc tinh vao thuoc tinh request
        request.setAttribute("product", list3);

        ArrayList<ProductObject> productList3 = (ArrayList<ProductObject>) request.getAttribute("product");

        
        out.append("<div class=\"row gy-4 portfolio-container\" data-aos=\"fade-up\" data-aos-delay=\"200\">");

        for (ProductObject itemObject : productList3) {
            // Ensure the product image path is correct
            String imgPath = "/MyWeb/img/menu/menu" + itemObject.getProductImg() + ".jpg";

            out.append("<div class=\"col-lg-4 col-md-6 portfolio-item filter-3\">");
            out.append("<div class=\"portfolio-wrap\">");
            out.append("<img src=\"" + imgPath + "\" class=\"img-fluid\" alt=\"\">");
            out.append("<div class=\"portfolio-info\">");
            out.append("<h4>" + itemObject.getProductName() + "</h4>");
            out.append("<p>" + itemObject.getProductPrice() + " đồng </p>");
            out.append("<div class=\"portfolio-links\">");
            out.append("<a href=\"AddProductItem?id="+id+"&productId="+itemObject.getProductId()+"\" class=\"add-to-cart-btn\" title=\"Thêm vào giỏ\">");
            out.append("<i class=\"fa-solid fa-cart-arrow-down\"></i>");
            out.append("</a>");
            out.append("<a href=\"ProductDetail?id="+ id+"&productId=" + itemObject.getProductId() + "\" title=\"Xem chi tiết\"><i class=\"fa-solid fa-circle-info\"></i></a>");
            out.append("</div>");
            out.append("</div>");
            out.append("</div>");
            out.append("</div>");
        }
        
        
        out.append("</div>");
        out.append("</section><!-- End Portfolio Section -->");
		out.append("");
		out.append("");
		out.append("");
		out.append("    <!-- ======= Events Section ======= -->");
		out.append("    <section id=\"events\" class=\"events\">");
		out.append("      <div class=\"container\">");
		out.append("");
		out.append("        <div class=\"section-title\">");
		out.append("          <h2>Tổ chức <span>Tiệc</span> tại nhà hàng</h2>");
		out.append("        </div>");
		out.append("");
		out.append("        <div class=\"events-slider swiper\">");
		out.append("          <div class=\"swiper-wrapper\">");
		out.append("");
		out.append("            <div class=\"swiper-slide\">");
		out.append("              <div class=\"row event-item\">");
		out.append("                <div class=\"col-lg-6\">");
		out.append("                  <img src=\"/MyWeb/img/event-birthday.jpg\" class=\"img-fluid\" alt=\"\">");
		out.append("                </div>");
		out.append("                <div class=\"col-lg-6 pt-4 pt-lg-0 content\">");
		out.append("                  <h3>Tiệc sinh nhật</h3>");
		out.append("                  <div class=\"price\">");
		out.append("                    <p><span>1.000.000 VND</span></p>");
		out.append("                  </div>");
		out.append("                  <p class=\"fst-italic\">");
		out.append("                    Mang đến không gian riêng tư, ấm cúng, thân mật cùng những trải nghiệm tuyệt vời cho gia đinh, Tasty Restaurant tự hào là điểm đến lý tưởng để tổ chức tiệc sinh nhật.");
		out.append("                  </p>");
		out.append("                  <ul>");
		out.append("                    <li><i class=\"bi bi-check-circle\"></i> 20+ concept sinh nhật và menu tiệc đầy ấn tượng.</li>");
		out.append("                    <li><i class=\"bi bi-check-circle\"></i> MC chuyên nghiệp mang lại sự sôi động và vui nhộn.</li>");
		out.append("                    <li><i class=\"bi bi-check-circle\"></i> Dành tặng miễn phí bánh sinh nhật</li>");
		out.append("                  </ul>");
		out.append("                  <p>");
		out.append("                    Dịch vụ tiệc sinh nhật trọn gói tại Tasty phù hợp cho các bữa tiệc từ 10 - 50 khách");
		out.append("                  </p>");
		out.append("                </div>");
		out.append("              </div>");
		out.append("            </div><!-- End testimonial item -->");
		out.append("");
		out.append("            <div class=\"swiper-slide\">");
		out.append("              <div class=\"row event-item\">");
		out.append("                <div class=\"col-lg-6\">");
		out.append("                  <img src=\"/MyWeb/img/event-private.jpg\" class=\"img-fluid\" alt=\"\">");
		out.append("                </div>");
		out.append("                <div class=\"col-lg-6 pt-4 pt-lg-0 content\">");
		out.append("                  <h3>Tiệc tại gia</h3>");
		out.append("                  <div class=\"price\">");
		out.append("                    <p><span>50.000.000</span></p>");
		out.append("                  </div>");
		out.append("                  <p class=\"fst-italic\">");
		out.append("                  Với sự linh động và chuyên nghiệp trong cung cách phục vụ cũng như chất lượng món ăn, Tasty Restaurant sẽ giúp những bữa tiệc tại công ty, tại nhà, hoặc thậm chí tổ chức ngoài trời của bạn trở nên hoàn hảo, trọn vẹn.");
		out.append("                  </p>");
		out.append("                  <ul>");
		out.append("                    <li><i class=\"bi bi-check-circle\"></i> Thực đơn lên tới hơn 300 món, đa dạng từ món Á - Âu.</li>");
		out.append("                    <li><i class=\"bi bi-check-circle\"></i> Nhận nhiều ưu đãi và tiết kiệm chi phí .</li>");
		out.append("                    <li><i class=\"bi bi-check-circle\"></i> 50+ concept trang trí đầy ấn tượng.</li>");
		out.append("                  </ul>");
		out.append("                  <p>");
		out.append("                  Mức giá trên chỉ áp dụng cho khâu trang trí. Giá sẽ tăng thêm tùy theo số lượng và set đồ ăn khách hàng lựa chọn");
		out.append("                  </p>");
		out.append("                </div>");
		out.append("              </div>");
		out.append("            </div><!-- End testimonial item -->");
		out.append("");
		out.append("            <div class=\"swiper-slide\">");
		out.append("              <div class=\"row event-item\">");
		out.append("                <div class=\"col-lg-6\">");
		out.append("                  <img src=\"/MyWeb/img/event-custom.jpg\" class=\"img-fluid\" alt=\"\">");
		out.append("                </div>");
		out.append("                <div class=\"col-lg-6 pt-4 pt-lg-0 content\">");
		out.append("                  <h3>Tiệc cưới</h3>");
		out.append("                  <div class=\"price\">");
		out.append("                    <p><span>80.000.000 VND</span></p>");
		out.append("                  </div>");
		out.append("                  <p class=\"fst-italic\">");
		out.append("                    Bằng chất lượng dịch vụ chuyên nghiệp cao cấp hàng đầu, chúng tôi sẽ thắp lên xúc cảm ngọt ngào cho ngày hạnh phúc và mang đến những chất liệu tuyệt vời để viết tiếp câu chuyện tình yêu bất tận.");
		out.append("                  </p>");
		out.append("                  <ul>");
		out.append("                    <li><i class=\"bi bi-check-circle\"></i> 20+ concept tiệc cưới và menu tiệc đầy ấn tượng.</li>");
		out.append("                    <li><i class=\"bi bi-check-circle\"></i> Tặng miễn phí bộ ảnh cưới gồm 15 concept chụp ảnh.</li>");
		out.append("                    <li><i class=\"bi bi-check-circle\"></i> Tặng miễn phí 3 tiết mục văn nghệ từ vũ đoàn WEDANCE .</li>");
		out.append("                  </ul>");
		out.append("                  <p>");
		out.append("                    Dịch vụ tiệc sinh nhật trọn gói tại Tasty phù hợp cho các bữa tiệc từ 30 - 200 khách");
		out.append("                  </p>");
		out.append("                </div>");
		out.append("              </div>");
		out.append("            </div><!-- End testimonial item -->");
		out.append("");
		out.append("          </div>");
		out.append("          <div class=\"swiper-pagination\"></div>");
		out.append("        </div>");
		out.append("");
		out.append("      </div>");
		out.append("    </section><!-- End Events Section -->");
		out.append("");
		out.append("<!-- ======= Gallery Section ======= -->");
		out.append("<section id=\"gallery\" class=\"gallery\">");
		out.append("<div class=\"container-fluid\">");
		out.append("");
		out.append("<div class=\"section-title\">");
		out.append("<h2>Một vài bức hình từ <span>Tasty Restaurant</span></h2>");
		out.append("<p>Không gian nhà hàng được thiết kế theo phong cách hiện đại pha lẫn cổ điển, mang đến không gian hoàn hảo.</p>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"row g-0\">");
		out.append("");
		out.append("<div class=\"col-lg-3 col-md-4\">");
		out.append("<div class=\"gallery-item\">");
		out.append("<a href=\"/MyWeb/img/gallery/gallery-1.jpg\" class=\"gallery-lightbox\">");
		out.append("<img src=\"/MyWeb/img/gallery/gallery-1.jpg\" alt=\"\" class=\"img-fluid\">");
		out.append("</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-3 col-md-4\">");
		out.append("<div class=\"gallery-item\">");
		out.append("<a href=\"/MyWeb/img/gallery/gallery-2.jpg\" class=\"gallery-lightbox\">");
		out.append("<img src=\"/MyWeb/img/gallery/gallery-2.jpg\" alt=\"\" class=\"img-fluid\">");
		out.append("</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-3 col-md-4\">");
		out.append("<div class=\"gallery-item\">");
		out.append("<a href=\"/MyWeb/img/gallery/gallery-3.jpg\" class=\"gallery-lightbox\">");
		out.append("<img src=\"/MyWeb/img/gallery/gallery-3.jpg\" alt=\"\" class=\"img-fluid\">");
		out.append("</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-3 col-md-4\">");
		out.append("<div class=\"gallery-item\">");
		out.append("<a href=\"/MyWeb/img/gallery/gallery-4.jpg\" class=\"gallery-lightbox\">");
		out.append("<img src=\"/MyWeb/img/gallery/gallery-4.jpg\" alt=\"\" class=\"img-fluid\">");
		out.append("</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-3 col-md-4\">");
		out.append("<div class=\"gallery-item\">");
		out.append("<a href=\"/MyWeb/img/gallery/gallery-5.jpg\" class=\"gallery-lightbox\">");
		out.append("<img src=\"/MyWeb/img/gallery/gallery-5.jpg\" alt=\"\" class=\"img-fluid\">");
		out.append("</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-3 col-md-4\">");
		out.append("<div class=\"gallery-item\">");
		out.append("<a href=\"/MyWeb/img/gallery/gallery-6.jpg\" class=\"gallery-lightbox\">");
		out.append("<img src=\"/MyWeb/img/gallery/gallery-6.jpg\" alt=\"\" class=\"img-fluid\">");
		out.append("</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-3 col-md-4\">");
		out.append("<div class=\"gallery-item\">");
		out.append("<a href=\"/MyWeb/img/gallery/gallery-7.jpg\" class=\"gallery-lightbox\">");
		out.append("<img src=\"/MyWeb/img/gallery/gallery-7.jpg\" alt=\"\" class=\"img-fluid\">");
		out.append("</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("<div class=\"col-lg-3 col-md-4\">");
		out.append("<div class=\"gallery-item\">");
		out.append("<a href=\"/MyWeb/img/gallery/gallery-8.jpg\" class=\"gallery-lightbox\">");
		out.append("<img src=\"/MyWeb/img/gallery/gallery-8.jpg\" alt=\"\" class=\"img-fluid\">");
		out.append("</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</section><!-- End Gallery Section -->");
		out.append("");
		out.append("    <!-- ======= Chefs Section ======= -->");
		out.append("    <section id=\"chefs\" class=\"chefs\">");
		out.append("      <div class=\"container\">");
		out.append("");
		out.append("        <div class=\"section-title\">");
		out.append("          <h2>Đầu Bếp <span>Nhóm 3</span></h2>");
		out.append("          <p>Tận tâm - Chuyên nghiệp - Hăng say học hỏi - Vươn tới thành công!.</p>");
		out.append("        </div>");
		out.append("");
		out.append("        <div class=\"row justify-content-center\">");
		out.append("          <div class=\"col-lg-3 col-md-3\">");
		out.append("            <div class=\"member\">");
		out.append("              <div class=\"pic pl-1\"><img src=\"/MyWeb/img/testimonials/viet.jpg\" class=\"img-fluid\" alt=\"\"></div>");
		out.append("              <div class=\"member-info\">");
		out.append("                <h4>Nguyễn Văn Việt</h4>");
		out.append("                <span>Bếp Trưởng</span>");
		out.append("                <div class=\"social\">");
		out.append("                  <a href=\"\"><i class=\"bi bi-twitter\"></i></a>");
		out.append("                  <a href=\"\"><i class=\"bi bi-facebook\"></i></a>");
		out.append("                  <a href=\"\"><i class=\"bi bi-instagram\"></i></a>");
		out.append("                  <a href=\"\"><i class=\"bi bi-linkedin\"></i></a>");
		out.append("                </div>");
		out.append("              </div>");
		out.append("            </div>");
		out.append("          </div>");
		out.append("");
		out.append("          <div class=\"col-lg-3 col-md-3\">");
		out.append("            <div class=\"member\">");
		out.append("              <div class=\"pic pr-1\"><img src=\"/MyWeb/img/testimonials/quan.png\" class=\"img-fluid\" alt=\"\"></div>");
		out.append("              <div class=\"member-info\">");
		out.append("                <h4>Nguyễn Hồng Quân</h4>");
		out.append("                <span>Bếp Trưởng</span>");
		out.append("                <div class=\"social\">");
		out.append("                  <a href=\"\"><i class=\"bi bi-twitter\"></i></a>");
		out.append("                  <a href=\"\"><i class=\"bi bi-facebook\"></i></a>");
		out.append("                  <a href=\"\"><i class=\"bi bi-instagram\"></i></a>");
		out.append("                  <a href=\"\"><i class=\"bi bi-linkedin\"></i></a>");
		out.append("                </div>");
		out.append("              </div>");
		out.append("            </div>");
		out.append("          </div>");
		out.append("");
		out.append("        </div>");
		out.append("");
		out.append("      </div>");
		out.append("    </section><!-- End Chefs Section -->");
		out.append("");
		out.append("	<!-- ======= Testimonials Section ======= -->");
		out.append("    <section id=\"testimonials\" class=\"testimonials\">");
		out.append("      <div class=\"container position-relative\">");
		out.append("");
		out.append("        <div class=\"testimonials-slider swiper\" data-aos=\"fade-up\" data-aos-delay=\"100\">");
		out.append("          <div class=\"swiper-wrapper\">");
		out.append("");
		out.append("            <div class=\"swiper-slide\">");
		out.append("              <div class=\"testimonial-item\">");
		out.append("                <img src=\"/MyWeb/img/testimonials/viet.jpg\" class=\"testimonial-img\" alt=\"\">");
		out.append("                <h3>Việt Nguyễn</h3>");
		out.append("                <h4>IT</h4>");
		out.append("                <div class=\"stars\">");
		out.append("                  <i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i>");
		out.append("                </div>");
		out.append("                <p>");
		out.append("                  <i class=\"bx bxs-quote-alt-left quote-icon-left\"></i>");
		out.append("                  Một nơi lý tưởng để tập trung với bạn bè. Không gian của quán vô cùng riêng tư, ấm cúng và không kém phần sang trọng.");
		out.append("                  <i class=\"bx bxs-quote-alt-right quote-icon-right\"></i>");
		out.append("                </p>");
		out.append("              </div>");
		out.append("            </div><!-- End testimonial item -->");
		out.append("");
		out.append("            <div class=\"swiper-slide\">");
		out.append("              <div class=\"testimonial-item\">");
		out.append("                <img src=\"/MyWeb/img/testimonials/hoaminzy.jfif\" class=\"testimonial-img\" alt=\"\">");
		out.append("                <h3>Hòa Minzy</h3>");
		out.append("                <h4>Ca sỹ</h4>");
		out.append("                <div class=\"stars\">");
		out.append("                  <i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i>");
		out.append("                </div>");
		out.append("                <p>");
		out.append("                  <i class=\"bx bxs-quote-alt-left quote-icon-left\"></i>");
		out.append("                  Món ăn ở đây thật sự là một kiệt tác! Hương vị tinh tế, cách trình bày đẹp mắt khiến mỗi món ăn đều trở thành một trải nghiệm tuyệt vời. Không gian nhà hàng cũng rất ấm cúng và sang trọng.");
		out.append("                  <i class=\"bx bxs-quote-alt-right quote-icon-right\"></i>");
		out.append("                </p>");
		out.append("              </div>");
		out.append("            </div><!-- End testimonial item -->");
		out.append("");
		out.append("            <div class=\"swiper-slide\">");
		out.append("              <div class=\"testimonial-item\">");
		out.append("                <img src=\"/MyWeb/img/testimonials/rose.jfif\" class=\"testimonial-img\" alt=\"\">");
		out.append("                <h3>Rose</h3>");
		out.append("                <h4>Idol-KPOP</h4>");
		out.append("                <div class=\"stars\">");
		out.append("                  <i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i>");
		out.append("                </div>");
		out.append("                <p>");
		out.append("                  <i class=\"bx bxs-quote-alt-left quote-icon-left\"></i>");
		out.append("                  I've dined at many restaurants, but the flavors here are truly unique. Each dish is carefully prepared with fresh ingredients, harmoniously combined to create a wonderful culinary symphony.");
		out.append("                  <i class=\"bx bxs-quote-alt-right quote-icon-right\"></i>");
		out.append("                </p>");
		out.append("              </div>");
		out.append("            </div><!-- End testimonial item -->");
		out.append("");
		out.append("            <div class=\"swiper-slide\">");
		out.append("              <div class=\"testimonial-item\">");
		out.append("                <img src=\"/MyWeb/img/testimonials/sontung.jpg\" class=\"testimonial-img\" alt=\"\">");
		out.append("                <h3>Sơn Tùng</h3>");
		out.append("                <h4>Ca sỹ</h4>");
		out.append("                <div class=\"stars\">");
		out.append("                  <i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i>");
		out.append("                </div>");
		out.append("                <p>");
		out.append("                  <i class=\"bx bxs-quote-alt-left quote-icon-left\"></i>");
		out.append("					Món ăn ở đây không chỉ ngon miệng mà còn đẹp mắt như một tác phẩm nghệ thuật. Tôi đặc biệt ấn tượng với cách kết hợp màu sắc và hình dáng của các món ăn.                  <i class=\"bx bxs-quote-alt-right quote-icon-right\"></i>");
		out.append("                </p>");
		out.append("              </div>");
		out.append("            </div><!-- End testimonial item -->");
		out.append("");
		out.append("            <div class=\"swiper-slide\">");
		out.append("              <div class=\"testimonial-item\">");
		out.append("                <img src=\"/MyWeb/img/testimonials/model.jfif\" class=\"testimonial-img\" alt=\"\">");
		out.append("                <h3>H'hen Niê</h3>");
		out.append("                <h4>Model</h4>");
		out.append("                <div class=\"stars\">");
		out.append("                  <i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i><i class=\"bi bi-star-fill\"></i>");
		out.append("                </div>");
		out.append("                <p>");
		out.append("                  <i class=\"bx bxs-quote-alt-left quote-icon-left\"></i>");
		out.append("				Không chỉ đồ ăn ngon, cách bài trí nhà hàng cũng rất ấn tượng. Không gian sang trọng, ánh sáng dịu nhẹ, âm nhạc du dương tạo nên một bầu không khí lãng mạn và thư thái.                  <i class=\"bx bxs-quote-alt-right quote-icon-right\"></i>");
		out.append("                </p>");
		out.append("              </div>");
		out.append("            </div><!-- End testimonial item -->");
		out.append("");
		out.append("          </div>");
		out.append("          <div class=\"swiper-pagination\"></div>");
		out.append("        </div>");
		out.append("");
		out.append("      </div>");
		out.append("    </section><!-- End Testimonials Section -->");
		out.append("	");
		out.append("    ");
;
		out.append("	<section id=\"book-a-table\" class=\"book-a-table\">");
		out.append("  <div class=\"container\" data-aos=\"fade-up\">");
		out.append("");
		out.append("    <div class=\"section-title\">");
		out.append("      <h2>Liên lạc <span>Tasty</span></h2>");
		out.append("      <p>Hãy Trải Nghiệm <span>Dịch Vụ</span> Của Tasty</p>");
		out.append("    </div>");
		out.append("      <div class=\"container\">");
		out.append("    <div class=\"row g-12\">");
		out.append("");
		out.append("");
		out.append("	  <div class=\"col-lg-4 reservation-img\" style=\"background-image: url(/MyWeb/img/reservation.png);\"></div>");
		out.append("      <div class=\"col-lg-8 d-flex align-items-center reservation-form-bg\">");
		out.append("        <form action=\"#hero\" method=\"post\" data-aos=\"fade-up\" data-aos-delay=\"100\" style=\"padding: 30px;\"> <div class=\"row gy-4\">");
		out.append("            <div class=\"col-lg-4 col-md-6\">");
		out.append("              <input type=\"text\" name=\"name\" class=\"form-control\" value=\""+acc.getFirst_name()+"\" id=\"name\" placeholder=\"Họ và tên\" readonly style=\"background-color: #f5f5f5;\">");
		out.append("            </div>");
//		out.append("            <div class=\"col-lg-4 col-md-6\">");
//		out.append("              <input type=\"email\" class=\"form-control\" name=\"email\" id=\"email\" placeholder=\"Email\">");
//		out.append("            </div>");
//		out.append("            <div class=\"col-lg-4 col-md-6\">");
//		out.append("              <input type=\"text\" class=\"form-control\" name=\"phone\" id=\"phone\" placeholder=\"Số điện thoại\">");
//		out.append("            </div>");
		out.append("            <div class=\"col-lg-4 col-md-6\">");
		out.append("				<select class=\"form-select\" id=\"floatingSelect\" name=\"dichvu\" aria-label=\"Dịch vụ\">");
		out.append("	  				<option value=\"18\"selected>Tiệc cưới</option>");
		out.append("	  				<option value=\"19\">Tiệc tại gia</option>");
		out.append("	  				<option value=\"20\">Tiệc sinh nhật</option>");
		out.append("				</select>");
		out.append("            </div>");
		out.append("            <div class=\"col-lg-4 col-md-6\">");
		out.append("              <input type=\"number\" class=\"form-control\" name=\"people\" id=\"people\" placeholder=\"Số người tham dự\">");
		out.append("            </div>");
		out.append("            <div class=\"col-lg-4 col-md-6\">");
		out.append("              <input type=\"text\" name=\"date\" class=\"form-control\" id=\"date\" placeholder=\"Ngày (YYYY-MM-DD)\">");
		out.append("            </div>");
		out.append("            <div class=\"col-lg-8 col-md-6\">");
		out.append("              <input type=\"text\" class=\"form-control\" name=\"time\" id=\"time\" placeholder=\"Thời gian (VD: 8:30 PM / 8:20 AM)\">");
		out.append("            </div>");
		out.append("          </div>");
		out.append("          <div class=\"form-group mt-3\">");
		out.append("            <textarea class=\"form-control\" name=\"message\" rows=\"9\" placeholder=\"Nội dung\"></textarea>");
		out.append("          </div>");
		out.append("			");
		out.append("          <div class=\"text-center send-mess\">");
		out.append("			<input type=\"submit\" value=\"Đặt bàn\" name=\"datban\">");
		out.append("		  </div>");
		out.append("        </form>");
		out.append("      </div></div>");
		out.append("</div>");
		out.append("  </div>");
		out.append("</section>");
		out.append("  ");
		out.append("  ");
		out.append("  </main><!-- End #main -->");
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
		out.append("<script src=\"/MyWeb/js/tien.js\"></script>");

//		out.append("<script src=\"/MyWeb/js/cart.js\"></script>");
		
		out.append("");
		out.append("</body>");
		out.append("");
		out.append("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		AccountFunctionImp oper = new AccountFunctionImp(null);
//		String idAcc = request.getParameter("id");
//		String pass = request.getParameter("pass");
//		Account acc = oper.getAccount(idAcc, pass);
//		response.sendRedirect("Home?id="+acc.get_id());
		
//		String idUser = request.getParameter("id");
//        String productIdStr = request.getParameter("productId");
//		
//     // Tim bo quan ly ket noi
//        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
//        
//		CartFunctionImpl cf = new CartFunctionImpl(cp);
//		if (cp == null) {
//            getServletContext().setAttribute("CPool", cf.getCP());
//        }
//		ProductFunctionImpl pf = new ProductFunctionImpl(cp);
//		if (cp == null) {
//            getServletContext().setAttribute("CPool", pf.getCP());
//        }
//		CartItemObject cio = new CartItemObject();
//		CartObject co = new CartObject();
//		
//		int userIdInt = Integer.parseInt(idUser);
//		int productIdInt = Integer.parseInt(productIdStr);
//		
//		ProductObject product = pf.getProduct(productIdInt);
//		product.setProductQuantity(product.getProductQuantity()-1);
//		pf.editProduct(product);
//		
//		 co = cf.getCartByUserId(userIdInt);
//		 
//		 cio.setCartId(co.getCartId());
//		 cio.setCartItemQuantity(1);
//		 cio.setProductId(productIdInt);
//		 cf.addCartItem(cio);
//		
//		 response.sendRedirect("Home?id="+idUser);
		
		
		
		String id = request.getParameter("id");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int people = Integer.parseInt(request.getParameter("people"));
		String message = request.getParameter("message");
		String product_id = request.getParameter("dichvu");
		String datban = request.getParameter("datban");
		
		try {
			if (datban != null) {
				BillFunctionImp operation = new BillFunctionImp(null);
				Bill bill = new Bill(id,date, time,product_id, people, message, 1);
				operation.addBill(bill);
				response.sendRedirect("Home?id="+id+"");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
