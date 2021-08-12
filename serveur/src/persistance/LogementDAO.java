package persistance;

import java.sql.Connection;
import java.util.List;

import model.Logement;

public class LogementDAO extends OracleDAO<Logement>
{

	public LogementDAO(Connection connection) {
		super(connection);
}
	public LogementDAO(String url, String user, String password) {
		super(url, user, password);
	}

	@Override
	public Logement find(Integer id) {
		return null;
	}

	@Override
	public int create(Logement object) {
		return 0;
	}

	@Override
	public boolean update(Logement object) {
		return false;
	}

	@Override
	public boolean delete(Logement object) {
		return false;
	}

	@Override
	public List<Logement> findAll() {
		return null;
	}
	@Override
	public Logement findForUpdate(Integer id) {
		return null;
	}

}
