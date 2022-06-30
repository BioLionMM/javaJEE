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
import fr.cleverdev.dao.LivreDao;
import fr.cleverdev.model.Auteur;
import fr.cleverdev.model.Livre;

/**
 * Servlet implementation class DetailsLivre
 */
@WebServlet("/DetailsLivre")
public class DetailsLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LivreDao livreDao = DaoFactory.getInstance().getLivreDao();
	Livre livreCherche=new Livre();
	String id;
	
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id=request.getParameter("id");
		if(id != null) {
			try {
				livreCherche=livreDao.trouver(Integer.valueOf(id));
				
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("livre",livreCherche);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/DetailsLivre.jsp").forward( request,
				response );
	}



}
