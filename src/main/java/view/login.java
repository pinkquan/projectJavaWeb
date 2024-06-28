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
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset= utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("    <head>");
		out.append("        <meta charset=\"UTF-8\">");
		out.append("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.append("        <meta name=\"Description\" content=\"The login\">");
		out.append("        <meta name=\"Author\" content=\"NguyenVanViet\">");
		out.append("        <title>Login</title>");
		out.append("        <link href=\"/MyWeb/img/logo.jpg\" rel=\"icon\" type=\"image/x-icon\">");
		out.append("        <link href=\"/MyWeb/css/stylelog.css\" rel=\"stylesheet\">");
		out.append("        <link href=\"/MyWeb/css/all.min.css\" rel=\"stylesheet\">");
		out.append("        <link href=\"/MyWeb/css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.append("    </head>");
		out.append("");
		out.append("    <body>");
		out.append("        <div class=\"container-fluid bg-full\">");
		out.append("            <div class=\"container-sm\">");
		out.append("                <div class=\"row vh-100 align-items-center col-md-5\">");
		out.append("                    <div class=\"bg-light view\">");
		out.append("                        <div class=\"row my-5\">");
		out.append("                            <div class=\"col-xxl-12 text-center py-3\">");
		out.append("                                <img src=\"/MyWeb/img/logo.jpg\" class=\"u-20\" ");
		out.append("                            </div>");
		out.append("                        </div>");
		out.append("");
		out.append("                        <form class=\"needs-validation\" method=\"POST\" novalidate>");
		out.append("                            <div class=\"row justify-content-center pt-3\">");
		out.append("                                <div class=\"col-sm-8\">");
		out.append("                                    <div class=\"input-group\">");
		out.append("                                        <label for=\"txtName\" class=\"input-group-text shadow-sm text-bg-light border-primary\" ><i class=\"fa-solid fa-user\"></i></label>");
		out.append("										<input type=\"text\" class=\"form-control shadow-sm border-primary rounded-end\" name=\"id\" id=\"txtName\" placeholder=\"Tên đăng nhập\" required/>");
		out.append("										<div class=\"invalid-feedback\">Nhập thông tin tài khoản!</div>");
		out.append("                                    </div>");
		out.append("                                </div>");
		out.append("                            </div>");
		out.append("                            <div class=\"row justify-content-center pt-3\">");
		out.append("                                <div class=\"col-sm-8\">");
		out.append("                                    <div class=\"input-group\">");
		out.append("                                        <label for=\"txtName\" class=\"input-group-text shadow-sm text-bg-light border-primary\" ><i class=\"fa-solid fa-key\"></i></label>");
		out.append("										<input type=\"password\" class=\"form-control shadow-sm border-primary rounded-end\" name=\"pass\" id=\"txtName\" placeholder=\"Mật khẩu\" required/>");
		out.append("										<div class=\"invalid-feedback\">Nhập mật khẩu!</div>");
		out.append("                                    </div>");
		out.append("                                </div>");
		out.append("                            </div>");
		out.append("                            <div class=\"row justify-content-center mb-4 mt-3\">");
		out.append("								<div class=\"col-sm-8\">");
		if(request.getAttribute("loginError") != null) {
			if (request.getAttribute("loginError").toString().equals("notvalid")) {
	            out.append("<div class=\"alert alert-danger\" role=\"alert\">Tài khoản không hợp lệ");
	            out.append("</div>");
	        }
			if (request.getAttribute("loginError").toString().equals("block")) {
				out.append("<div class=\"alert alert-danger\" role=\"alert\">Tài khoản bị khóa");
	            out.append("</div>");
			}
		}
		out.append("									<button type=\"submit\" class=\"btn text-bg-light border-primary w-100 shadow-lg\"><i class=\"fa-solid fa-right-to-bracket me-2\"></i>Đăng nhập</button>");
		out.append("								</div>");
		out.append("							</div>");
		out.append("							");
		out.append("							<div class=\"row justify-content-center mb-4 pt-3\">");
		out.append("								<div class=\"col-sm-8 text-center font-weight border\">");
		out.append("									@Copyright 2024 Viet and Quan@");
		out.append("								</div>");
		out.append("							</div>");
		out.append("                        </form>");
		out.append("                    </div>");
		out.append("");
		out.append("                </div>");
		out.append("            </div>");
		out.append("        </div>");
		out.append("");
		out.append("    </body>");
		out.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountFunctionImp oper = new AccountFunctionImp(null);
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		Account acc = oper.getAccount(id, pass);
		
		if(acc != null) {
			if (acc.getStatus() == 1 && acc.getRole().equals("Admin") ) {
				request.removeAttribute("loginError");
	            response.sendRedirect("AccountManagermentSection?id="+acc.get_id());
	        } 
			else if(acc.getStatus() == 1 && acc.getRole().equals("User")) {
				request.removeAttribute("loginError");
				response.sendRedirect("Home?id="+acc.get_id());
			}
			else {
				request.setAttribute("loginError", "block");
	            doGet(request, response); // Gọi lại doGet để hiển thị trang đăng nhập với thông báo lỗi
			}
		}
		else {
				request.setAttribute("loginError", "notvalid");
	            doGet(request, response); // Gọi lại doGet để hiển thị trang đăng nhập với thông báo lỗi
		}
	}
}
