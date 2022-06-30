package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	public HelloServlet() {
		super();
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		java.io.PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>"); out.println("<html>"); out.println("<head>");
		out.println("<meta charset=\"utf-8\" />"); out.println("<title>First servlet</title>");
		out.println("</head>"); out.println("<body>");
		out.println("<p>Bonjour Servlet en HTML !</p>"); out.println("</body>");
		out.println("</html>");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException { doGet(request,
	response);}

}
