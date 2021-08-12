package persistance;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.ComplementDomaine;
import model.Domaine;

public class ComplementDomaineDAO extends OracleDAO<ComplementDomaine>
{

	public ComplementDomaineDAO(String url, String user, String password) {
		super(url, user, password);
		// TODO Auto-generated constructor stub
	}

	public ComplementDomaineDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ComplementDomaine find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(ComplementDomaine object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(ComplementDomaine object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ComplementDomaine object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ComplementDomaine> findAll() {
		ArrayList<ComplementDomaine> domaines = new ArrayList<ComplementDomaine>();
		ComplementDomaine domaine ;
		try {
		      String sql = "SELECT * FROM COMPLEMENTDOMAINE";
		      this.preparedStatement = this.connection.prepareStatement(sql);				      
		      this.resultSet= this.preparedStatement.executeQuery();
		      while(this.resultSet.next()) {
		    	  domaine = new ComplementDomaine(this.resultSet.getString(1));
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
		ComplementDomaineDAO u = new ComplementDomaineDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
		System.out.println(u.findAll());
	}

	@Override
	public ComplementDomaine findForUpdate(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
