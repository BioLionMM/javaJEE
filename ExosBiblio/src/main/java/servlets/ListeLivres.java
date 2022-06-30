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
 * Servlet implementation class ListeLivres
 */
@WebServlet("/ListeLivres")
public class ListeLivres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LivreDao livreDao = DaoFactory.getInstance().getLivreDao();
	List<Livre> listLivres;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listLivres = livreDao.lister();
			int lengthLivres=listLivres.size();
			request.setAttribute("listLivres",listLivres);
			request.setAttribute("lengthLivres",lengthLivres);
			
			this.getServletContext().getRequestDispatcher( "/WEB-INF/ListeLivres.jsp").forward( request,
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
