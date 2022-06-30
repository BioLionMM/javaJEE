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
 * Servlet implementation class ModifierAuteur
 */
@WebServlet("/ModifierAuteur")
public class ModifierAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idAuteur=Long.parseLong(request.getParameter("id"));
		Auteur auteur;
		try {
			auteur = auteurDao.trouver(idAuteur);
			request.setAttribute("auteur", auteur);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/ModifierAuteur.jsp").forward( request,
				response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idAuteur=Long.parseLong(request.getParameter("id"));
		Auteur auteurAAjouter;
		try {
			auteurAAjouter = auteurDao.trouver(idAuteur);
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String email=request.getParameter("email");
			String telephone=request.getParameter("telephone");
			
			auteurAAjouter.setNom(nom);
			auteurAAjouter.setPrenom(prenom);
			auteurAAjouter.setTelephone(telephone);
			auteurAAjouter.setEmail(email);
			
			try {
				auteurDao.modification(auteurAAjouter);
			}catch(DaoException ex) {
				ex.printStackTrace();
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect( request.getContextPath() + "/ListeAuteurs" );
	}
}
