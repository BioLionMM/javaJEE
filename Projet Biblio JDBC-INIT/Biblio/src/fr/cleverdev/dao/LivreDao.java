package fr.cleverdev.dao;

import java.util.ArrayList;
import java.util.List;

import fr.cleverdev.model.Livre;

public interface LivreDao {
	void         creer( Livre livre ) throws DaoException;

    Livre       trouver( long id ) throws DaoException;
    
    ArrayList<Livre> trouverParAuteur(long id_auteur) throws DaoException;

    List<Livre> lister() throws DaoException;

    void         supprimer( long id ) throws DaoException;
    
    void 		modification(long id, String titre) throws DaoException;
    
}
