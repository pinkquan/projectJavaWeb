package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Account;
import user.AccountFunctionImp;

/**
 * Servlet implementation class EditForm
 */
@WebServlet("/EditForm")
public class EditForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
		String id = request.getParameter("selected_id");
		AccountFunctionImp oper = new AccountFunctionImp(null);
		Account acc = oper.getAccount(id);
		
		String pass = acc.getPassword();
		String name = acc.getFirst_name();
		String address = acc.getAddress();
		String phone = acc.getPhone_number();
		String email = acc.getEmail();
		String dateOfBirth = acc.getDate_of_birth();
		String role = acc.getRole();
		
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
		out.append("      <h1>Sửa thông tin</h1>");
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
		out.append("              <form class=\"row g-3\" method=\"POST\" accept-charset=\"UTF-8\"\">");
		out.append("                <div class=\"col-md-6\">");
		out.append("                  <div class=\"form-floating\">");
		out.append("                    <input type=\"text\" class=\"form-control\" id=\"floatingName\" value = " + id + " name=\"ID\" placeholder=\"Tên tài khoản\" readonly style=\"background-color: #f5f5f5;\" >");
		out.append("                    <label for=\"floatingName\">Tên tài khoản</label>");
		out.append("                  </div>");
		out.append("                </div>");
		out.append("");
		out.append("				<div class=\"col-md-6\">");
		out.append("                  <div class=\"form-floating\">");
		out.append("                    <input type=\"password\" class=\"form-control\" id=\"floatingPassword\" value = " + pass + " name=\"pass\" placeholder=\"Mật khẩu\">");
		out.append("                    <label for=\"floatingPassword\">Mật khẩu</label>");
		out.append("                  </div>");
		out.append("                </div>");
		out.append("");
		out.append("				<div class=\"col-md-9\">");
		out.append("                    <div class=\"form-floating\">");
		out.append("                      <input type=\"text\" class=\"form-control\" id=\"floatingName\" value = \"" + name + "\" name=\"name\" placeholder=\"Họ và Tên\">");
		out.append("                      <label for=\"floatingCity\">Họ và Tên</label>");
		out.append("                    </div>");
		out.append("                  </div>");
		out.append("");
		out.append("<div class=\"col-md-3\">");
		out.append("  <div class=\"form-floating mb-3\">");
		out.append("	<select class=\"form-select\" id=\"floatingSelect\" name=\"role\" aria-label=\"Role\">");
		out.append("	  <option selected>"+ role + "</option>");
		if(role == "Admin")
			out.append("	  <option value=\"User\">User</option>");
		else
			out.append("	  <option value=\"Admin\">Admin</option>");
		out.append("	</select>");
		out.append("	<label for=\"floatingCity\">State</label>");
		out.append("  </div>");
		out.append("</div>");
		out.append("                <div class=\"col-md-6\">");
		out.append("                  <div class=\"form-floating\">");
		out.append("                    <input type=\"email\" class=\"form-control\" id=\"floatingEmail\" value = " + email + " name=\"email\" placeholder=\"Email\">");
		out.append("                    <label for=\"floatingEmail\">Email</label>");
		out.append("                  </div>");
		out.append("                </div>");
		out.append("");
		out.append("                <div class=\"col-md-3\">");
		out.append("                  <div class=\"form-floating\">");
		out.append("                    <input type=\"text\" class=\"form-control\" id=\"floatingEmail\" value = " + dateOfBirth + " name=\"dateOfBirth\" placeholder=\"YYYY-MM-DD\">");
		out.append("                    <label for=\"floatingEmail\">Ngày sinh</label>");
		out.append("                  </div>");
		out.append("                </div>");
		out.append("");
		out.append("				<div class=\"col-md-3\">");
		out.append("                  <div class=\"form-floating\">");
		out.append("                    <input type=\"text\" class=\"form-control\" id=\"floatingEmail\" value= " + phone + " name=\"phone\" placeholder=\"Số điện thoại\">");
		out.append("                    <label for=\"floatingEmail\">Số điện thoại</label>");
		out.append("                  </div>");
		out.append("                </div>");
		out.append("");
		out.append("                <div class=\"col-12\">");
		out.append("                  <div class=\"form-floating\">");
		out.append("                    <textarea class=\"form-control\" placeholder=\"Address\" id=\"floatingTextarea\" name=\"address\" style=\"height: 100px;\">"+address+"</textarea>");
		out.append("                    <label for=\"floatingTextarea\">Địa chỉ</label>");
		out.append("                  </div>");
		out.append("                </div>");
		out.append("                <div class=\"text-center\">");
		out.append("                  <button type=\"submit\" name = \"submit\" class=\"btn btn-primary\">Cập nhật</button>");
		out.append("                  <button type=\"submit\" name = \"cancel\" class=\"btn btn-secondary\">Hủy</button>");
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
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("selected_id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String role = request.getParameter("role");
		String submit = request.getParameter("submit");
		String cancel = request.getParameter("cancel");
//		Boolean status = true; // default
		AccountFunctionImp oper = new AccountFunctionImp(null);
		Account acc = new Account(id, name, dateOfBirth, address, phone, email, pass);
		acc.setRole(role);
		System.out.println(acc);
		if (submit != null) {
			oper.editAccount(id, acc);
			response.sendRedirect("AccountManagermentSection?id="+id);
		}
		if (cancel != null) {
			response.sendRedirect("AccountManagermentSection?id="+id);
		}
		
			
		
	}

}
