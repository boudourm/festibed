package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.ChambreHotel;
import model.Hebergement;
import model.Hotel;
import persistance.HebergementDAO;

public class HotelServlet extends HttpServlet {

	// Accéder aux données du Hotel
	HebergementDAO hdao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// Accéder aux données du Hotel
		this.hdao = new HebergementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
		
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();

		// Recuperer les donnees de la base
		List<Hebergement> hotels = hdao.findByTypologie("HOTEL");
		System.out.println("hotels : " + hotels.size());
		if (hotels.size() > 0) {
			// On crée une liste d'objets Json
			JSONArray hotelss = new JSONArray();

			for (Hebergement h : hotels) {
				// On crée un objet json pour stocker le festival
				JSONObject hotel = new JSONObject();

				hotel.put("id", h.getIdHebergement());
				hotel.put("nom", h.getNomCommercialH());
				hotel.put("courrier", h.getCourrierH());
				hotel.put("classement", "" + h.getClassementH());
				hotel.put("site", "" + h.getSiteInternet());
				hotel.put("coordonnees", h.getCoordonneesH());
				hotel.put("note", h.getNoteH());
				hotel.put("description", h.getDescriptionH());
				hotel.put("adresse", h.getAdresseH());
				hotel.put("commune", h.getCommuneH());
				//hotel.put("departement", h.getDepartement().getNomDepartement());
				hotel.put("codePostal", h.getCodePostalH());
				//List<ChambreHotel> chambres = h.getChambreHotels();
				//Les chambres de l'hotel
			//	hotel.put("tarifEnfant", h.getChambreHotels());
				//hotel.put("tarifAdulte", h.getChambreHotels());
				hotelss.add(hotel);
			}

			out.println(hotelss);
		}
		resp.setStatus(HttpServletResponse.SC_OK);

		// Dans le cas d'une recherche
		// On recoit des paramètres
		// if((req.getParameter("departement")!=null)||)
		/*String dateDeb = req.getParameter("dateDeb");
		Date dated = Date.valueOf(dateDeb);
		String dateFin = req.getParameter("dateFin");
		Date datef = Date.valueOf(dateFin);
		String departement = req.getParameter("departement");
		String domaine = req.getParameter("domaine");
		String region = req.getParameter("region");
		// List<Festival> festis = fdao.findByBetweenDate(dated, datef);
		 * */
		
		hdao.closeConnection();
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du Hotel
		this.hdao = new HebergementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
		hdao.closeConnection();
	}

}
