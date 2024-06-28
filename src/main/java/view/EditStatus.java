package view;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.AccountFunctionImp;

/**
 * Servlet implementation class editStatus
 */
@WebServlet("/editStatus")
public class EditStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int status = Integer.parseInt(request.getParameter("status"));
        String id = request.getParameter("accountId");
        String main_id = request.getParameter("id");
        System.out.print(status);
        AccountFunctionImp oper = new AccountFunctionImp(null);
        if (status == 0) {
            // Checkbox được chọn
        	oper.editStatus(id, 0);
        	response.sendRedirect("AccountManagermentSection?id="+main_id);
        	
        } else {
            // Checkbox không được chọn
        	oper.editStatus(id, 1);
        	response.sendRedirect("AccountManagermentSection?id="+main_id);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        

	}

}
