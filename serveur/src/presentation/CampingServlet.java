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

public class CampingServlet extends HttpServlet {

	// Accéder aux données du VillageVacance
	HebergementDAO hdao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Acces aux données
		this.hdao = new HebergementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
				"Passw0rd");

		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();

		
		
		if(req.getParameter("id")!=null)
		{
			int id = Integer.parseInt(req.getParameter("id"));
			System.out.println("id :: " +id);
			// Recuperer les donnees de la base
			Hebergement h = hdao.find(id);
			
				JSONObject campin = new JSONObject();

				campin.put("id", h.getIdHebergement());
				campin.put("nom", h.getNomCommercialH());
				campin.put("courrier", h.getCourrierH());
				campin.put("classement", "" + h.getClassementH());
				campin.put("site", "" + h.getSiteInternet());
				campin.put("coordonnees", h.getCoordonneesH());
				campin.put("note", h.getNoteH());
				campin.put("description", h.getDescriptionH());
				campin.put("adresse", h.getAdresseH());
				campin.put("commune", h.getCommuneH());
				//campin.put("departement", h.getDepartement());
				campin.put("commune", h.getCommuneH());
				campin.put("codePostal", h.getCodePostalH());

				// Les chambres de l'hotel
				// hotel.put("tarifEnfant", h.getChambreHotels());
				// hotel.put("tarifAdulte", h.getChambreHotels());
				
			

			out.println(campin);
		}
		else 
			
		{
			// Recuperer les donnees de la base
			List<Hebergement> campings = hdao.findByTypologie("CAMPING");
			if (campings.size() > 0) {
				// On crée une liste d'objets Json
				JSONArray campingss = new JSONArray();

				for (Hebergement h : campings) {
					// On crée un objet json pour stocker le festival
					JSONObject camping = new JSONObject();

					camping.put("id", h.getIdHebergement());
					camping.put("nom", h.getNomCommercialH());
					camping.put("courrier", h.getCourrierH());
					camping.put("classement", "" + h.getClassementH());
					camping.put("site", "" + h.getSiteInternet());
					camping.put("coordonnees", h.getCoordonneesH());
					camping.put("note", h.getNoteH());
					camping.put("description", h.getDescriptionH());
					camping.put("adresse", h.getAdresseH());
					camping.put("commune", h.getCommuneH());
					//camping.put("departement", h.getDepartement());
					camping.put("codePostal", h.getCodePostalH());
					// List<ChambreHotel> chambres = h.getChambreHotels();
					// Les chambres de l'hotel
					// hotel.put("tarifEnfant", h.getChambreHotels());
					// hotel.put("tarifAdulte", h.getChambreHotels());
					campingss.add(camping);
				}

				out.println(campingss);
		}
		
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
		// Acces aux données
		this.hdao = new HebergementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
				"Passw0rd");
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
