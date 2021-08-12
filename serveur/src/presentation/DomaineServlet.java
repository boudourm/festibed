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

import model.Domaine;
import persistance.DomaineDAO;

public class DomaineServlet extends HttpServlet {

	// Accéder aux données du domaine
	DomaineDAO ddao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du domaine
		this.ddao = new DomaineDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
				"Passw0rd");
		
		
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();

		// Recuperer les donnees de la base
		List<Domaine> domaines = ddao.findAll();

		if (domaines.size() > 0) {
			// On crée une liste d'objets Json
			JSONArray domainess = new JSONArray();

			for (Domaine dom : domaines) { 
				// On crée un objet json pour stocker le domaine

				JSONObject domaine = new JSONObject();
				JSONObject obj1 = new JSONObject();
				//System.out.println("Domaines nom : "+dom.getNomDomaine()+" \n");
				domaine.put("nom", dom.getNomDomaine());
				domainess.add(domaine);
			}

			out.println(domainess);
		}
		ddao.closeConnection();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du domaine
		 this.ddao = new DomaineDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
				"Passw0rd");
		 
		 
		 ddao.closeConnection();
		
	}

}
