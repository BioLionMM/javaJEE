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
import fr.cleverdev.model.Auteur;

/**
 * Servlet implementation class SupprimerAuteur
 */
@WebServlet("/SupprimerAuteur")
public class SupprimerAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
	String id;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id=request.getParameter("id");
		if(id != null) {
			try {
				auteurDao.supprimer(Integer.valueOf(id));
				
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect( request.getContextPath() + "/ListeAuteurs" );

	}
}
