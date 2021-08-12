package persistance;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.Hebergeur;
import model.Festival;
import model.Hebergement;
import model.Utilisateur;





public class HebergeurDAO extends OracleDAO<Hebergeur>
{

	public HebergeurDAO(String url, String user, String password) {
		super(url, user, password);
	}

	public HebergeurDAO(Connection connection) {
		super(connection);
	}

	@Override
	public Hebergeur find(Integer id) {
		UtilisateurDAO userDAO = new UtilisateurDAO(this.connection);
		Utilisateur user = userDAO.find(id);
		Hebergeur hebergeur = new Hebergeur();
		hebergeur.setIdUtilisateur(user.getIdUtilisateur());
		hebergeur.setPrenomUtilisateur(user.getPrenomUtilisateur());
		hebergeur.setEmailUtilisateur(user.getEmailUtilisateur());
		hebergeur.setNomUtilisateur(user.getNomUtilisateur());
		hebergeur.setMotDePasseUtilisateur(user.getMotDePasseUtilisateur());
		hebergeur.setHebergements(new ArrayList<Hebergement>());
		return hebergeur;	
	}

	@Override
	public int create(Hebergeur object) {
		UtilisateurDAO utilisateurDao = new UtilisateurDAO(this.connection);
		
		int key = utilisateurDao.create(object);
		try {
			  String sql = "INSERT INTO HEBERGEUR VALUES (?)";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  preparedStatement.setInt(1, object.getIdUtilisateur());
			  
			  preparedStatement.executeUpdate(); 
		    this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}

	@Override
	public boolean update(Hebergeur object) {
		return false;
	}

	@Override
	public boolean delete(Hebergeur object) {
		return false;
	}

	@Override
	public List<Hebergeur> findAll() {
		return null;
	}
	
	public static void main(String[] args) {
		HebergeurDAO f = new HebergeurDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
		System.out.println(f.find(03));
	}

	@Override
	public Hebergeur findForUpdate(Integer id) {
		return null;
	}


	
}
