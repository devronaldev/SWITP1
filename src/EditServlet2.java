//Membros: Ronald Pereira

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")

public class EditServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Emp e = new Emp();
		e.setId(id);
		e.setCountry(country);
		e.setEmail(email);
		e.setName(name);
		e.setPassword(password);
		
		int status = Empdao.update(e);
		if(status > 0)
		{
			response.sendRedirect("ViewServlet");
		}else {
			out.println("Sorry! Unable to update record");
		}
		
		out.close();
	}

}