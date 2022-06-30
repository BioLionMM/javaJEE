package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cleverdev.dao.AuteurDao;
import fr.cleverdev.dao.DaoException;
import fr.cleverdev.dao.DaoFactory;
import fr.cleverdev.dao.LivreDao;
import fr.cleverdev.model.Auteur;
import fr.cleverdev.model.Livre;

/**
 * Servlet implementation class DetailsAuteur
 */
@WebServlet("/DetailsAuteur")
public class DetailsAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
	Auteur auteurCherche=new Auteur();
	String id;

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
	
	
}
