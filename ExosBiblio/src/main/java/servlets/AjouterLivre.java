package servlets;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class AjouterLivre
 */
@WebServlet("/AjouterLivre")
public class AjouterLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LivreDao livreDao = DaoFactory.getInstance().getLivreDao();
	AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
	List<Auteur> listeAuteurs=null;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listeAuteurs=auteurDao.lister();
			request.setAttribute("listAuteurs",listeAuteurs);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/AjouterLivre.jsp").forward( request,
				response );

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String titre=request.getParameter("titre");
		String idAuteur=request.getParameter("auteurId");
		String nbPages=request.getParameter("nbPages");
		String categorie=request.getParameter("categorie");
		
		Auteur auteur;
		try {
			auteur = auteurDao.trouver(Long.parseLong(idAuteur));
			Livre livreAAjouter=new Livre();
			livreAAjouter.setTitre(titre);
			livreAAjouter.setAuteur(auteur);
			livreAAjouter.setNbPages(Integer.parseInt(nbPages));
			livreAAjouter.setCategorie(categorie);
			
			try {
				livreDao.creer(livreAAjouter);
			}catch(DaoException ex) {
				ex.printStackTrace();
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
		
		
		response.sendRedirect( request.getContextPath() + "/ListeLivres" );
	}

}
