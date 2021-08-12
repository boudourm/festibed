package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Departement;
import model.Domaine;
import model.Festival;
import model.Place;
import persistance.FestivalDAO;
import persistance.PlaceDAO;

public class FestivalServlet extends HttpServlet {

	// Accéder aux données du festival
	FestivalDAO fdao;
	PlaceDAO pdao;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag",
					"boudourm", "Passw0rd");

			// Accéder aux données du festival
			this.fdao = new FestivalDAO(conn);
			this.pdao = new PlaceDAO(conn);

			String nom = req.getParameter("nom");
			String site = req.getParameter("site");
			float prixcat1 = Float.parseFloat(req.getParameter("prixcat1"));
			Integer NbPlaceCat1 = Integer.parseInt(req.getParameter("NbPlaceCat1"));
			float prixcat2 = Float.parseFloat(req.getParameter("prixcat2"));
			Integer NPlaceCat2 = Integer.parseInt(req.getParameter("NPlaceCat2"));
			String adresse = req.getParameter("nom");
			LocalDate dateDebut = LocalDate.parse(req.getParameter("dateDebut"));
			LocalDate dateFin = LocalDate.parse(req.getParameter("dateFin"));
			String Commune = req.getParameter("Commune");
			int CodePostal = Integer.parseInt(req.getParameter("CodePostal"));
			String departement = req.getParameter("departement");
			String domaine = req.getParameter("domaine");
			String complementDomaine = req.getParameter("complementDomaine");
			Festival f = new Festival();
			// Nom
			f.setNomManifestation(nom);
			// Code postal
			f.setCodePostalFestival(CodePostal);
			// Site
			f.setSiteWeb(site);
			// Commune
			f.setCommunePrincipaleF(Commune);
			Domaine d = new Domaine();
			Departement dep = new Departement();
			// Domaine
			d.setNomDomaine(domaine);
			dep.setNomDepartement(departement);
			// Departement
			f.setDomaine(d);
			fdao.create(f);
			// Places
			List<LocalDate> totalDates = new ArrayList<>();
			while (!dateDebut.isAfter(dateFin)) {
				totalDates.add(dateDebut);
				dateDebut = dateDebut.plusDays(1);
			}
			for (LocalDate date : totalDates) {
				if (NbPlaceCat1 == null) {
					// Place categ 0
					Place p = new Place();
					p.setFestival(f);
					p.setCategoriePlace(0);
					p.setPrixPlace(prixcat1);
					p.setDateSoiree(date);
					pdao.create(p);

				} else {
					// Place categ 1
					Place p1 = new Place();
					p1.setFestival(f);
					p1.setCategoriePlace(1);
					p1.setPrixPlace(prixcat1);
					p1.setDateSoiree(date);
					pdao.create(p1);
					// Place categ 2
					Place p2 = new Place();
					p2.setFestival(f);
					p2.setCategoriePlace(1);
					p2.setPrixPlace(prixcat1);
					p2.setDateSoiree(date);
					pdao.create(p2);
				}
			}

			fdao.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Accéder aux données du festival
		this.fdao = new FestivalDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm",
				"Passw0rd");

		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();

		// Si on a l'id du festival qu'on veut retourner
		if (req.getParameter("id") != null) {
			String id = req.getParameter("id");
			System.out.println("id : " + id);
			Festival f = fdao.find(id);
			JSONObject festival = new JSONObject();
			festival.put("id", f.getNumeroIdentification());
			// System.out.println("\nid" + f.getNumeroIdentification());
			festival.put("nom", f.getNomManifestation());
			// System.out.println("\\nnom" + f.getNomManifestation());
			festival.put("siteWeb", f.getSiteWeb());
			// System.out.println("\\nsiteWeb" + f.getsiteWeb());
			festival.put("dateDebut", "" + f.getDateDebutF());
			// System.out.println("\\ndateDebut" + f.getdateDebut());
			festival.put("dateFin", "" + f.getDateFinF());
			// System.out.println("\\ndateFin" + f.getdateFin());
			festival.put("coordonnees", f.getCoordonneesF());
			// System.out.println("\\ncoordonnees" + f.getcoordonnes());
			festival.put("nbPlaceTotal", f.getNbPlacesFestival());
			// System.out.println("\\nnbPlaceTotal" + f.getnbPlace_TotalDispo());
			festival.put("commune", f.getCommunePrincipaleF());
			// System.out.println("\ncommune" + f.getcommunePrincipale());
			festival.put("codePostal", f.getCodePostalFestival());
			// System.out.println("\\ncodePostal" + f.getcodePostal());

			out.println(festival);
		} else {
			// Recuperer les donnees de la base
			List<Festival> festivals = fdao.findAll();
			if (festivals.size() > 0) {
				// On crée une liste d'objets Json
				JSONArray festivalss = new JSONArray();

				for (Festival f : festivals) {
					// On crée un objet json pour stocker le festival
					JSONObject festival = new JSONObject();

					festival.put("id", f.getNumeroIdentification());
					festival.put("nom", f.getNomManifestation());
					festival.put("siteWeb", f.getSiteWeb());
					festival.put("dateDebut", "" + f.getDateDebutF());
					festival.put("dateFin", "" + f.getDateFinF());
					festival.put("coordonnees", f.getCoordonneesF());
					festival.put("nbPlaceTotal", f.getNbPlacesFestival());
					festival.put("commune", f.getCommunePrincipaleF());
					festival.put("codePostal", f.getCodePostalFestival());

					festivalss.add(festival);
				}

				out.println(festivalss);
			}

		}
		if (req.getParameter("dateD") != null ) {

			// Dans le cas d'une recherche //On recoit des paramètres
			String nom = req.getParameter("nom");
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu MMM dd");
			//LocalDate dateDebut = LocalDate.parse(req.getParameter("dateD" ), dateTimeFormatter);
			String[] date = req.getParameter("dateD" ).split("-");
			LocalDate dateDebut = LocalDate.of(Integer.valueOf(date[2]),Integer.valueOf(date[1]), Integer.valueOf(date[0]));
			String[] date1 = req.getParameter("dateF" ).split("-");
			LocalDate dateFin = LocalDate.of(Integer.valueOf(date[2]),Integer.valueOf(date[1]), Integer.valueOf(date[0]));

			//LocalDate dateFin = LocalDate.parse(req.getParameter("dateF") , dateTimeFormatter);
			String departement = req.getParameter("dep");
			String domaine = req.getParameter("dom");
			String region = req.getParameter("reg");
			String prixF = req.getParameter("prixF");
			if(prixF==null)
			{
				
				
				// Recuperer les donnees de la base
				List<Festival> festivals = fdao.findByCretaria(nom, region, domaine, dateDebut, dateFin);
				if (festivals.size() > 0) {
					// On crée une liste d'objets Json
					JSONArray festivalss = new JSONArray();

					for (Festival f : festivals) {
						// On crée un objet json pour stocker le festival
						JSONObject festival = new JSONObject();

						festival.put("id", f.getNumeroIdentification());
						festival.put("nom", f.getNomManifestation());
						festival.put("siteWeb", f.getSiteWeb());
						festival.put("dateDebut", "" + f.getDateDebutF());
						festival.put("dateFin", "" + f.getDateFinF());
						festival.put("coordonnees", f.getCoordonneesF());
						festival.put("nbPlaceTotal", f.getNbPlacesFestival());
						festival.put("commune", f.getCommunePrincipaleF());
						festival.put("codePostal", f.getCodePostalFestival());

						festivalss.add(festival);
					}

					out.println(festivalss);
				}

			}
			else
			{
				System.out.println("esle");
				Float prixFx = Float.parseFloat(req.getParameter("prixF"));
				// Recuperer les donnees de la base
				List<Festival> festivals = fdao.findByCretaria(nom, region, domaine, dateDebut, dateFin , prixFx);
				if (festivals.size() > 0) {
					// On crée une liste d'objets Json
					JSONArray festivalss = new JSONArray();

					for (Festival f : festivals) {
						// On crée un objet json pour stocker le festival
						JSONObject festival = new JSONObject();

						festival.put("id", f.getNumeroIdentification());
						festival.put("nom", f.getNomManifestation());
						festival.put("siteWeb", f.getSiteWeb());
						festival.put("dateDebut", "" + f.getDateDebutF());
						festival.put("dateFin", "" + f.getDateFinF());
						festival.put("coordonnees", f.getCoordonneesF());
						festival.put("nbPlaceTotal", f.getNbPlacesFestival());
						festival.put("commune", f.getCommunePrincipaleF());
						festival.put("codePostal", f.getCodePostalFestival());

						festivalss.add(festival);
					}

					out.println(festivalss);
				}
			}
				

		}

		// CLOSE CONNECTION

		fdao.closeConnection();
	}


}
