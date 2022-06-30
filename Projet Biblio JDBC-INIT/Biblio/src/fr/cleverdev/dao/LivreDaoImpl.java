package fr.cleverdev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cleverdev.model.Livre;

public class LivreDaoImpl implements LivreDao{
	
	private static final String SQL_INSERT       = "INSERT INTO livre(titre,id_auteur,nb_pages,categorie) VALUES(?,?,?,?)";
	private static final String SQL_SELECT       = "SELECT id,titre,id_auteur,nb_pages,categorie FROM livre";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM livre WHERE id = ?";
    private static final String SQL_SELECT_BY_ID_AUTEUR = "SELECT * FROM livre WHERE id_auteur = ?";
    private static final String SQL_MODIF_BY_ID = "UPDATE livre SET titre=? WHERE id = ? ";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM livre WHERE id = ? ";
	
	private DaoFactory factory;
	
	public LivreDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public void creer(Livre livre) throws DaoException {
		Connection con=null;
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			pst.setString( 1, livre.getTitre() );
			pst.setLong( 2, livre.getAuteur().getId() );
			pst.setLong( 3, livre.getNbPages() );
			pst.setString( 4, livre.getCategorie() );
			
			int statut = pst.executeUpdate();

            if ( statut == 0 ) {
                throw new DaoException( "Echec creation Livre (aucun ajout)" );
            }
            
            ResultSet rsKeys = pst.getGeneratedKeys();
            if ( rsKeys.next() ) {
                livre.setId( rsKeys.getLong( 1 ) );
            } else {
                throw new DaoException( "Echec creation Livre (ID non retourne)" );
            }
            rsKeys.close();
			pst.close();
			
	    } catch(SQLException ex) {
	    	throw new DaoException("Echec creation Livre",ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		
	}

	@Override
	public Livre trouver(long id) throws DaoException {
		Livre            livre=null;
		Connection        con=null;
		PreparedStatement pst=null;
		ResultSet         rs=null;
		try {
			  con = factory.getConnection();
			  pst = con.prepareStatement( SQL_SELECT_BY_ID );
			  pst.setLong(1, id);
		      rs  = pst.executeQuery();
		      if ( rs.next() ) {
		    	  livre = map(rs);
		      }
		      rs.close();
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de recherche BDD Auteur", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		return livre;
	}

	@Override
	public ArrayList<Livre> trouverParAuteur(long id_auteur) throws DaoException {
		ArrayList<Livre>            listeLivres=new ArrayList<Livre>();
		Connection        con=null;
		PreparedStatement pst=null;
		ResultSet         rs=null;
		try {
			  con = factory.getConnection();
			  pst = con.prepareStatement( SQL_SELECT_BY_ID );
			  pst.setLong(1, id_auteur);
		      rs  = pst.executeQuery();
		      if(rs.next()) {
		    	  listeLivres.add(map(rs));
		    	  while ( rs.next() ) {
			    	  listeLivres.add(map(rs));
			      }
		      }
		      
		      rs.close();
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de recherche BDD Auteur", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		return listeLivres;
	}

	
	
	@Override
	public List<Livre> lister() throws DaoException {
		List<Livre> listeLivres = new ArrayList<Livre>();
		Connection   con=null;
		try {
			  con = factory.getConnection();
			  PreparedStatement pst = con.prepareStatement( SQL_SELECT );
		      ResultSet         rs  = pst.executeQuery();
		      while ( rs.next() ) {
		    	  listeLivres.add( map(rs) );
		      }
		      rs.close();
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de lecture BDD Auteur", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		return listeLivres;
	}

	
	@Override
	public void supprimer(long id) throws DaoException {
		// TODO Auto-generated method stub
		Connection   con=null;
		try {
			  con = factory.getConnection();
			  PreparedStatement pst = con.prepareStatement( SQL_DELETE_BY_ID );
			  pst.setLong(1, id);
			  int statut = pst.executeUpdate();
			  if ( statut == 0 ) {
				  throw new DaoException("Erreur de suppression Auteur("+id+")");
			  }
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de suppression BDD Auteur", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
	}

	
	
	@Override
	public void modification(long id, String titre) throws DaoException {
		Connection   con=null;
		try {
			  con = factory.getConnection();
			  PreparedStatement pst = con.prepareStatement( SQL_MODIF_BY_ID );
			  pst.setString(1, titre);
			  pst.setLong(2, id);
			  
			  int statut = pst.executeUpdate();
			  
			  if ( statut == 0 ) {
				  throw new DaoException("Erreur de modification Auteur("+id+")");
			  }
		      pst.close();
		      
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de modification BDD Auteur", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		
	}
	
	
	private static Livre map( ResultSet resultSet ) throws SQLException, DaoException {
		AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
		
        Livre a = new Livre();
        a.setId( resultSet.getLong( "id" ) );
        a.setTitre( resultSet.getString( "titre" ) );
        
        try {
			a.setAuteur( auteurDao.trouver(resultSet.getLong( "id_auteur" )));
		}catch (SQLException e) {
			throw new DaoException("Erreur de recherche BDD Auteur", e);
		}
        
        a.setNbPages( resultSet.getInt( "nb_pages" ) );
        a.setCategorie( resultSet.getString( "categorie" ) );
        
        return a;
    }

}
