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

import model.Festival;
import model.Hebergement;
import persistance.HebergementDAO;

public class HebergementServlet extends HttpServlet {

	// Accéder aux données du Hebergement
	HebergementDAO hdao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du Hebergement
		this.hdao = new HebergementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag",
				"boudourm", "Passw0rd");

		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();

		// Recuperer les donnees de la base
		List<Hebergement> hebergements = hdao.findAll();
		if (hebergements.size() > 0) {
			// On crée une liste d'objets Json
			JSONArray hebergementss = new JSONArray();

			for (Hebergement h : hebergements) {
				// On crée un objet json pour stocker le festival
				JSONObject hebergement = new JSONObject();
				/*
				hebergement.put("id", h.getId());
				hebergement.put("nom", h.getNomCommercial());
				hebergement.put("courrier", h.getCourrier());
				hebergement.put("classement", "" + h.getClassement());
				hebergement.put("site", "" + h.getSiteInternet());
				hebergement.put("coordonnees", h.getCoordonnes());
				hebergement.put("note", h.getNote());
				hebergement.put("description", h.getDescription());
				hebergement.put("adresse", h.getAdresse());
				hebergement.put("commune", h.getCommune());
				hebergement.put("departement", h.getCommune());
				hebergement.put("commune", h.getCommune());
				hebergement.put("codePostal", h.getCodePostal());
*/
				hebergementss.add(hebergement);
			}

			out.println(hebergementss);
		}

		// Dans le cas d'une recherche
		// On recoit des paramètres
		// if((req.getParameter("departement")!=null)||)
		String dateDeb = req.getParameter("dateDeb");
		Date dated = Date.valueOf(dateDeb);
		String dateFin = req.getParameter("dateFin");
		Date datef = Date.valueOf(dateFin);
		String departement = req.getParameter("departement");
		String domaine = req.getParameter("domaine");
		String region = req.getParameter("region");
		// List<Festival> festis = fdao.findByBetweenDate(dated, datef);
		
		hdao.closeConnection();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
