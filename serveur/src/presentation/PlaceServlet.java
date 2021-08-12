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

import model.Festival;
import model.Place;
import persistance.FestivalDAO;
import persistance.PlaceDAO;

public class PlaceServlet extends HttpServlet {

	// Accéder aux données du festival
	FestivalDAO fdao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du festival
		this.fdao = new FestivalDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
				"Passw0rd");

		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		// Les places d'un festival

		// Si on a l'id du festival qu'on veut retourner
		if (req.getParameter("id") != null) {
			String id = req.getParameter("id");
			Festival f = fdao.find(id);
			List<Place> places = f.getPlaces();
			System.out.println("Nombre de places : " + places.size());
			if(places!=null)
			{
				for (Place p : places) {
					System.out.println("\n" + p.getIdPlace());
				}
				// On crée une liste d'objets Json
				JSONArray placess = new JSONArray();
				JSONObject place = new JSONObject();

				JSONArray catt = new JSONArray();
				JSONObject catp = new JSONObject();

				JSONArray catt1 = new JSONArray();
				JSONObject catp1 = new JSONObject();

				JSONArray catt2 = new JSONArray();
				JSONObject catp2 = new JSONObject();
				for (int i = 0; i < places.size(); i++) {
					Place pp = places.get(i);
					JSONObject cat = new JSONObject();
					JSONObject cat1 = new JSONObject();
					JSONObject cat2 = new JSONObject();
					if (i == 0) {
						if (pp.getCategoriePlace() == 0) {

							cat.put("date", "" + pp.getDateSoiree());
							cat.put("nbPlaces", pp.getNbPlaceDispo());
							cat.put("prix", pp.getPrixPlace());
							cat.put("id", pp.getIdPlace());
							catt.add(cat);
							place.put("cat1", null);
							place.put("cat2", null);
						} else {
							if (pp.getCategoriePlace() == 1) {

								cat1.put("date", "" + pp.getDateSoiree());
								cat1.put("nbPlaces", pp.getNbPlaceDispo());
								cat1.put("prix", pp.getPrixPlace());
								cat1.put("id", pp.getIdPlace());
								place.put("cat", null);
								catt1.add(cat1);
							}
							if (pp.getCategoriePlace() == 2) {

								cat2.put("date", "" + pp.getDateSoiree());
								cat2.put("nbPlaces", pp.getNbPlaceDispo());
								cat2.put("prix", pp.getPrixPlace());
								cat2.put("id", pp.getIdPlace());
								catt2.add(cat2);

							}
						}

					} else {
						if (pp.getCategoriePlace() == 0) {

							cat.put("date", "" + pp.getDateSoiree());
							cat.put("nbPlaces", pp.getNbPlaceDispo());
							cat.put("prix", pp.getPrixPlace());
							cat.put("id", pp.getIdPlace());
							catt.add(cat);
						} else {
							if (pp.getCategoriePlace() == 1) {

								cat1.put("date", "" + pp.getDateSoiree());
								cat1.put("nbPlaces", pp.getNbPlaceDispo());
								cat1.put("prix", pp.getPrixPlace());
								cat1.put("id", pp.getIdPlace());
								catt1.add(cat1);
							}
							if (pp.getCategoriePlace() == 2) {

								cat2.put("date", "" + pp.getDateSoiree());
								cat2.put("nbPlaces", pp.getNbPlaceDispo());
								cat2.put("prix", pp.getPrixPlace());
								cat2.put("id", pp.getIdPlace());
								catt2.add(cat2);

							}
						}
					}
					// placess.add(place);

				}
				catp.put("num", 0);
				catp.put("places", catt);
				placess.add(catp);
				catp1.put("num", 1);
				catp1.put("places", catt1);
				placess.add(catp1);
				catp2.put("num", 2);
				catp2.put("places", catt2);
				placess.add(catp2);
				out.println(placess);
			}
			/*
			 * else { System.out.println("appel au findall"); // On crée une liste d'objets
			 * Json JSONArray placess = new JSONArray(); List<Place> places =
			 * pdao.findAll(); for (Place p : places) { // On crée un objet json pour
			 * stocker le festival JSONObject place = new JSONObject();
			 * 
			 * place.put("id", p.getId()); place.put("categ", p.getCategoriePlace());
			 * place.put("date", ""+p.getDateSoiree()); place.put("festival",
			 * p.getMyFestival()); place.put("nbplaces", p.getNBPlacesDispo());
			 * place.put("prix", p.getPrixPlace());
			 * 
			 * placess.add(place); } out.println(placess); }
			 */

			}
			
		fdao.closeConnection();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du festival
		this.fdao = new FestivalDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
				"Passw0rd");
		fdao.closeConnection();
	}

}
