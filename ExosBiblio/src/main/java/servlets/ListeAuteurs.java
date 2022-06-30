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
import fr.cleverdev.model.Auteur;

/**
 * Servlet implementation class ListeAuteurs
 */
@WebServlet("/ListeAuteurs")
public class ListeAuteurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
	List<Auteur> listAuteurs;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listAuteurs = auteurDao.lister();
			int lengthAuteurs=listAuteurs.size();
			request.setAttribute("listAuteurs",listAuteurs);
			request.setAttribute("lengthAuteurs",lengthAuteurs);
			
			this.getServletContext().getRequestDispatcher( "/WEB-INF/ListeAuteurs.jsp").forward( request,
					response );
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
