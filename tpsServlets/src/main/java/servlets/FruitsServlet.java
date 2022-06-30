package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FruitsServlet
 */
@WebServlet("/fruits")
public class FruitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> listeFruits=new ArrayList<String>();
		listeFruits.add("fraise");
		listeFruits.add("myrtille");
		listeFruits.add("framboise");
		request.setAttribute("listeFruits",listeFruits);
		//charger le template, racine=webapp
		this.getServletContext().getRequestDispatcher( "/WEB-INF/listerFruits.jsp").forward( request,
				response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
