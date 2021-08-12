package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Hebergement;
import persistance.HebergementDAO;

public class ResidenceServlet extends HttpServlet {

	// Accéder aux données du VillageVacance
	HebergementDAO hdao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Accéder aux données du VillageVacance
		this.hdao = new HebergementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
				"Passw0rd");
		
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();

		// Recuperer les donnees de la base
		List<Hebergement> residences = hdao.findByTypologie("RESIDENCE DE TOURISME");
		if (residences.size() > 0) {
			// On crée une liste d'objets Json
			JSONArray residencess = new JSONArray();

			for (Hebergement h : residences) {
				// On crée un objet json pour stocker le festival
				JSONObject residence = new JSONObject();

				residence.put("id", h.getIdHebergement());
				residence.put("nom", h.getNomCommercialH());
				residence.put("courrier", h.getCourrierH());
				residence.put("classement", "" + h.getClassementH());
				residence.put("site", "" + h.getSiteInternet());
				residence.put("coordonnees", h.getCoordonneesH());
				residence.put("note", h.getNoteH());
				residence.put("description", h.getDescriptionH());
				residence.put("adresse", h.getAdresseH());
				residence.put("commune", h.getCommuneH());
				//residence.put("departement", h.getDepartement());
				residence.put("codePostal", h.getCodePostalH());
				// List<ChambreHotel> chambres = h.getChambreHotels();
				// Les chambres de l'hotel
				// hotel.put("tarifEnfant", h.getChambreHotels());
				// hotel.put("tarifAdulte", h.getChambreHotels());
				residencess.add(residence);
			}

			out.println(residencess);
			
			
			hdao.closeConnection();
		}

		// Dans le cas d'une recherche
		// On recoit des paramètres
		// if((req.getParameter("departement")!=null)||)
		/*
		 * String dateDeb = req.getParameter("dateDeb"); Date dated =
		 * Date.valueOf(dateDeb); String dateFin = req.getParameter("dateFin"); Date
		 * datef = Date.valueOf(dateFin); String departement =
		 * req.getParameter("departement"); String domaine =
		 * req.getParameter("domaine"); String region = req.getParameter("region"); //
		 * List<Festival> festis = fdao.findByBetweenDate(dated, datef);
		 */

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du VillageVacance
				this.hdao = new HebergementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
						"Passw0rd");
				hdao.closeConnection();
	}

}
