package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Festival;
import model.Place;
import model.Reservation;
import model.ReservationPlace;

public class PlaceDAO extends OracleDAO<Place>
{

	public PlaceDAO(Connection connection) {
		super(connection);
}
	
	public PlaceDAO(String url, String user, String password) {
		super(url, user, password);
	}

	@Override
	public Place find(Integer id) {
		Place p = new Place();
		try {
			  String sql = "SELECT * FROM PLACE WHERE IDPLACE = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  preparedStatement.setInt(1, id);				
			  this.resultSet  = preparedStatement.executeQuery(); 
		      if(this.resultSet.next()) {
		    	  /* 
		    		IDPLACE INTEGER  NOT NULL,               1
				    NUMEROIDENTIFICATION INTEGER  NOT NULL,	 2
				    NBPLACESDISPO INTEGER  NULL,			 3
				    PRIXPLACE FLOAT  NULL,				     4
				    CATEGORIEPLACE INTEGER  NULL,			 5
				    DATESOIREE DATE  NULL					 6 
				    */	
			    	p.setIdPlace(this.resultSet.getInt(1));
			    	p.setCategoriePlace(this.resultSet.getInt(5));
			    	java.sql.Date d = this.resultSet.getDate(6);
		    		if(d == null)
		    		{
		    			p.setDateSoiree(null);
		    		}
		    		else
		    		{
		    			p.setDateSoiree(d.toLocalDate());
		    		}
			    	p.setNbPlaceDispo(this.resultSet.getInt(3));
			    	p.setPrixPlace(this.resultSet.getFloat(4));
			    	FestivalDAO fDAO = new FestivalDAO(this.connection);
			    	p.setFestival(fDAO.find(this.resultSet.getString(2)));
			    	p.setPlacesReserveesParResevation(new HashMap<Reservation, ReservationPlace>());
			    		
		    		}
		      
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}
		@Override
	public int create(Place object) {
		int key = 0;
		try {
			  String sql = "INSERT INTO PLACE VALUES (? , ? , ? , ? , ?)" + 
			  		"";
		      this.preparedStatement = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			  //preparedStatement.setInt(1, object.getIdPlace());
			  preparedStatement.setString(1, object.getFestival().getNumeroIdentification());
			  preparedStatement.setInt(2, object.getNbPlaceDispo());
			  preparedStatement.setFloat(3, object.getPrixPlace());
			  preparedStatement.setInt(4, object.getCategoriePlace());
			  preparedStatement.setDate(5, java.sql.Date.valueOf(object.getDateSoiree()));
			  
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
	public boolean update(Place object) {
		int rows = 0;
		try {
			  String sql = "UPDATE PLACE  "
			  		     + "SET     NBPLACESDISPO  = ? ," + 
			  		     "          PRIXPLACE  = ? ," + 
			  		     "          CATEGORIEPLACE  = ? ," + 
			  		     "          DATESOIREE  = ? "
			  		   + "			WHERE IDPLACE = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  preparedStatement.setInt(1, object.getNbPlaceDispo());
			  preparedStatement.setFloat(2, object.getPrixPlace());
			  preparedStatement.setInt(3, object.getCategoriePlace());
			  preparedStatement.setDate(4, java.sql.Date.valueOf(object.getDateSoiree()));
			  preparedStatement.setInt(5, object.getIdPlace());
			  
			  rows  = preparedStatement.executeUpdate(); 
			  if(!this.connection.getAutoCommit()) {
				  this.connection.commit();
				  this.connection.setAutoCommit(true);
			  }
		      this.preparedStatement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return (rows>0);
	}
	
	@Override
	public boolean delete(Place object) {
		int rows = 0;
		try {
			  String sql = "DELETE FROM PLACE WHERE IDPLACE = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  preparedStatement.setInt(1, object.getIdPlace());			  
			  rows  = preparedStatement.executeUpdate(); 
		      this.preparedStatement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return (rows>0);
	}

	@Override
	public List<Place> findAll() {
		return null;
	}
	
	public List<Place> findByFestival(Festival festival) {
		ArrayList<Place> places = new ArrayList<Place>();
		Place place = new Place();
		try {
		      String sql = "SELECT * FROM PLACE WHERE NUMEROIDENTIFICATION = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  preparedStatement.setString(1, festival.getNumeroIdentification());				
			  this.resultSet  = preparedStatement.executeQuery(); 
		      while(this.resultSet.next()) {
		    	  place = new Place();
		    	  /* 
		    	  /* 
		    		IDPLACE INTEGER  NOT NULL,               1
				    NUMEROIDENTIFICATION INTEGER  NOT NULL,	 2
				    NBPLACESDISPO INTEGER  NULL,			 3
				    PRIXPLACE FLOAT  NULL,				     4
				    CATEGORIEPLACE INTEGER  NULL,			 5
				    DATESOIREE DATE  NULL					 6 */	
		    	  place.setIdPlace(this.resultSet.getInt(1));
		    	  place.setCategoriePlace(this.resultSet.getInt(5));
		    	  java.sql.Date d = this.resultSet.getDate(6);
		    		if(d == null)
		    		{
		    			place.setDateSoiree(null);
		    		}
		    		else
		    		{
		    			place.setDateSoiree(d.toLocalDate());
		    		}
		    	  place.setNbPlaceDispo(this.resultSet.getInt(3));
		    	  place.setPrixPlace(this.resultSet.getFloat(4));
		    	  place.setPlacesReserveesParResevation(new HashMap<Reservation, ReservationPlace>());
		    	  place.setFestival(festival);
		    	  		places.add(place);
		    		}
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return places; 
	}
	
	public Map<Place,ReservationPlace> findByReservation(Reservation reservation) {
		Map<Place,ReservationPlace>  placesReserveesParPlace =new HashMap<Place,ReservationPlace>();
		Place place = new Place();
		try {
		      String sql = "SELECT p.IDPLACE, p.NUMEROIDENTIFICATION,p.NBPLACESDISPO, p.PRIXPLACE, p.CATEGORIEPLACE, p.DATESOIREE, rp.NBPLACESRESERVEE FROM place p , RESERVATIONPLACE rp WHERE p.IDPLACE = rp.IDPLACE AND   rp.IDRESERVATION = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  preparedStatement.setInt(1, reservation.getIdReservaion());				
			  this.resultSet  = preparedStatement.executeQuery(); 
		      while(this.resultSet.next()) {
		    	  place = new Place();
		    	  /* 
		    		IDPLACE INTEGER  NOT NULL,               1
				    NUMEROIDENTIFICATION INTEGER  NOT NULL,	 2
				    NBPLACESDISPO INTEGER  NULL,			 3
				    PRIXPLACE FLOAT  NULL,				     4
				    CATEGORIEPLACE INTEGER  NULL,			 5
				    DATESOIREE DATE  NULL					 6 
				    NBPLACESRESERVEE INTEGer;				 7 */	
		    	  place.setIdPlace(this.resultSet.getInt(1));
		    	  place.setCategoriePlace(this.resultSet.getInt(5));
		    	  java.sql.Date d = this.resultSet.getDate(6);
		    		if(d == null)
		    		{
		    			place.setDateSoiree(null);
		    		}
		    		else
		    		{
		    			place.setDateSoiree(d.toLocalDate());
		    		}
		    	  place.setNbPlaceDispo(this.resultSet.getInt(3));
		    	  place.setPrixPlace(this.resultSet.getFloat(4));
		    	  //Festival 
		    	  FestivalDAO festivalDAO = new FestivalDAO(this.connection);
		    	  place.setFestival(festivalDAO.findAsOrphan(this.resultSet.getString(2)));
		    	  
		    	  //Maps
		    	  ReservationPlace reservationPlace = new ReservationPlace(this.resultSet.getInt(7));
		    	  placesReserveesParPlace.put(place, reservationPlace);

		    		}
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return placesReserveesParPlace; 
	}
	public static void main(String[] args) {
		PlaceDAO pdao = new PlaceDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
		}

	@Override
	public Place findForUpdate(Integer id) {
		Place p = new Place();
		try {
			  if(this.connection.getAutoCommit()) this.connection.setAutoCommit(false);
			  String sql = "SELECT * FROM PLACE WHERE IDPLACE = ? FOR UPDATE";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  preparedStatement.setInt(1, id);				
			  this.resultSet  = preparedStatement.executeQuery(); 
		      if(this.resultSet.next()) {
			    		p.setIdPlace(this.resultSet.getInt(1));
			    		p.setCategoriePlace(this.resultSet.getInt(5));
			    		java.sql.Date d = this.resultSet.getDate(6);
			    		if(d == null)
			    		{
			    			p.setDateSoiree(null);
			    		}
			    		else
			    		{
			    			p.setDateSoiree(d.toLocalDate());
			    		}
			    		p.setNbPlaceDispo(this.resultSet.getInt(3));
			    		p.setPrixPlace(this.resultSet.getFloat(4));
			    		p.setPlacesReserveesParResevation(new HashMap<Reservation, ReservationPlace>());
		    		}
		      
		      this.resultSet.close();
		      this.preparedStatement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}
}