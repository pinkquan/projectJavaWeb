package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.*;
import user.*;
import util.*;
/**
 * Servlet implementation class AccountManagermentSection
 */
@WebServlet("/AccountManagermentSection")
public class AccountManagermentSection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountManagermentSection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Account> temp = null;
		AccountFunctionImp user = new AccountFunctionImp(null);
		ArrayList<Account> list = user.getAccounts();
		String id = request.getParameter("id");
		if(list != null) {
			temp = list;
		}
		
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>");
		out.append("<html lang=\"en\">");
		out.append("");
		out.append("<head>");
		out.append("  <meta charset=\"utf-8\">");
		out.append("  <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">");
		out.append("");
		out.append("  <title>Quản lý tài khoản</title>");
		out.append("  <meta content=\"\" name=\"description\">");
		out.append("  <meta content=\"\" name=\"keywords\">");
		out.append("");
		out.append("  <!-- Favicons -->");
		out.append("  <link href=\"/MyWeb/img/logo.jpg\" rel=\"icon\">");
		out.append("  <link href=\"/MyWeb/img/logo.png\" rel=\"apple-touch-icon\">");
		out.append("");
		out.append("  <!-- Google Fonts -->");
		out.append("  <link href=\"https://fonts.gstatic.com\" rel=\"preconnect\">");
		out.append("  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">");
		out.append("");
		out.append("  <!-- Vendor CSS Files -->");
		out.append("  <link href=\"/MyWeb/css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"/MyWeb/css/all.min.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"/MyWeb/css/bootstrap-icons.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"/MyWeb/css/boxicons.min.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"/MyWeb/css/quill.snow.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"/MyWeb/css/quill.bubble.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"/MyWeb/css/remixicon.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"/MyWeb/css/styleDb.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("  <!-- Template Main CSS File -->");
		out.append("  <link href=\"/MyWeb/css/styleAdmin.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("  <!-- =======================================================");
		out.append("  * Template Name: NiceAdmin");
		out.append("  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/");
		out.append("  * Updated: Apr 20 2024 with Bootstrap v5.3.3");
		out.append("  * Author: BootstrapMade.com");
		out.append("  * License: https://bootstrapmade.com/license/");
		out.append("  ======================================================== -->");
		out.append("</head>");
		out.append("");
		out.append("<body>");
		out.append("");
		out.append("  <!-- ======= Header ======= -->");
		out.append("  <header id=\"header\" class=\"header fixed-top d-flex align-items-center\">");
		out.append("");
		out.append("    <div class=\"d-flex align-items-center justify-content-between\">");
		out.append("      <a href=\"index.html\" class=\"logo d-flex align-items-center\">");
		out.append("        <img src=\"/MyWeb/img/logo.png\" alt=\"\">");
		out.append("        <span class=\"d-none d-lg-block\">Tasty</span>");
		out.append("      </a>");
		out.append("      <i class=\"bi bi-list toggle-sidebar-btn\"></i>");
		out.append("    </div><!-- End Logo -->");
		out.append("");
		out.append("    <div class=\"search-bar\">");
		out.append("      <form class=\"search-form d-flex align-items-center\" method=\"POST\" action=\"#\">");
		out.append("        <input type=\"text\" name=\"query\" placeholder=\"Search\" title=\"Enter search keyword\">");
		out.append("        <button type=\"submit\" title=\"Search\"><i class=\"bi bi-search\"></i></button>");
		out.append("      </form>");
		out.append("    </div><!-- End Search Bar -->");
		out.append("");
		out.append("    <nav class=\"header-nav ms-auto\">");
		out.append("      <ul class=\"d-flex align-items-center\">");
		out.append("");
		out.append("        <li class=\"nav-item d-block d-lg-none\">");
		out.append("          <a class=\"nav-link nav-icon search-bar-toggle \" href=\"#\">");
		out.append("            <i class=\"bi bi-search\"></i>");
		out.append("          </a>");
		out.append("        </li><!-- End Search Icon-->");
		out.append("");
		out.append("        <li class=\"nav-item dropdown\">");
		out.append("");
		out.append("          <a class=\"nav-link nav-icon\" href=\"#\" data-bs-toggle=\"dropdown\">");
		out.append("            <i class=\"bi bi-bell\"></i>");
		out.append("            <!-- <span class=\"badge bg-primary badge-number\">4</span> -->");
		out.append("          </a><!-- End Notification Icon -->");
		out.append("");
		out.append("          <ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications\">");
		out.append("            <li class=\"dropdown-header\">");
		out.append("              Bạn không có thông báo nào");
		out.append("              <!-- <a href=\"#\"><span class=\"badge rounded-pill bg-primary p-2 ms-2\">View all</span></a> -->");
		out.append("            </li>");
		out.append("");
		out.append("          </ul><!-- End Notification Dropdown Items -->");
		out.append("");
		out.append("        </li><!-- End Notification Nav -->");
		out.append("");
		out.append("        <li class=\"nav-item dropdown\">");
		out.append("");
		out.append("          <a class=\"nav-link nav-icon\" href=\"#\" data-bs-toggle=\"dropdown\">");
		out.append("            <i class=\"bi bi-chat-left-text\"></i>");
		out.append("            <!-- <span class=\"badge bg-success badge-number\">3</span> -->");
		out.append("          </a><!-- End Messages Icon -->");
		out.append("");
		out.append("          <ul class=\"dropdown-menu dropdown-menu-end dropdown-menu-arrow messages\">");
		out.append("            <li class=\"dropdown-header\">");
		out.append("              Bạn không có tin nhắn nào");
		out.append("            </li>");
		out.append("");
		out.append("          </ul><!-- End Messages Dropdown Items -->");
		out.append("");
		out.append("        </li><!-- End Messages Nav -->");
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
		out.append("	  ");
		out.append("    </ul>");
		out.append("");
		out.append("  </aside><!-- End Sidebar-->");
		out.append("");
		out.append("  <main id=\"main\" class=\"main\">");
		out.append("");
		out.append("    <div class=\"pagetitle\">");
		out.append("      <h1>Quản lý tài khoản</h1>");
		out.append("      <nav>");
		out.append("        <ol class=\"breadcrumb\">");
		out.append("          <li class=\"breadcrumb-item\"><a href=\"DashBoard?id="+id+"\">Trang chủ</a></li>");
		out.append("          <li class=\"breadcrumb-item active\">Quản lý tài khoản</li>");
		out.append("        </ol>");
		out.append("      </nav>");
		out.append("    </div><!-- End Page Title -->");
		out.append("	");
		out.append("	<section class=\"section\">");
		out.append("      <div class=\"row\">");
		out.append("        <div class=\"col-sm-12\">");
		out.append("");
		out.append("          <div class=\"card\">");
		out.append("            <div class=\"card-body\">");
		out.append("              <h5 class=\"card-title\">Danh sách tài khoản</h5>");
		out.append("			  <a href=\"RegisterForm?id="+id+"\" name=\"add\"  class=\"btn btn-primary\"><i class=\"bi bi-plus-circle\"></i> Thêm</a>");
		out.append("              <!-- Table with stripped rows -->");
		out.append("              <table class=\"table datatable\">");
		out.append("                <thead>");
		out.append("                  <tr>");
		out.append("                    <th>ID</th>");
		out.append("                    <th>Password</th>");
		out.append("					<th>Address</th>");
		out.append("					<th>Email</th>");
		out.append("					<th>Phone</th>");
		out.append("                    <th data-type=\"date\" data-format=\"YYYY/DD/MM\">Birth</th>");
		out.append("					<th>Role</th>");
		out.append("					<th>Status</th>");
		out.append("                    <th></th>");
		out.append("					<th></th>");
		out.append("                  </tr>");
		out.append("                </thead>");
		out.append("                <tbody>");
		if(temp != null) {
			int index = 0;
			for (Account acc :temp) {
				out.append("                  <tr data-id =" + index++ + "  >");
				out.append("                    <td>"+acc.get_id()+"</td>");
				out.append("                    <td>"+acc.getPassword()+"</td>");
				out.append("                    <td>"+acc.getAddress()+"</td>");
				out.append("                    <td>"+acc.getEmail()+"</td>");
				out.append("                    <td>"+acc.getPhone_number()+"</td>");
				out.append("                    <td>"+acc.getDate_of_birth()+"</td>");
				out.append("                    <td>"+acc.getRole()+"</td>");
				out.append("                    <td>");
				out.append("						<div class=\"form-check form-switch d-flex align-items-center justify-content-center\">");
				if (acc.getStatus() == 0) {
					out.append("  						<input class=\"form-check-input\" type=\"checkbox\" id=\"flexSwitchCheckChecked\" onchange=\"updateStatus("+id+",this,"+acc.get_id()+")\">");
				}
				else
					out.append("  						<input class=\"form-check-input\" type=\"checkbox\"  id=\"flexSwitchCheckChecked\" checked onchange=\"updateStatus("+id+",this,"+acc.get_id()+")\">");
				out.append("						</div>");
				out.append("					</td>");
				out.append("					<td><a href='EditForm?id="+id+"&selected_id=" + acc.get_id() + "' class='btn btn-success'><i class='bi bi-pencil-square'></i></a></td>"); 
				out.append("					<td><a href='DelRecord?id="+id+"&selected_id=" + acc.get_id() + "' class='btn btn-danger' onclick='return confirm(\"Bạn có chắc chắn muốn xóa tài khoản này?\")'><i class='bi bi-trash'></i></a></td>"); 
				out.append("                  </tr>");
			}
		}
		else {
			out.append("<tr><td colspan='8'>Không có dữ liệu.</td></tr>");
		}
		out.append("                </tbody>");
		out.append("              </table>");
		out.append("              <!-- End Table with stripped rows -->");
		out.append("");
		out.append("            </div>");
		out.append("          </div>");
		out.append("");
		out.append("        </div>");
		out.append("      </div>");
		out.append("    </section>");
		out.append("  </main><!-- End #main -->");
		out.append("");
		out.append("  <!-- ======= Footer ======= -->");
		out.append("  <footer id=\"footer\" class=\"footer\">");
		out.append("    <div class=\"copyright\">");
		out.append("      &copy; Copyright <strong><span>NiceAdmin</span></strong>. All Rights Reserved");
		out.append("    </div>");
		out.append("    <div class=\"credits\">");
		out.append("      Designed by <a href=\"https://bootstrapmade.com/\">BootstrapMade</a>");
		out.append("    </div>");
		out.append("  </footer><!-- End Footer -->");
		out.append("");
		out.append("  <a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>");
		out.append("");
		out.append("  <!-- Vendor JS Files -->");
		out.append("  <script src=\"/MyWeb/js/apexcharts.min.js\"></script>");
		out.append("  <script src=\"/MyWeb/js/bootstrap.bundle.min.js\"></script>");
		out.append("  <script src=\"/MyWeb/js/chart.umd.js\"></script>");
		out.append("  <script src=\"/MyWeb/js/echarts.min.js\"></script>");
		out.append("  <script src=\"/MyWeb/js/quill.js\"></script>");
		out.append("  <script src=\"/MyWeb/js/simple-datatables.js\"></script>");
		out.append("  <script src=\"/MyWeb/js/tinymce.min.js\"></script>");
		out.append("  <script src=\"/MyWeb/js/validate.js\"></script>");
		out.append("");
		out.append("  <!-- Template Main JS File -->");
		out.append("  <script src=\"/MyWeb/js/mainAdmin.js\" defer></script>");
		out.append("");
		out.append("<script>");
		out.append("function updateStatus(id,checkbox, accountId) {");
		out.append("    var isChecked = checkbox.checked ? 1 : 0;");
//		out.append("alert(isChecked);"); 
		out.append("    var url = \"editStatus?id=\"+id + \"&status=\" + isChecked + \"&accountId=\" + accountId;");
		out.append("    window.location.href = url;");
		out.append("}");
		out.append("</script>");
		out.append("</body>");
		out.append("");
		out.append("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    }
}
