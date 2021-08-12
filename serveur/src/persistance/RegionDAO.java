package persistance;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Place;
import model.Region;
import model.Reservation;
import model.ReservationPlace;

public class RegionDAO extends OracleDAO<Region>
{

	public RegionDAO(String url, String user, String password) {
		super(url, user, password);

	}

	public RegionDAO(Connection connection) {
		super(connection);

	}

	@Override
	public Region find(Integer id) {
		return null;
	}

	@Override
	public int create(Region object) {
		return 0;
	}

	@Override
	public boolean update(Region object) {
		return false;
	}

	@Override
	public boolean delete(Region object) {
		return false;
	}

	@Override
	public List<Region> findAll() {
		ArrayList<Region> regions = new ArrayList<Region>();
		Region region = new Region();
		try {		      
		      String sql = "SELECT * FROM REGION";
		      this.preparedStatement = this.connection.prepareStatement(sql);		
		      this.resultSet = this.preparedStatement.executeQuery();
		      while(this.resultSet.next()) {
		    	  		region = new Region(this.resultSet.getString(1));
		    	  		regions.add(region);
		    		}
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return regions;
	}
	
	public static void main(String[] args) {
		RegionDAO u = new RegionDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
		System.out.println(u.findAll());
	}

	@Override
	public Region findForUpdate(Integer id) {
		return null;
	}

}
