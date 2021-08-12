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

public class VillageVacanceServlet extends HttpServlet {

	// Accéder aux données du VillageVacance
	HebergementDAO hdao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du VillageVacance
		this.hdao = new HebergementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag",
				"boudourm", "Passw0rd");

		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();

		// Recuperer les donnees de la base
		List<Hebergement> villages = hdao.findByTypologie("VILLAGE DE VACANCES");
		if (villages.size() > 0) {
			// On crée une liste d'objets Json
			JSONArray villagess = new JSONArray();

			for (Hebergement h : villages) {
				// On crée un objet json pour stocker le festival
				JSONObject village = new JSONObject();

				village.put("id", h.getIdHebergement());
				village.put("nom", h.getNomCommercialH());
				village.put("courrier", h.getCourrierH());
				village.put("classement", "" + h.getClassementH());
				village.put("site", "" + h.getSiteInternet());
				village.put("coordonnees", h.getCoordonneesH());
				village.put("note", h.getNoteH());
				village.put("description", h.getDescriptionH());
				village.put("adresse", h.getAdresseH());
				village.put("commune", h.getCommuneH());
				//village.put("departement", h.getDepartement());
				village.put("codePostal", h.getCodePostalH());
				// List<ChambreHotel> chambres = h.getChambreHotels();
				// Les chambres de l'hotel
				// hotel.put("tarifEnfant", h.getChambreHotels());
				// hotel.put("tarifAdulte", h.getChambreHotels());
				villagess.add(village);
			}

			out.println(villagess);
		}

		// Dans le cas d'une recherche
		// if((req.getParameter("departement")!=null)||)
		/*
		 * String dateDeb = req.getParameter("dateDeb"); Date dated =
		 * Date.valueOf(dateDeb); String dateFin = req.getParameter("dateFin"); Date
		 * datef = Date.valueOf(dateFin); String departement =
		 * req.getParameter("departement"); String domaine =
		 * req.getParameter("domaine"); String region = req.getParameter("region"); //
		 * List<Festival> festis = fdao.findByBetweenDate(dated, datef);
		 */
		
		hdao.closeConnection();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du VillageVacance
				this.hdao = new HebergementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag",
						"boudourm", "Passw0rd");
				hdao.closeConnection();
	}

}
