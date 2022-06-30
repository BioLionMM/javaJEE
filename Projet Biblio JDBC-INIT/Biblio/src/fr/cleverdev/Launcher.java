package fr.cleverdev;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.cleverdev.dao.AuteurDao;
import fr.cleverdev.dao.DaoException;
import fr.cleverdev.dao.DaoFactory;
import fr.cleverdev.dao.LivreDao;
import fr.cleverdev.model.Auteur;
import fr.cleverdev.model.Livre;

public class Launcher {

	public static void main(String[] args) throws DaoException {

		AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
		List<Auteur> listAuteurs;
		
		LivreDao livreDao=DaoFactory.getInstance().getLivreDao();
		ArrayList<Livre> listLivres;
		
		Auteur currentAuteur=null;
		
		try {
			listAuteurs = auteurDao.lister();
			
		    Iterator<Auteur> i = listAuteurs.iterator();
		    while (i.hasNext()) {
		      currentAuteur=i.next();
		      System.out.println(currentAuteur);
		      
		      listLivres=livreDao.trouverParAuteur(currentAuteur.getId());
		      
		      if(listLivres.size()>0) {
		    	  Iterator<Livre> j=listLivres.iterator();
			      while(j.hasNext()) {
			    	  System.out.println(j.next());
			      }
		      }
		      
		    }

		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
