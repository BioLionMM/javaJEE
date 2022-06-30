package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cleverdev.dao.AuteurDao;
import fr.cleverdev.dao.DaoException;
import fr.cleverdev.dao.DaoFactory;

/**
 * Servlet implementation class AjouterAuteur
 */
@WebServlet("/AjouterAuteur")
public class AjouterAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id=request.getParameter("id");
		if(id != null) {
			try {
				auteurCherche=auteurDao.trouver(Integer.valueOf(id));
				
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("auteur",auteurCherche);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/DetailsAuteur.jsp").forward( request,
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
