package persistance;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.Festival;
import model.Organisateur;
import model.Utilisateur;

public class OrganisateurDAO extends OracleDAO<Organisateur>
{

public OrganisateurDAO(Connection connection) {
		super(connection);
	}

	public OrganisateurDAO(String url, String user, String password) {
		super(url, user, password);
	}

	@Override
	public Organisateur find(Integer id) {
		UtilisateurDAO utilisateurDao = new UtilisateurDAO(this.connection);
		Organisateur organisateur = new Organisateur();
		Utilisateur utilisateur = utilisateurDao.find(id);
		if(utilisateur.getIdUtilisateur()==null) return organisateur;
		organisateur.setIdUtilisateur(utilisateur.getIdUtilisateur());
		organisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		organisateur.setEmailUtilisateur(utilisateur.getEmailUtilisateur());
		organisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
		organisateur.setMotDePasseUtilisateur(utilisateur.getMotDePasseUtilisateur());
		FestivalDAO festivalDao = new FestivalDAO(this.connection);
		organisateur.setFestivals(festivalDao.findByOrganisateur(organisateur));
		return organisateur;
	}

	@Override
	public int create(Organisateur object) {
		UtilisateurDAO utilisateurDao = new UtilisateurDAO(this.connection);
		int key = utilisateurDao.create(object);
		try {
			  String sql = "INSERT INTO ORGANISATEUR VALUES (?)";
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
	public boolean update(Organisateur object) {
		return false;
	}

	@Override
	public boolean delete(Organisateur object) {
		return false;
	}

	@Override
	public List<Organisateur> findAll() {
		return null;
	}
	
	public static void main(String[] args) {
		OrganisateurDAO u = new OrganisateurDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
		System.out.println(u.find(01));
	}

	@Override
	public Organisateur findForUpdate(Integer id) {
		return null;
	}

}
