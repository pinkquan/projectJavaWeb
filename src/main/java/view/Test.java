package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.ProductObject;
import user.ProductFunction;
import user.ProductFunctionImpl;
import util.ConnectionPool;

@WebServlet("/Test")
public class Test extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            ConnectionPool cp = null; // Cần khởi tạo đúng cách
            ProductFunction pf = new ProductFunctionImpl(cp);

            ProductObject product = pf.getProduct(1);
            String imgPathString = "/MyWeb/img/menu/menu"+product.getProductImg()+".jpg";
            out.println(imgPathString);
            out.println("<html><body>");
            out.println("<h1>Product Name: " + product.getProductName() + "</h1>");
			out.append("<img src=\"" + imgPathString + "\" class=\"img-fluid\" alt=\"\">");
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace(); // In stack trace vào console
            out.println("<html><body>");
            out.println("<h1>An error occurred</h1>");
            out.println("<p>Error details: " + e.getMessage() + "</p>");
            out.println("</body></html>");
        }
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
