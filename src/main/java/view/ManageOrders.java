package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Account;
import object.OrderDetail;
import user.AccountFunctionImp;
import user.OrderFunction;
import user.OrderFunctionImpl;
import util.ConnectionPool;
import util.ConnectionPoolImpl;
/**
 * Servlet implementation class ManageOrders
 */
@WebServlet("/ManageOrders")
public class ManageOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset = utf-8;";     
	private ConnectionPoolImpl connectionPool;
	
	public void init() {
        connectionPool = new ConnectionPoolImpl();
    }
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ManageOrders() {
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
		
		ArrayList<Account> temp = null;
		AccountFunctionImp user = new AccountFunctionImp(null);
		ArrayList<Account> list = user.getAccounts();
		String id = request.getParameter("id");
		if(list != null) {
			temp = list;
		}
	
		// Tạo JSON object để lưu trữ dữ liệu biểu đồ
        List<Integer> revenueData = new ArrayList<>();
        List<String> monthLabels = new ArrayList<>();

        // Kết nối CSDL và truy vấn dữ liệu
        try (Connection conn = connectionPool.getConnection("BarChartServlet")) {
            String sql = "SELECT SUBSTRING(order_created_date, 4, 2) AS month, "
                       + "SUM(order_total_price + order_ship_price) AS revenue "
                       + "FROM tblorder "
                       + "GROUP BY SUBSTRING(order_created_date, 4, 2)";

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int revenue = rs.getInt("revenue");
                revenueData.add(revenue);
                String monthLabel = rs.getString("month");
                monthLabels.add(monthLabel);
            }

            // Đóng ResultSet và PreparedStatement
            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		out.append("<!DOCTYPE html>");
		out.append("<html lang=\"en\">");
		out.append("");
		out.append("<head>");
		out.append("<meta charset=\"utf-8\">");
		out.append("<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">");
		out.append("");
		out.append("<title>Trang quản lý | Cửa hàng Tasty</title>");
		out.append("<meta content=\"\" name=\"description\">");
		out.append("<meta content=\"\" name=\"keywords\">");
		out.append("");
		out.append("<!-- Favicons -->");
		out.append("<link href=\"/MyWeb/img/logo1.png\" rel=\"icon\">");
		out.append("<link href=\"/MyWeb/img/apple_logo.png\" rel=\"apple-touch-icon\">");
		out.append("<link rel=\"icon\" type=\"/MyWeb/img/android.png\" href=\"android-chrome-192x192.png\">");
		out.append("");
		out.append("<!-- Google Fonts -->");
		out.append("<link href=\"https://fonts.gstatic.com\" rel=\"preconnect\">");
		out.append("<link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- Vendor CSS Files -->");
		out.append("<link href=\"/MyWeb/css/all.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/bootstrap-icons.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/boxicons.min.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/quill.snow.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/quill.bubble.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/remixicon.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/styleAdmin2.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("<!-- Template Main CSS File -->");
		out.append("<link href=\"/MyWeb/css/styleAdmin1.css\" rel=\"stylesheet\">");
		out.append("<link href=\"/MyWeb/css/chart.css\" rel=\"stylesheet\">");

		out.append("");
		out.append("<!-- =======================================================");
		out.append("* Template Name: NiceAdmin");
		out.append("* Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/");
		out.append("* Updated: Apr 20 2024 with Bootstrap v5.3.3");
		out.append("* Author: BootstrapMade.com");
		out.append("* License: https://bootstrapmade.com/license/");
		out.append("======================================================== -->");
		out.append("</head>");
		out.append("");
		out.append("<body>");
		out.append("");
		out.append("<!-- ======= Header ======= -->");
		out.append("<header id=\"header\" class=\"header fixed-top d-flex align-items-center\">");
		out.append("");
		out.append("<div class=\"d-flex align-items-center justify-content-between\">");
		out.append("<a href=\"index.html\" class=\"logo d-flex align-items-center\">");
		out.append("<span class=\"d-none d-lg-block\">Cửa hàng Tasty</span>");
		out.append("</a>");
		out.append("<i class=\"bi bi-list toggle-sidebar-btn\"></i>");
		out.append("</div><!-- End Logo -->");
		out.append("");
		out.append("<div class=\"search-bar\">");
		out.append("<form class=\"search-form d-flex align-items-center\" method=\"POST\" action=\"#\">");
		out.append("<input type=\"text\" name=\"query\" placeholder=\"Search\" title=\"Enter search keyword\">");
		out.append("<button type=\"submit\" title=\"Search\"><i class=\"bi bi-search\"></i></button>");
		out.append("</form>");
		out.append("</div><!-- End Search Bar -->");
		out.append("");
		out.append("<nav class=\"header-nav ms-auto\">");
		out.append("<ul class=\"d-flex align-items-center\">");
		out.append("");
		out.append("<li class=\"nav-item d-block d-lg-none\">");
		out.append("<a class=\"nav-link nav-icon search-bar-toggle \" href=\"#\">");
		out.append("<i class=\"bi bi-search\"></i>");
		out.append("</a>");
		out.append("</li><!-- End Search Icon-->");
		out.append("");
		out.append("");
		out.append("");
		out.append("<!-- End Notification Nav -->");
		out.append("");
		out.append("<!-- End Messages Nav -->");
		out.append("");
		out.append("        <li class=\"nav-item dropdown pe-3\">");
		out.append("");
		out.append("          <a class=\"nav-link nav-profile d-flex align-items-center pe-0\" href=\"#\" data-bs-toggle=\"dropdown\">");
		out.append("<i class=\"fa-solid fa-user rounded-circle\"></i>");
		out.append("            <span class=\"d-none d-md-block dropdown-toggle ps-2\">Admin</span>");
		out.append("          </a><!-- End Profile Iamge Icon -->");
		out.append("");
		out.append("          <ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow profile\">");
		out.append("            <li class=\"dropdown-header\">");
		out.append("              <h6>Admin</h6>");
		out.append("              <span>IT</span>");
		out.append("            </li>");
		out.append("            <li>");
		out.append("              <hr class=\"dropdown-divider\">");
		out.append("            </li>");
		out.append("");
		out.append("");
		out.append("            <li>");
		out.append("              <a class=\"dropdown-item d-flex align-items-center\" href=\"login\">");
		out.append("                <i class=\"bi bi-box-arrow-right\"></i>");
		out.append("                <span>Thoát</span>");
		out.append("              </a>");
		out.append("            </li>");
		out.append("");
		out.append("          </ul><!-- End Profile Dropdown Items -->");
		out.append("        </li><!-- End Profile Nav -->");
		out.append("");
		out.append("      </ul>");
		out.append("    </nav><!-- End Icons Navigation -->");
		out.append("");
		out.append("  </header><!-- End Header -->");
		out.append("");
		out.append("  <!-- ======= Sidebar ======= -->");
		out.append("  <aside id=\"sidebar\" class=\"sidebar\">");
		out.append("");
		out.append("    <ul class=\"sidebar-nav\" id=\"sidebar-nav\">");
		out.append("      <li class=\"nav-item\">");
		out.append("        <a class=\"nav-link collapsed\" href=\"DashBoard?id="+id+"\">");
		out.append("          <i class=\"bi bi-grid\"></i><span>Dashboard</span>");
		out.append("        </a>");
		out.append("        <a class=\"nav-link collapsed\" href=\"AccountManagermentSection?id="+id+"\">");
		out.append("          <i class=\"bi bi-layout-text-window-reverse\"></i><span>Quản lý tài khoản </span>");
		out.append("        </a>");
		out.append("		<a class=\"nav-link collapsed\" href=\"ManageOrders?id="+id+"\">");
		out.append("			<i class=\"fa-solid fa-receipt\"></i>");
		out.append("			<span class=\"ms-3\">Hóa đơn</span>");
		out.append("		</a>");
		out.append("      </li><!-- End Tables Nav -->");
		out.append("	  ");
		out.append("    </ul>");
		out.append("");
		out.append("  </aside><!-- End Sidebar-->");
		out.append("");
		out.append("<main id=\"main\" class=\"main\">");
		out.append("    <div class=\"pagetitle\">");
		out.append("      <h1>Quản lý hóa đơn</h1>");
		out.append("      <nav>");
		out.append("        <ol class=\"breadcrumb\">");
		out.append("          <li class=\"breadcrumb-item\"><a href=\"DashBoard?id="+id+"\">Trang chủ</a></li>");
		out.append("          <li class=\"breadcrumb-item active\">Quản lý hóa đơn</li>");
		out.append("        </ol>");
		out.append("      </nav>");
		out.append("    </div><!-- End Page Title -->");
		out.append("");


	      // In ra dữ liệu và script biểu đồ vào HTML
        out.println("<section class=\"section\">");
        out.println("<div>");
        out.println("<div class=\"card\">");
        out.println("<div class=\"card-body\">");
        out.println("<h5 class=\"card-title\">Mô hình dự báo doanh thu</h5>");
        out.println("<div id=\"barChart\"></div>");
        out.println("<script>");
        out.println("document.addEventListener(\"DOMContentLoaded\", () => {");
        out.println("  new ApexCharts(document.querySelector(\"#barChart\"), {");
        out.println("    series: [{");
        out.println("      name: \"Doanh thu\",");
        out.println("      data: " + revenueData.toString());
        out.println("    }],");
        out.println("    chart: {");
        out.println("      height: 400,");
//        out.println("      width: '100%',");
        out.println("      type: 'bar',");
        out.println("    },");
        out.println("    plotOptions: {");
        out.println("      bar: {");
        out.println("        horizontal: false,");
        out.println("        columnWidth: '55%',");
        out.println("        endingShape: 'rounded'");
        out.println("      },");
        out.println("    },");
        out.println("    dataLabels: { enabled: false },");
        out.println("    stroke: {");
        out.println("      show: true,");
        out.println("      width: 2,");
        out.println("      colors: ['transparent']");
        out.println("    },");
        out.println("    xaxis: {");
        out.println("      categories: " + monthLabels.toString());
        out.println("    },");
        out.println("    yaxis: {");
        out.println("      title: {");
        out.println("        text: 'Doanh thu (VNĐ)'");
        out.println("      }");
        out.println("    },");
        out.println("    fill: {");
        out.println("      opacity: 1");
        out.println("    },");
        out.println("    tooltip: {");
        out.println("      enabled: true,");
        out.println("    }");
        out.println("  }).render();");
        out.println("});");
        out.println("</script>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</section>");
		
		
		out.append("<section class=\"section\">");
		out.append("<div class=\"row\">");
		out.append("<div class=\"col-lg-12\">");
		out.append("");
		out.append("<div class=\"card\">");
		out.append("<div class=\"card-body\">");
		out.append("");
		out.append("<!-- Table with stripped rows -->");
		out.append("<table class=\"table datatable\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th>Mã hóa đơn</th>");
		out.append("<th>Tên khách hàng</th>");
		out.append("<th>Địa chỉ</th>");
		out.append("<th>Email</th>");
		out.append("<th>Số điện thoại</th>");
		out.append("<th data-type=\"date\" data-format=\"DD/MM/YYYY\">Ngày xuất</th>");
		out.append("<th>Phương thức</th>");
		out.append("<th>Trạng thái</th>");
		out.append("<th>Tổng tiền</th>");
		out.append("");
		out.append("<th>Hành động</th>");
		out.append("</tr>");
		out.append("</thead>");
		
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		OrderFunction of = new OrderFunctionImpl(cp);
		if (cp==null) {
			getServletContext().setAttribute("CPool", of.getCP());
		}
		
		ArrayList<OrderDetail> list1 = of.getOrders();
		
		request.setAttribute("order", list1);
		ArrayList<OrderDetail> orderDetails = (ArrayList<OrderDetail>) request.getAttribute("order");
		
		out.append("<tbody>");
		
		for(OrderDetail item : orderDetails) {
			out.append("<tr>");
			out.append("<td>"+ item.getOrderId() +"</td>");
			out.append("<td>"+ item.getCustomerName() +"</td>");
			out.append("<td>"+ item.getOrderAddressShipping() +"</td>");
			out.append("<td>"+ item.getEmail() +"</td>");
			out.append("<td>"+ item.getPhone() +"</td>");
			out.append("<td>"+ item.getOrderCreatedDate() +"</td>");
			out.append("<td>"+ item.getPaymentMethod() +"</td>");
			out.append("<td>"+ item.getOrderStatus() +"</td>");
			out.append("<td>"+ (item.getOrderTotalPrice()+ item.getOrderShipPrice()) +"</td>");
            out.append("<td>");
            out.append("<form action='ManageOrders' method='post'>");
            out.append("<input type='hidden' name='action' value='delete'>");
            out.append("<input type='hidden' name='orderId' value='").append(String.valueOf(item.getOrderId())).append("'>");
            out.append("<button type='submit'>Xóa</button>");
            out.append("</form>");
            out.append("</td>");
			out.append("</tr>");
			out.append("");
		}
		

		out.append("</tbody>");
		out.append("</table>");
		
		of.releaseConnection();
		
		out.append("<!-- End Table with stripped rows -->");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("");
		out.append("</div>");
		out.append("</div>");
		out.append("</section>");
		
		out.append("<div class=\"modal fade\" id=\"invoiceModal\" tabindex=\"-1\" aria-labelledby=\"invoiceModalLabel\" aria-hidden=\"true\">");
		out.append("<div class=\"modal-dialog modal-lg\">");
		out.append("<div class=\"modal-content\">");
		out.append("<div class=\"modal-header\">");
		out.append("<h5 class=\"modal-title\" id=\"invoiceModalLabel\">Chi tiết hóa đơn</h5>");
		out.append("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
		out.append("</div>");
		out.append("<div class=\"modal-body\" id=\"invoiceModalBody\"></div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</main><!-- End #main -->");
		out.append("");
		out.append("<!-- ======= Footer ======= -->");
		out.append("<footer id=\"footer\" class=\"footer\">");
		out.append("<div class=\"copyright\">");
		out.append("&copy; Copyright <strong><span>NHQ</span></strong>. All Rights Reserved");
		out.append("</div>");
		out.append("<div class=\"credits\">");
		out.append("<!-- All the links in the footer should remain intact. -->");
		out.append("<!-- You can delete the links only if you purchased the pro version. -->");
		out.append("<!-- Licensing information: https://bootstrapmade.com/license/ -->");
		out.append("<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->");
		out.append("Designed by Quan");
		out.append("</div>");
		out.append("</footer><!-- End Footer -->");
		out.append("");
		out.append("<a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>");
		out.append("");
		out.append("<!-- Vendor JS Files -->");
		out.append("<script src=\"/MyWeb/js/apexcharts.min.js\"></script>");
		out.append("<script src=\"/MyWeb/js/bootstrap.bundle.min.js\"></script>");
		out.append("<script src=\"/MyWeb/js/chart.umd.js\"></script>");
		out.append("<script src=\"/MyWeb/js/echarts.min.js\"></script>");
		out.append("<script src=\"/MyWeb/js/quill.js\"></script>");
		out.append("<script src=\"/MyWeb/js/simple-datatables.js\"></script>");
		out.append("<script src=\"/MyWeb/js/tinymce.min.js\"></script>");
		out.append("<script src=\"/MyWeb/js/all.min.js\"></script>");
		out.append("");
		out.append("<!-- Template Main JS File -->");
		out.append("<script src=\"/MyWeb/js/mainAdmin.js\"></script>");
		out.append("");
		out.append("");
		out.append("");
		out.append("</body>");
		out.append("");
		out.append("</html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        // Xử lý yêu cầu xóa đơn hàng
        if ("delete".equals(request.getParameter("action"))) {
            int orderId = Integer.parseInt(request.getParameter("orderId"));

            ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
            OrderFunction of = new OrderFunctionImpl(cp);
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);

         // Xóa đơn hàng từ CSDL
            if (of.delOrder(orderDetail)) {
                request.setAttribute("message", "Đã xóa đơn hàng thành công!");
            } else {
                request.setAttribute("message", "Không thể xóa đơn hàng!");
            }
            
            // Giải phóng tài nguyên
            of.releaseConnection();
        }
        
        // Chuyển hướng đến trang quản lý đơn hàng
        response.sendRedirect("/MyWeb/ManageOrders");
    }

}
