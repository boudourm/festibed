package persistance;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.Domaine;
import model.Region;

public class DomaineDAO extends OracleDAO<Domaine>
{

	public DomaineDAO(String url, String user, String password) {
		super(url, user, password);

	}

	public DomaineDAO(Connection connection) {
		super(connection);

	}

	@Override
	public Domaine find(Integer id) {

		return null;
	}

	@Override
	public int create(Domaine object) {
		return 0;
	}

	@Override
	public boolean update(Domaine object) {

		return false;
	}

	@Override
	public boolean delete(Domaine object) {

		return false;
	}

	@Override
	public List<Domaine> findAll() {
		ArrayList<Domaine> domaines = new ArrayList<Domaine>();
		Domaine domaine ;
		try {
		      String sql = "SELECT * FROM DOMAINE ";
		      this.preparedStatement = this.connection.prepareStatement(sql);	
		      this.resultSet = this.preparedStatement.executeQuery();
		      while(this.resultSet.next()) {
		    	  domaine = new Domaine(this.resultSet.getString(1));
		    	  domaines.add(domaine);
		    		}
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return domaines;
	}
	
	public static void main(String[] args) {
		DomaineDAO u = new DomaineDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
		System.out.println(u.findAll());
	}

	@Override
	public Domaine findForUpdate(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
