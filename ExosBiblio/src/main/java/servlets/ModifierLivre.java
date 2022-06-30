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
 * Servlet implementation class ModifierLivre
 */
@WebServlet("/ModifierLivre")
public class ModifierLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
	LivreDao livreDao=DaoFactory.getInstance().getLivreDao();
	List<Auteur> listeAuteurs=null;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idLivre=Long.parseLong(request.getParameter("id"));
		Livre livre;
		try {
			livre = livreDao.trouver(idLivre);
			request.setAttribute("livre", livre);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			listeAuteurs=auteurDao.lister();
			request.setAttribute("listAuteurs",listeAuteurs);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/ModifierLivre.jsp").forward( request,
				response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idLivre=Long.parseLong(request.getParameter("id"));
		int idAuteur=Integer.parseInt(request.getParameter("auteurId"));
		
		Livre livreAAjouter;
		Auteur auteurLivre;
		try {
			livreAAjouter = livreDao.trouver(idLivre);
			String titre=request.getParameter("titre");
			int nbPages=Integer.parseInt(request.getParameter("nbPages"));
			String categorie=request.getParameter("categorie");
			
			livreAAjouter.setTitre(titre);
			auteurLivre=auteurDao.trouver(idAuteur);
			livreAAjouter.setAuteur(auteurLivre);
			livreAAjouter.setNbPages(nbPages);
			livreAAjouter.setCategorie(categorie);
			
			try {
				livreDao.modification(livreAAjouter);
			}catch(DaoException ex) {
				ex.printStackTrace();
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect( request.getContextPath() + "/ListeLivres" );
	}

}
