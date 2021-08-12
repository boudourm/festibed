package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Departement;
import model.Domaine;
import model.Place;
import model.Region;
import model.Reservation;

public class DepartementDAO extends OracleDAO<Departement>
{

	public DepartementDAO(String url, String user, String password) {
		super(url, user, password);
	}

	public DepartementDAO(Connection connection) {
		super(connection);
	}
	
	@Override
	public Departement find(Integer id) {
		Departement p = null;
		try {
			
		      String sql = "SELECT * FROM DEPATREMENT WHERE DEPTSK = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
		      this.preparedStatement.setInt(1,id);				
			  this.resultSet  = preparedStatement.executeQuery(); 
		      
		      if(this.resultSet.next()) {
		    	  p = new Departement(this.resultSet.getInt(1) , this.resultSet.getString(3),new Region(this.resultSet.getString(2)));
		    		}		      
		      this.resultSet.close();
		      this.preparedStatement.close();
		}   catch (Exception e) {
			e.printStackTrace();
		}		
		return p;
	}

	public Departement find(String nomDepartement) {
		Departement p = null;
		try {
			String sql = "SELECT * FROM DEPATREMENT WHERE NOMDEPARTEMENT = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
		      this.preparedStatement.setString(1, nomDepartement);				
			  this.resultSet  = preparedStatement.executeQuery();     
		      if(this.resultSet.next()) {
		    	  p = new Departement(this.resultSet.getInt(1) , this.resultSet.getString(3),new Region(this.resultSet.getString(2)));
		    		}		      
		      this.resultSet.close();
		      this.preparedStatement.close();
		}   catch (Exception e) {
			e.printStackTrace();
		}		
		return p;
	}
	@Override
	public int create(Departement object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Departement object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Departement object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Departement> findAll() {
		ArrayList<Departement> departements = new ArrayList<Departement>();
		Departement p ;
		try {
				String sql = "SELECT * FROM DEPATREMENT";
			      this.preparedStatement = this.connection.prepareStatement(sql);		
				  this.resultSet  = preparedStatement.executeQuery();   
		      while(this.resultSet.next()) {
			    	  p = new Departement(this.resultSet.getInt(1) , this.resultSet.getString(3),new Region(this.resultSet.getString(2)));
			    			
			    	  departements.add(p);
		    	  
		    	}
		      
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return departements;
	}

	public static void main(String[] args) {
		DepartementDAO u = new DepartementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
		System.out.println(u.find("ARDECHE"));
	}

	@Override
	public Departement findForUpdate(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
