package persistance;

import java.sql.Connection;
import java.util.List;

import model.ReservationPlace;

public class ResevationPlaceDAO extends OracleDAO<ReservationPlace>
{

	public ResevationPlaceDAO(String url, String user, String password) {
		super(url, user, password);
	}

	public ResevationPlaceDAO(Connection connection) {
		super(connection);
	}

	@Override
	public ReservationPlace find(Integer id) {
		return null;
	}

	@Override
	public int create(ReservationPlace object) {
		int rows = 0;
		try {			
			  String sql = "INSERT INTO RESERVATIONPLACE VALUES (? , ? , ?)";
			  
		      this.preparedStatement = this.connection.prepareStatement(sql);
		      this.preparedStatement.setInt(2, object.getPlace().getIdPlace());
		      this.preparedStatement.setInt(1,object.getReservation().getIdReservaion());
		      this.preparedStatement.setFloat(3, object.getNbPlacesReservee());
			  
			  if(!this.connection.getAutoCommit()) {
				  this.connection.commit();
				  this.connection.setAutoCommit(true);
			  }
			  rows  = preparedStatement.executeUpdate(); 
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;		

	}

	@Override
	public boolean update(ReservationPlace object) {
		return false;
	}

	@Override
	public boolean delete(ReservationPlace object) {
		return false;
	}

	@Override
	public List<ReservationPlace> findAll() {
		return null;
	}

	@Override
	public ReservationPlace findForUpdate(Integer id) {
		return null;
	}


}
