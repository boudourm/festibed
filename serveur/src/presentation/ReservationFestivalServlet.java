package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Client;
import model.Festival;
import model.Place;
import model.Reservation;
import model.ReservationPlace;
import model.Utilisateur;
import persistance.PlaceDAO;
import persistance.ReservationDAO;
import persistance.ResevationPlaceDAO;
import persistance.UtilisateurDAO;

public class ReservationFestivalServlet extends HttpServlet {

	// DAO pour récuperer manipuler les reservations
	 ReservationDAO rdao;
	 ResevationPlaceDAO rpdao;
	 UtilisateurDAO udao;
	 PlaceDAO pdao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// DAO pour récuperer manipuler les reservations
				 rdao = new ReservationDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag","boudourm", "Passw0rd");
				resp.setStatus(HttpServletResponse.SC_OK);
				resp.setContentType("application/json");
				PrintWriter out = resp.getWriter();

				
				//Il faut récuperer les reservation , les reservationsPlace 
				if (req.getParameter("id") != null) {
					// Recuperer l'id du client
					String id = req.getParameter("id");
					Client client = new Client();
					client.setIdFireBase(id);

					// Retrouver une reservation avec l'id du client
					 List<Reservation> reservations = rdao.findByClient(client);
					 Map<Place , ReservationPlace> resaplace ;
					 List<Festival> festivals = new ArrayList<Festival>();
					 System.out.println("reser "+ reservations.size());
					for (Reservation r : reservations)
					{
						resaplace = r.getPlacesReserveesParPlace();
						Set<Place> places = resaplace.keySet();
						for(Place p : places)
						{
							
							if(festivals.size()==0) festivals.add(p.getFestival());
							else
								{
								boolean b = false; 
									for(Festival f : festivals)
									{
										if(f.getNumeroIdentification().equalsIgnoreCase(p.getFestival().getNumeroIdentification()))
											b=true;
										if(b) break;
									}
									if(!b) festivals.add(p.getFestival());
								}
						}
						System.out.println("\nPlaces "+places.size());
					}
					
					System.out.println("\nfestii "+festivals.size());
					JSONArray reservationss = new JSONArray();   
					JSONArray festis = new JSONArray();  

					//Pour chaque reservation on envoie les données demandées
					for (Reservation r : reservations) {
						// On crée un objet json pour stocker la reservation
						JSONObject reservation = new JSONObject();
						reservation.put("idReservation", r.getIdReservaion());
						reservation.put("montant", r.getPrixTotal());
						
						for(Festival f : festivals)
						{
							JSONObject festi = new JSONObject();
							festi.put("idFestival", f.getNumeroIdentification());
							festi.put("nbPlaces", r.getNbPlacesReserveesByFestival(f));
							festi.put("prixFestival", r.getPrixPlacesReserveesByFestival(f));
							festis.add(festi);
						}
						reservationss.add(reservation);
						reservationss.add(festis);
					

					
				}
					
					out.println(reservationss);
			}
			}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {	
			System.out.println("Post reservation");
			Connection conn;
			conn = DriverManager.getConnection("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag","boudourm", "Passw0rd");
			// DAO pour récuperer manipuler les reservations
			rdao = new ReservationDAO(conn);
			// DAO pour récuperer manipuler les reservations
			rpdao = new ResevationPlaceDAO(conn);
			// DAO pour récuperer manipuler les reservations
			udao = new UtilisateurDAO(conn);
			//
			pdao = new PlaceDAO(conn);
		
		
		
		// Extract param from HTTP parameters
		String userId = req.getParameter("userId");
		int idPlace = Integer.parseInt(req.getParameter("idP"));
		int nbPlaces = Integer.parseInt(req.getParameter("nbPlaces"));

		// Créer la reservation avec les bons attributs
		Reservation r = new Reservation();
		Utilisateur u =  udao.find(userId);
		Client c = new Client();
		c.setIdUtilisateur(u.getIdUtilisateur());
		System.out.println(u.getIdUtilisateur());
		r.setClient(c);
		System.out.println(u.getIdUtilisateur());
		int idResa = rdao.create(r);
		idResa = rdao.findPendingByClient(c).getIdReservaion();
		r.setIdReservaion(idResa);
		
		// Créer une reservation place , pour lier chaque place reserver à une
		ReservationPlace rp = new ReservationPlace();
		Place p = pdao.findForUpdate(idPlace);
		rp.setPlace(p);
		rp.setNbPlacesReservee(nbPlaces);
		rp.setReservation(r);
		rpdao.create(rp);
		//Répondre au serveur
		resp.setStatus(HttpServletResponse.SC_OK); 
		
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
