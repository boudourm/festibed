package persistance;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Reservation;

public class ReservationDAO extends OracleDAO<Reservation>{

	public ReservationDAO(String url, String user, String password) {
		super(url, user, password);
	}
	
	public ReservationDAO(Connection connection) {
		super(connection);
	}

	@Override
	public Reservation find(Integer id) {
		return null;
	}
	
	public List<Reservation> findByClient(Client client) {
		Reservation reservation = new Reservation();
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		try {
			  String sql =  "SELECT r.* " + 
					  		"FROM RESERVATION r , Client c , UTILISATEUR u" + 
					  		"WHERE c.IDUTILISATEUR = u.IDUTILISATEUR" + 
					  		"AND u.IDFIRBASE = ?" + 
					  		"AND  c.IDUTILISATEUR = r.IDUTILISATEUR";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  preparedStatement.setString(1, client.getIdFireBase());				
			  this.resultSet  = preparedStatement.executeQuery();
 
		      while(this.resultSet.next()) {
		    	  reservation = new Reservation();
		  		/*  IDRESERVATION INTEGER  NULL,            1
				    IDUTILISATEUR INTEGER  NULL,			2
				    PRIXTOTAL FLOAT  NULL,					3
				    DATERESERVATION DATE  NULL,				4
				    INFOSMODEPAYEMENT VARCHAR2(254)  NULL,	5
				    OBJETPAIEMENT VARCHAR2(254)  NULL		6  */	
		    	  reservation.setIdReservaion(this.resultSet.getInt(1));
		    	  reservation.setClient(client);
		    	  reservation.setPrixTotal(this.resultSet.getFloat(3));
		    	  java.sql.Date d = this.resultSet.getDate(4);
		    		if(d == null)
		    		{
		    			reservation.setDateReservation(null);
		    		}
		    		else
		    		{
		    			reservation.setDateReservation(d.toLocalDate());
		    		}
		    	  reservation.setInfosModePayement(this.resultSet.getString(5));
		    	  reservation.setObjetPaiement(this.resultSet.getString(6));
		    	  reservations.add(reservation);
		    	  
		    	  //Places
		    	  PlaceDAO placeDao = new PlaceDAO(this.connection);
		    	  reservation.setPlacesReserveesParPlace(placeDao.findByReservation(reservation));
		    	  
		    	  //Logement : APPOLOGIES DUDE 
		    		}
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reservations; 
	}
	
	public Reservation findPendingByClient(Client client) {
		Reservation reservation = new Reservation();
		try {
			  String sql =  "SELECT r.*  FROM RESERVATION r , Client c , UTILISATEUR u WHERE c.IDUTILISATEUR = u.IDUTILISATEUR AND   u.IDFIRBASE = ?  AND   c.IDUTILISATEUR = r.IDUTILISATEUR  AND   r.ETATRESERVATION = ? ";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  preparedStatement.setString(1, client.getIdFireBase());	
			  preparedStatement.setString(2, "ENCOURS");
			  this.resultSet  = preparedStatement.executeQuery();
 
		      if(this.resultSet.next()) {
		    	  reservation = new Reservation();
		  		/*  IDRESERVATION INTEGER  NULL,            1
				    IDUTILISATEUR INTEGER  NULL,			2
				    PRIXTOTAL FLOAT  NULL,					3
				    DATERESERVATION DATE  NULL,				4
				    INFOSMODEPAYEMENT VARCHAR2(254)  NULL,	5
				    OBJETPAIEMENT VARCHAR2(254)  NULL		6  */	
		    	  reservation.setIdReservaion(this.resultSet.getInt(1));
		    	  reservation.setClient(client);
		    	  reservation.setPrixTotal(this.resultSet.getFloat(3));
		    	  java.sql.Date d = this.resultSet.getDate(4);
		    		if(d == null)
		    		{
		    			reservation.setDateReservation(null);
		    		}
		    		else
		    		{
		    			reservation.setDateReservation(d.toLocalDate());
		    		}
		    	  reservation.setInfosModePayement(this.resultSet.getString(5));
		    	  reservation.setObjetPaiement(this.resultSet.getString(6));
		    	  
		    	  //Places
		    	  PlaceDAO placeDao = new PlaceDAO(this.connection);
		    	  reservation.setPlacesReserveesParPlace(placeDao.findByReservation(reservation));
		    	  
		    	  //Logement : APPOLOGIES DUDE 
		    		}
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reservation; 
	}
	
	@Override
	public int create(Reservation object) {
		int key = 0;
		try {
			/*
			 *     IDRESERVATION INTEGER  NULL,            1
				    IDUTILISATEUR INTEGER  NULL,		   2
				    PRIXTOTAL FLOAT  NULL,				   3
				    DATERESERVATION DATE  NULL,			   4
				    INFOSMODEPAYEMENT VARCHAR2(254)  NULL, 5
				    OBJETPAIEMENT VARCHAR2(254)  NULL	   6 
			*/
			
			  String sql = "INSERT INTO RESERVATION (IDUTILISATEUR,ETATRESERVATION) VALUES ( ? , 'ENCOURS') ";
			  
		      this.preparedStatement = this.connection.prepareStatement(sql);
		      //this.preparedStatement.setInt(1, object.getIdReservaion());
		      this.preparedStatement.setInt(1,object.getClient().getIdUtilisateur());
		      //this.preparedStatement.setFloat(2, object.getPrixTotal());
		      //this.preparedStatement.setDate(3, java.sql.Date.valueOf(object.getDateReservation()));
			  //this.preparedStatement.setString(4, object.getInfosModePayement());
			  //this.preparedStatement.setString(5, object.getObjetPaiement());
			  //this.preparedStatement.setString(6, "ENCOURS");
			  key =  preparedStatement.executeUpdate(); 
			  
			 
			  
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;		
	}

	@Override
	public boolean update(Reservation object) {
		return false;
	}

	@Override
	public boolean delete(Reservation object) {
		return false;
	}

	@Override
	public List<Reservation> findAll() {
		return null;
	}

	@Override
	public Reservation findForUpdate(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
			ReservationDAO rDao = new ReservationDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
			Client c = new Client();
			//c.setIdFireBase("1");
			c.setIdUtilisateur(2);
			Reservation r = new Reservation();
			r.setClient(c);
			System.out.println(rDao.create(r));
			//System.out.println(rDao.findPendingByClient(c));
	}
	

	
}