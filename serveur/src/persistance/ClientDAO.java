package persistance;

import java.sql.Connection;
import java.util.List;

import model.Client;
import model.Organisateur;
import model.Utilisateur;

public class ClientDAO extends OracleDAO<Client> {

	public ClientDAO(String url, String user, String password) {
		super(url, user, password);
	}

	public ClientDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Client find(Integer id) {
		UtilisateurDAO utilisateurDao = new UtilisateurDAO(this.connection);
		Client client = new Client();
		Utilisateur utilisateur = utilisateurDao.find(id);
		
		client.setIdUtilisateur(utilisateur.getIdUtilisateur());
		client.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		client.setEmailUtilisateur(utilisateur.getEmailUtilisateur());
		client.setNomUtilisateur(utilisateur.getNomUtilisateur());
		client.setMotDePasseUtilisateur(utilisateur.getMotDePasseUtilisateur());
		client.setRservations(new ReservationDAO(this.connection).findByClient(client));
		return client;
	}
	 

	@Override
	public int create(Client object) {
		return 0;
	}

	@Override
	public boolean update(Client object) {
		return false;
	}

	@Override
	public boolean delete(Client object) {
		return false;
	}

	@Override
	public List<Client> findAll() {
		return null;
	}

	@Override
	public Client findForUpdate(Integer id) {
		return null;
	}
	
	
}
