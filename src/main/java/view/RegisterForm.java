package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.*;
import object.*;

/**
 * Servlet implementation class RegisterForm
 */
@WebServlet("/RegisterForm")
public class RegisterForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterForm() {
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
		out.append("<!DOCTYPE html>");
		out.append("<html lang=\"en\">");
		out.append("");
		out.append("<head>");
		out.append("  <meta charset=\"utf-8\">");
		out.append("  <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">");
		out.append("");
		out.append("  <title>Đăng ký</title>");
		out.append("  <meta content=\"\" name=\"description\">");
		out.append("  <meta content=\"\" name=\"keywords\">");
		out.append("");
		out.append("  <!-- Favicons -->");
		out.append("  <link href=\"img/logo.jpg\" rel=\"icon\">");
		out.append("  <link href=\"img/logo.jpg\" rel=\"apple-touch-icon\">");
		out.append("");
		out.append("  <!-- Google Fonts -->");
		out.append("  <link href=\"https://fonts.gstatic.com\" rel=\"preconnect\">");
		out.append("  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">");
		out.append("");
		out.append("  <!-- Vendor CSS Files -->");
		out.append("  <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"css/bootstrap-icons.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"css/boxicons.min.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"css/quill.snow.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"css/quill.bubble.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"css/remixicon.css\" rel=\"stylesheet\">");
		out.append("  <link href=\"css/styleDb.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("  <!-- Template Main CSS File -->");
		out.append("  <link href=\"css/styleAdmin.css\" rel=\"stylesheet\">");
		out.append("");
		out.append("  <!-- =======================================================");
		out.append("  * Template Name: NiceAdmin");
		out.append("  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/");
		out.append("  * Updated: Apr 20 2024 with Bootstrap v5.3.3");
		out.append("  * Author: BootstrapMade.com");
		out.append("  * License: https://bootstrapmade.com/license/");
		out.append("  ======================================================== -->");
		out.append("</head>");
		out.append("<body>");
		out.append("  <main id=\"main\" class=\"main\">");
		out.append("");
		out.append("    <div class=\"pagetitle\">");
		out.append("      <h1>Thêm tài khoản</h1>");
		out.append("    </div><!-- End Page Title -->");
		out.append("    <section class=\"section\">");
		out.append("      <div class=\"row\">");
		out.append("");
		out.append("");
		out.append("        <div class=\"col-lg-9\">");
		out.append("          <div class=\"card\">");
		out.append("            <div class=\"card-body\">");
		out.append("              <h5 class=\"card-title\"></h5>");
		out.append("");
		out.append("              <!-- Floating Labels Form -->");
		out.append("              <form class=\"row g-3\" method=\"post\" accept-charset=\"UTF-8\"\">");
		out.append("                <div class=\"col-md-6\">");
		out.append("                  <div class=\"form-floating\">");
		out.append("                    <input type=\"text\" class=\"form-control\" id=\"floatingName\" name=\"ID\" placeholder=\"Tên tài khoản\">");
		out.append("                    <label for=\"floatingName\">Tên tài khoản</label>");
		out.append("                  </div>");
		out.append("                </div>");
		out.append("");
		out.append("				<div class=\"col-md-6\">");
		out.append("                  <div class=\"form-floating\">");
		out.append("                    <input type=\"password\" class=\"form-control\" id=\"floatingPassword\" name=\"pass\" placeholder=\"Mật khẩu\">");
		out.append("                    <label for=\"floatingPassword\">Mật khẩu</label>");
		out.append("                  </div>");
		out.append("                </div>");
		out.append("");
		out.append("                  <div class=\"col-md-9\">");
		out.append("                    <div class=\"form-floating\">");
		out.append("                      <input type=\"text\" class=\"form-control\" id=\"floatingName\" name=\"name\" placeholder=\"Họ và Tên\">");
		out.append("                      <label for=\"floatingCity\">Họ và Tên</label>");
		out.append("                    </div>");
		out.append("                  </div>");
		out.append("");
		out.append("<div class=\"col-md-3\">");
		out.append("  <div class=\"form-floating mb-3\">");
		out.append("	<select class=\"form-select\" id=\"floatingSelect\" name=\"role\" aria-label=\"Role\">");
		out.append("	  <option value = \"User\" selected>User</option>");
		out.append("	  <option value=\"Admin\">Admin</option>");
		out.append("	</select>");
		out.append("	<label for=\"floatingCity\">Role</label>");
		out.append("  </div>");
		out.append("</div>");
		out.append("                <div class=\"col-md-6\">");
		out.append("                  <div class=\"form-floating\">");
		out.append("                    <input type=\"email\" class=\"form-control\" id=\"floatingEmail\" name=\"email\" placeholder=\"Email\">");
		out.append("                    <label for=\"floatingEmail\">Email</label>");
		out.append("                  </div>");
		out.append("                </div>");
		out.append("");
		out.append("                <div class=\"col-md-3\">");
		out.append("                  <div class=\"form-floating\">");
		out.append("                    <input type=\"text\" class=\"form-control\" id=\"floatingEmail\" name=\"dateOfBirth\" placeholder=\"YYYY-MM-DD\">");
		out.append("                    <label for=\"floatingEmail\">Ngày sinh</label>");
		out.append("                  </div>");
		out.append("                </div>");
		out.append("");
		out.append("				<div class=\"col-md-3\">");
		out.append("                  <div class=\"form-floating\">");
		out.append("                    <input type=\"text\" class=\"form-control\" id=\"floatingEmail\" name=\"phone\" placeholder=\"Số điện thoại\">");
		out.append("                    <label for=\"floatingEmail\">Số điện thoại</label>");
		out.append("                  </div>");
		out.append("                </div>");
		out.append("");
		out.append("                <div class=\"col-12\">");
		out.append("                  <div class=\"form-floating\">");
		out.append("                    <textarea class=\"form-control\" placeholder=\"Address\" id=\"floatingTextarea\" name=\"address\" style=\"height: 100px;\"></textarea>");
		out.append("                    <label for=\"floatingTextarea\">Địa chỉ</label>");
		out.append("                  </div>");
		out.append("                </div>");
		out.append("                <!-- <div class=\"col-md-6\"> -->");
		out.append("                  <!-- <div class=\"col-md-12\"> -->");
		out.append("                    <!-- <div class=\"form-floating\"> -->");
		out.append("                      <!-- <input type=\"text\" class=\"form-control\" id=\"floatingCity\" placeholder=\"City\"> -->");
		out.append("                      <!-- <label for=\"floatingCity\">City</label> -->");
		out.append("                    <!-- </div> -->");
		out.append("                  <!-- </div> -->");
		out.append("                <!-- </div> -->");
		out.append("                <!-- <div class=\"col-md-4\"> -->");
		out.append("                  <!-- <div class=\"form-floating mb-3\"> -->");
		out.append("                    <!-- <select class=\"form-select\" id=\"floatingSelect\" aria-label=\"State\"> -->");
		out.append("                      <!-- <option selected>New York</option> -->");
		out.append("                      <!-- <option value=\"1\">Oregon</option> -->");
		out.append("                      <!-- <option value=\"2\">DC</option> -->");
		out.append("                    <!-- </select> -->");
		out.append("                    <!-- <label for=\"floatingSelect\">State</label> -->");
		out.append("                  <!-- </div> -->");
		out.append("                <!-- </div> -->");
		out.append("                <!-- <div class=\"col-md-2\"> -->");
		out.append("                  <!-- <div class=\"form-floating\"> -->");
		out.append("                    <!-- <input type=\"text\" class=\"form-control\" id=\"floatingZip\" placeholder=\"Zip\"> -->");
		out.append("                    <!-- <label for=\"floatingZip\">Zip</label> -->");
		out.append("                  <!-- </div> -->");
		out.append("                <!-- </div> -->");
		out.append("                <div class=\"text-center\">");
		out.append("                  <button type=\"submit\" name = \"submit\" class=\"btn btn-primary\">Thêm</button>");
		out.append("                  <button type=\"submit\" name = \"submit\" class=\"btn btn-secondary\">Hủy</button>");
		out.append("                </div>");
		out.append("              </form><!-- End floating Labels Form -->");
		out.append("");
		out.append("            </div>");
		out.append("          </div>");
		out.append("        </div>");
		out.append("      </div>");
		out.append("    </section>");
		out.append("");
		out.append("  </main><!-- End #main -->");
		out.append("");
		out.append("  <!-- ======= Footer ======= -->");
		out.append("  <footer id=\"footer\" class=\"footer\">");
		out.append("");
		out.append("    <div class=\"credits\">");
		out.append("      <!-- All the links in the footer should remain intact. -->");
		out.append("      <!-- You can delete the links only if you purchased the pro version. -->");
		out.append("      <!-- Licensing information: https://bootstrapmade.com/license/ -->");
		out.append("      <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->");
		out.append("");
		out.append("    </div>");
		out.append("  </footer><!-- End Footer -->");
		out.append("");
		out.append("  <a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>");
		out.append("");
		out.append("  <!-- Vendor JS Files -->");
		out.append("  <script src=\"js/apexcharts.min.js\"></script>");
		out.append("  <script src=\"js/bootstrap.bundle.min.js\"></script>");
		out.append("  <script src=\"js/chart.umd.js\"></script>");
		out.append("  <script src=\"js/echarts.min.js\"></script>");
		out.append("  <script src=\"js/quill.js\"></script>");
		out.append("  <script src=\"js/simple-datatables.js\"></script>");
		out.append("  <script src=\"js/tinymce.min.js\"></script>");
		out.append("  <script src=\"js/validate.js\"></script>");
		out.append("");
		out.append("  <!-- Template Main JS File -->");
		out.append("  <script src=\"js/main.js\"></script>");
		out.append("");
		out.append("</body>");
		out.append("");
		out.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String main_id = request.getParameter("id");
		String id = request.getParameter("ID");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String date = request.getParameter("dateOfBirth");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String role = request.getParameter("role");
		String submit = request.getParameter("submit");
		String cancel = request.getParameter("cancel");
		AccountFunctionImp oper = new AccountFunctionImp(null);
		System.out.println(role);
		if (submit != null) {
			Account temp = new Account(id, name, date, address, phone, email, pass);
			temp.setRole(role);
			oper.addAccount(temp);
			response.sendRedirect("AccountManagermentSection?id"+id);
		}
		
		if (cancel != null) {
			response.sendRedirect("AccountManagermentSection?id"+id);
		}
		
		doGet(request, response);
		
		
	}

}
