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

import model.Departement;
import persistance.DepartementDAO;

public class DepartementServlet extends HttpServlet {

	// Accéder aux données du departement
	DepartementDAO ddao ;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		// Accéder aux données du departement
		this.ddao = new DepartementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
				"Passw0rd");
		
		
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();

		// Recuperer les donnees de la base

		List<Departement> departements = ddao.findAll();

		if (departements.size() > 0) {
			// On crée une liste d'objets Json
			JSONArray departementss = new JSONArray();

			for (Departement dep : departements) { 
				// On crée un objet json pour stocker le departement

				JSONObject departement = new JSONObject();
				//System.out.println("\ndepartement nom : "+dep.getNom()+"  sk "+dep.getSk());
				departement.put("sk", dep.getDeptSk());
				departement.put("nom", dep.getNomDepartement());
				departementss.add(departement);
			}

			out.println(departementss);
		}
		
		ddao.closeConnection();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du departement
		 this.ddao = new DepartementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
				"Passw0rd");
		 ddao.closeConnection();
	}

}
