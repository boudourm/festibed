package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Festival;
import model.Hebergement;
import model.Organisateur;
import model.Reservation;
import model.Utilisateur;





public class UtilisateurDAO extends OracleDAO<Utilisateur>
{

	public UtilisateurDAO(Connection connection) {
		super(connection);
}
	public UtilisateurDAO(String url, String user, String password) {
		super(url, user, password);
	}
	
	@Override
	public Utilisateur find(Integer id) {
		Utilisateur utilisateur = new Utilisateur();
		try {
		      String sql = "SELECT * FROM UTILISATEUR u  WHERE IDUTILISATEUR = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  preparedStatement.setInt(1, id);				
			  this.resultSet  = preparedStatement.executeQuery(); 
		      if(this.resultSet.next()) {
		    	  /*
		    		IDUTILISATEUR INTEGER  NOT NULL,            1
				    NOMUTILISATEUR VARCHAR2(254)  NULL,			2
				    PRENOMUTILISATEUR VARCHAR2(254)  NULL,		3
				    EMAILUTILISATEUR VARCHAR2(254)  NULL,		4
				    MOTDEPASSEUTILISATEUR VARCHAR2(254)  NULL	5 
				    IDFIRBASE VARCHAR2(254)                     6 
				    */	
		    		utilisateur.setIdUtilisateur(this.resultSet.getInt(1));
		    		utilisateur.setPrenomUtilisateur(this.resultSet.getString(3));
		    		utilisateur.setEmailUtilisateur(this.resultSet.getString(4));
		    		utilisateur.setNomUtilisateur(this.resultSet.getString(2));
		    		utilisateur.setMotDePasseUtilisateur(this.resultSet.getString(5));
		    		utilisateur.setIdFireBase(this.resultSet.getString(6));
		    		
		    		}
		    				    	      
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return utilisateur;

	}
	public Utilisateur find(String idFireBase) {
		Utilisateur utilisateur = new Utilisateur();
		try {
		      String sql = "SELECT * FROM UTILISATEUR u  WHERE IDFIRBASE = ? ";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  preparedStatement.setString(1, idFireBase);				
			  this.resultSet  = preparedStatement.executeQuery(); 
		      if(this.resultSet.next()) {
		    	  /*
		    		IDUTILISATEUR INTEGER  NOT NULL,            1
				    NOMUTILISATEUR VARCHAR2(254)  NULL,			2
				    PRENOMUTILISATEUR VARCHAR2(254)  NULL,		3
				    EMAILUTILISATEUR VARCHAR2(254)  NULL,		4
				    MOTDEPASSEUTILISATEUR VARCHAR2(254)  NULL	5 
				    IDFIRBASE VARCHAR2(254)                     6 
				    */	
		    		utilisateur.setIdUtilisateur(this.resultSet.getInt(1));
		    		utilisateur.setPrenomUtilisateur(this.resultSet.getString(3));
		    		utilisateur.setEmailUtilisateur(this.resultSet.getString(4));
		    		utilisateur.setNomUtilisateur(this.resultSet.getString(2));
		    		utilisateur.setMotDePasseUtilisateur(this.resultSet.getString(5));
		    		utilisateur.setIdFireBase(this.resultSet.getString(6));
		    		
		    		}
		    				    	      
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return utilisateur;

	}

	@Override
	public int create(Utilisateur object) {
		
		/*
		    		IDUTILISATEUR INTEGER  NOT NULL,            1
				    NOMUTILISATEUR VARCHAR2(254)  NULL,			2
				    PRENOMUTILISATEUR VARCHAR2(254)  NULL,		3
				    EMAILUTILISATEUR VARCHAR2(254)  NULL,		4
				    MOTDEPASSEUTILISATEUR VARCHAR2(254)  NULL	5 
				    IDFIRBASE VARCHAR2(254)                     6 */
		int key = 0;
		try {
			  String sql = "INSERT INTO UTILISATEUR VALUES (? , ? , ? , ? , ?)";
		      this.preparedStatement = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			 // preparedStatement.setInt(1, object.getIdUtilisateur());
			  preparedStatement.setString(1, object.getNomUtilisateur());
			  preparedStatement.setString(2, object.getPrenomUtilisateur());
			  preparedStatement.setString(3, object.getEmailUtilisateur());
			  preparedStatement.setString(4, object.getMotDePasseUtilisateur());
			  preparedStatement.setString(5, object.getIdFireBase());
			  
			  preparedStatement.executeUpdate(); 
			  
			  ResultSet generatedKeys = this.preparedStatement.getGeneratedKeys();
		       if (generatedKeys.next()) 
		       {
		           key = (int) generatedKeys.getLong(1); 
		       }
		    this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}

	@Override
	public boolean update(Utilisateur object) {
		return false;
	}

	@Override
	public boolean delete(Utilisateur object) {
		return false;
	}

	@Override
	public List<Utilisateur> findAll() {
		return null;
	}

	public static void main(String[] args) {
		UtilisateurDAO u = new UtilisateurDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
		System.out.println(u.find(01));
	}
	@Override
	public Utilisateur findForUpdate(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
