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
 * Servlet implementation class AjouterAuteur
 */
@WebServlet("/AjouterAuteur")
public class AjouterAuteur extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/WEB-INF/AjouterAuteur.jsp").forward( request,
				response );

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("email");
		String telephone=request.getParameter("telephone");
		
		Auteur auteurAAjouter=new Auteur();
		auteurAAjouter.setNom(nom);
		auteurAAjouter.setPrenom(prenom);
		auteurAAjouter.setTelephone(telephone);
		auteurAAjouter.setEmail(email);
		
		try {
			auteurDao.creer(auteurAAjouter);
		}catch(DaoException ex) {
			ex.printStackTrace();
		}
		response.sendRedirect( request.getContextPath() + "/ListeAuteurs" );
	}

}
