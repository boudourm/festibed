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

import model.Region;
import persistance.RegionDAO;

public class RegionServlet extends HttpServlet {

	// Accéder aux données du departement
	RegionDAO rdao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du departement
		this.rdao = new RegionDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
				"Passw0rd");

		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();

		// Recuperer les donnees de la base

		List<Region> regions = rdao.findAll();

		if (regions.size() > 0) {
			// On crée une liste d'objets Json
			JSONArray regionss = new JSONArray();

			for (Region reg : regions) {
				// On crée un objet json pour stocker la region

				JSONObject region = new JSONObject();
				// System.out.println("\region nom : "+reg.getNom());
				region.put("nom", reg.getNomRegion());
				regionss.add(region);
			}

			out.println(regionss);
		}
		rdao.closeConnection();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du departement
		this.rdao = new RegionDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
				"Passw0rd");
		rdao.closeConnection();
	}

}
