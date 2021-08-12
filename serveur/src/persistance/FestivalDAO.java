package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.ComplementDomaine;
import model.Domaine;
import model.Festival;
import model.Organisateur;
import model.Place;

public class FestivalDAO extends OracleDAO<Festival>
{
	public FestivalDAO(Connection connection) {
		super(connection);
}
	public FestivalDAO(String url, String user, String password) {
		super(url, user, password);
	}
	@Override
	public Festival find(Integer id) {
		return null;
		}
	
	//Gets the festival and Places without the rest
	public Festival find(String numreoIdentificaion)
	{
		Festival h = new Festival();
		try {	      
		      String sql = "SELECT * FROM FESTIVAL WHERE NUMEROIDENTIFICATION = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  this.preparedStatement.setString(1, numreoIdentificaion);				
			  this.resultSet  = preparedStatement.executeQuery();
			  //System.out.println(this.resultSet.next());
		      if(this.resultSet.next()) {
			    		/*  NUMEROIDENTIFICATION INTEGER  NOT NULL, 1
						    NOMDOMAINE VARCHAR2(254)  NOT NULL,		2
						    DEPTSK INTEGER  NOT NULL,				3
						    NONSOUSDOMAINE VARCHAR2(254)  NOT NULL,	4
						    IDUTILISATEUR INTEGER  NOT NULL,		5
						    NOMMANIFESTATION VARCHAR2(254)  NULL,	6
						    MOISHABITUELLE VARCHAR2(254)  NULL,		7
						    SITEWEB VARCHAR2(254)  NULL,			8
						    DATEDEBUTF DATE  NULL,					9
						    DATEFINF DATE  NULL,					10
						    DATECREATIONF DATE  NULL,				11
						    COORDONEESF VARCHAR2(254)  NULL,		12
						    CODEINSEEF VARCHAR2(254)  NULL,			13
						    NBPLACESTOTAL INTEGER  NULL,			14
						    COMMUNEPRINCIPALF VARCHAR2(254)  NULL,	15
						    CODEPOSTALFESTIVAL INTEGER  NULL,		16
						    AUTRESCOMMUNES VARCHAR2(254)  NULL		17
						 */	
			    		h = new Festival();
			    		h.setNumeroIdentification(this.resultSet.getString(1));
			    		h.setNomManifestation(this.resultSet.getString(6));
			    		h.setMoisHabituelle(this.resultSet.getString(7));
			    		h.setSiteWeb(this.resultSet.getString(8));
			    		java.sql.Date d = this.resultSet.getDate(9);
			    		if(d == null)
			    		{
			    			h.setDateDebutF(null);
			    		}
			    		else
			    		{
			    			h.setDateDebutF(d.toLocalDate());
			    		}
			    		d = this.resultSet.getDate(10);
			    		if(d == null)
			    		{
			    			h.setDateFinF(null);
			    		}
			    		else
			    		{
			    			h.setDateFinF(d.toLocalDate());
			    		}
			    		d = this.resultSet.getDate(11);
			    		if(d == null)
			    		{
			    			h.setDateCreationF(null);
			    		}
			    		else
			    		{
			    			h.setDateCreationF(d.toLocalDate());
			    		}
			    		h.setCoordonneesF(this.resultSet.getString(12));
			    		h.setCodeInseeF(this.resultSet.getString(13));
			    		h.setNbPlacesFestival(this.resultSet.getInt(14));
			    		h.setCommunePrincipaleF(this.resultSet.getString(15));
			    		h.setCodePostalFestival(this.resultSet.getInt(16));
			    		//association
			    		
			    		//Places			    		
			    		PlaceDAO placeDao = new PlaceDAO(this.connection);
			    		ArrayList<Place> places = (ArrayList<Place>) placeDao.findByFestival(h);
			    		h.setPlaces(places);		
			    		System.out.println(" \n place  : " + places );
			    		//Organisateur
			    		OrganisateurDAO organisateurDao = new OrganisateurDAO(this.connection);
			    		Organisateur organisateur = organisateurDao.find(this.resultSet.getInt(5));
			    			    		
			    		//Complement Domaine  	
			    		ComplementDomaine cd = new ComplementDomaine(this.resultSet.getString(4));
			    		h.setComplementDomaine(cd);		
			    		
			    		//Domaine
			    		h.setDomaine(new Domaine(this.resultSet.getString(2)));		
			    		
			    		//Departement
			    		DepartementDAO departementDAO = new DepartementDAO(this.connection);
			    		h.setDpartement(departementDAO.find(this.resultSet.getInt(3)));
		    		}
		      
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return h;

	}
	
	//Gets the festival without the rest
	public Festival findAsOrphan(String numreoIdentificaion)
	{
		Festival h = new Festival();
		try {	      
		      String sql = "SELECT * FROM FESTIVAL WHERE NUMEROIDENTIFICATION = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  this.preparedStatement.setString(1, numreoIdentificaion);				
			  this.resultSet  = preparedStatement.executeQuery(); 
		      if(this.resultSet.next()) {
			    		/*  NUMEROIDENTIFICATION INTEGER  NOT NULL, 1
						    NOMDOMAINE VARCHAR2(254)  NOT NULL,		2
						    DEPTSK INTEGER  NOT NULL,				3
						    NONSOUSDOMAINE VARCHAR2(254)  NOT NULL,	4
						    IDUTILISATEUR INTEGER  NOT NULL,		5
						    NOMMANIFESTATION VARCHAR2(254)  NULL,	6
						    MOISHABITUELLE VARCHAR2(254)  NULL,		7
						    SITEWEB VARCHAR2(254)  NULL,			8
						    DATEDEBUTF DATE  NULL,					9
						    DATEFINF DATE  NULL,					10
						    DATECREATIONF DATE  NULL,				11
						    COORDONEESF VARCHAR2(254)  NULL,		12
						    CODEINSEEF VARCHAR2(254)  NULL,			13
						    NBPLACESTOTAL INTEGER  NULL,			14
						    COMMUNEPRINCIPALF VARCHAR2(254)  NULL,	15
						    CODEPOSTALFESTIVAL INTEGER  NULL,		16
						    AUTRESCOMMUNES VARCHAR2(254)  NULL		17
						 */	
			    		h = new Festival();
			    		h.setNumeroIdentification(this.resultSet.getString(1));
			    		h.setNomManifestation(this.resultSet.getString(6));
			    		h.setMoisHabituelle(this.resultSet.getString(7));
			    		h.setSiteWeb(this.resultSet.getString(8));
			    		java.sql.Date d = this.resultSet.getDate(9);
			    		if(d == null)
			    		{
			    			h.setDateDebutF(null);
			    		}
			    		else
			    		{
			    			h.setDateDebutF(d.toLocalDate());
			    		}
			    		d = this.resultSet.getDate(10);
			    		if(d == null)
			    		{
			    			h.setDateFinF(null);
			    		}
			    		else
			    		{
			    			h.setDateFinF(d.toLocalDate());
			    		}
			    		d = this.resultSet.getDate(11);
			    		if(d == null)
			    		{
			    			h.setDateCreationF(null);
			    		}
			    		else
			    		{
			    			h.setDateCreationF(d.toLocalDate());
			    		}
			    		h.setCoordonneesF(this.resultSet.getString(12));
			    		h.setCodeInseeF(this.resultSet.getString(13));
			    		h.setNbPlacesFestival(this.resultSet.getInt(14));
			    		h.setCommunePrincipaleF(this.resultSet.getString(15));
			    		h.setCodePostalFestival(this.resultSet.getInt(16));
			    		//association
			    			
			    		
			    		//Organisateur
			    		OrganisateurDAO organisateurDao = new OrganisateurDAO(this.connection);
			    		Organisateur organisateur = organisateurDao.find(this.resultSet.getInt(5));
			    		
			    		//Complement Domaine  	
			    		ComplementDomaine cd = new ComplementDomaine(this.resultSet.getString(4));
			    		h.setComplementDomaine(cd);		
			    		
			    		//Domaine
			    		h.setDomaine(new Domaine(this.resultSet.getString(2)));		
			    		
			    		//Departement
			    		DepartementDAO departementDAO = new DepartementDAO(this.connection);
			    		h.setDpartement(departementDAO.find(this.resultSet.getInt(3)));
		    		}
		      
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return h;

	}	
	
	public List<Festival> findByCretaria(String nomDepartement , String nomRegion, String nomDomaine, LocalDate dateMin, LocalDate dateMax)
	{
		Festival h = new Festival();
		List<Festival> festivals = new ArrayList<Festival>();
		try {	      
		      String sql = "SELECT  f.* " + 
		      		"FROM FESTIVAL f  , DEPATREMENT  d  " + 
		      		"WHERE f.DEPTSK = d.DEPTSK  " + 
		      		"AND   (?  IS NULL OR ?  = f.NOMDOMAINE) " + 
		      		"AND   (?  IS NULL OR ?   =   d.NOMREGION)  " + 
		      		"AND   (? IS NULL OR ? = d.NOMDEPARTEMENT) " + 
		      		"AND   (? IS NULL OR  f.DATEDEBUTF  >=  ?) " + 
		      		"AND   (? IS NULL OR  f.DATEFINF <= ?) ";
		      System.out.println("Domaines :" + nomDomaine);
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  this.preparedStatement.setString(1, nomDomaine);	
			  this.preparedStatement.setString(2, nomDomaine);
			  this.preparedStatement.setString(3, nomRegion);	
			  this.preparedStatement.setString(4, nomRegion);
			  this.preparedStatement.setString(5, nomDepartement);	
			  this.preparedStatement.setString(6, nomDepartement);
			  this.preparedStatement.setDate(7, java.sql.Date.valueOf(dateMin));
			  this.preparedStatement.setDate(8, java.sql.Date.valueOf(dateMin));
			  this.preparedStatement.setDate(9, java.sql.Date.valueOf(dateMax));
			  this.preparedStatement.setDate(10, java.sql.Date.valueOf(dateMax));
			  this.resultSet  = preparedStatement.executeQuery(); 
		      while(this.resultSet.next()) {
			    		/*  NUMEROIDENTIFICATION INTEGER  NOT NULL, 1
						    NOMDOMAINE VARCHAR2(254)  NOT NULL,		2
						    DEPTSK INTEGER  NOT NULL,				3
						    NONSOUSDOMAINE VARCHAR2(254)  NOT NULL,	4
						    IDUTILISATEUR INTEGER  NOT NULL,		5
						    NOMMANIFESTATION VARCHAR2(254)  NULL,	6
						    MOISHABITUELLE VARCHAR2(254)  NULL,		7
						    SITEWEB VARCHAR2(254)  NULL,			8
						    DATEDEBUTF DATE  NULL,					9
						    DATEFINF DATE  NULL,					10
						    DATECREATIONF DATE  NULL,				11
						    COORDONEESF VARCHAR2(254)  NULL,		12
						    CODEINSEEF VARCHAR2(254)  NULL,			13
						    NBPLACESTOTAL INTEGER  NULL,			14
						    COMMUNEPRINCIPALF VARCHAR2(254)  NULL,	15
						    CODEPOSTALFESTIVAL INTEGER  NULL,		16
						    AUTRESCOMMUNES VARCHAR2(254)  NULL		17
						 */	
			    		h = new Festival();
			    		h.setNumeroIdentification(this.resultSet.getString(1));
			    		h.setNomManifestation(this.resultSet.getString(6));
			    		h.setMoisHabituelle(this.resultSet.getString(7));
			    		h.setSiteWeb(this.resultSet.getString(8));
			    		java.sql.Date d = this.resultSet.getDate(9);
			    		if(d == null)
			    		{
			    			h.setDateDebutF(null);
			    		}
			    		else
			    		{
			    			h.setDateDebutF(d.toLocalDate());
			    		}
			    		d = this.resultSet.getDate(10);
			    		if(d == null)
			    		{
			    			h.setDateFinF(null);
			    		}
			    		else
			    		{
			    			h.setDateFinF(d.toLocalDate());
			    		}
			    		d = this.resultSet.getDate(11);
			    		if(d == null)
			    		{
			    			h.setDateCreationF(null);
			    		}
			    		else
			    		{
			    			h.setDateCreationF(d.toLocalDate());
			    		}
			    		h.setCoordonneesF(this.resultSet.getString(12));
			    		h.setCodeInseeF(this.resultSet.getString(13));
			    		h.setNbPlacesFestival(this.resultSet.getInt(14));
			    		h.setCommunePrincipaleF(this.resultSet.getString(15));
			    		h.setCodePostalFestival(this.resultSet.getInt(16));
			    		//association
			    			
			    		
			    		//Organisateur
			    		OrganisateurDAO organisateurDao = new OrganisateurDAO(this.connection);
			    		Organisateur organisateur = organisateurDao.find(this.resultSet.getInt(5));
			    			
			    		
			    		//Complement Domaine  	
			    		ComplementDomaine cd = new ComplementDomaine(this.resultSet.getString(4));
			    		h.setComplementDomaine(cd);		
			    		
			    		//Domaine
			    		h.setDomaine(new Domaine(this.resultSet.getString(2)));		
			    		
			    		//Departement
			    		DepartementDAO departementDAO = new DepartementDAO(this.connection);
			    		h.setDpartement(departementDAO.find(this.resultSet.getInt(3)));
			    		festivals.add(h);
			    		
		    		}
		      
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return festivals;

	}	
	public List<Festival> findByCretaria(String nomDepartement , String nomRegion, String nomDomaine, LocalDate dateMin, LocalDate dateMax, Float prixMax)
	{
		Festival h = new Festival();
		 List<Festival> festivals = new ArrayList<Festival>();
		try {	      
		      String sql = "SELECT DISTINCT f.* " + 
		      		"FROM FESTIVAL f , Place p , DEPATREMENT  d " + 
		      		"WHERE f.NUMEROIDENTIFICATION = p.NUMEROIDENTIFICATION " + 
		      		"AND   f.DEPTSK = d.DEPTSK " + 
		      		"AND   (?  IS NULL OR ?  = f.NOMDOMAINE) " + 
		      		"AND   (?  IS NULL OR ?   =   d.NOMREGION)  " + 
		      		"AND   (? IS NULL OR ? = d.NOMDEPARTEMENT) " + 
		      		"AND   (? IS NULL OR  f.DATEDEBUTF  >=  ?) " + 
		      		"AND   (? IS NULL OR  f.DATEFINF <= ?) "+
		      		"AND   (? IS NULL OR  maxprice(f.NUMEROIDENTIFICATION) <= ?)";
		     
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  this.preparedStatement.setString(1, nomDomaine);	
			  this.preparedStatement.setString(2, nomDomaine);
			  this.preparedStatement.setString(3, nomRegion);	
			  this.preparedStatement.setString(4, nomRegion);
			  this.preparedStatement.setString(5, nomDepartement);	
			  this.preparedStatement.setString(6, nomDepartement);
			  this.preparedStatement.setDate(7, java.sql.Date.valueOf(dateMin));
			  this.preparedStatement.setDate(8, java.sql.Date.valueOf(dateMin));
			  this.preparedStatement.setDate(9, java.sql.Date.valueOf(dateMax));
			  this.preparedStatement.setDate(10, java.sql.Date.valueOf(dateMax));
			  this.preparedStatement.setFloat(11, prixMax);
			  this.preparedStatement.setFloat(12, prixMax);
			  
			  this.resultSet  = preparedStatement.executeQuery(); 
			 
		      while(this.resultSet.next()) {
			    		/*  NUMEROIDENTIFICATION INTEGER  NOT NULL, 1
						    NOMDOMAINE VARCHAR2(254)  NOT NULL,		2
						    DEPTSK INTEGER  NOT NULL,				3
						    NONSOUSDOMAINE VARCHAR2(254)  NOT NULL,	4
						    IDUTILISATEUR INTEGER  NOT NULL,		5
						    NOMMANIFESTATION VARCHAR2(254)  NULL,	6
						    MOISHABITUELLE VARCHAR2(254)  NULL,		7
						    SITEWEB VARCHAR2(254)  NULL,			8
						    DATEDEBUTF DATE  NULL,					9
						    DATEFINF DATE  NULL,					10
						    DATECREATIONF DATE  NULL,				11
						    COORDONEESF VARCHAR2(254)  NULL,		12
						    CODEINSEEF VARCHAR2(254)  NULL,			13
						    NBPLACESTOTAL INTEGER  NULL,			14
						    COMMUNEPRINCIPALF VARCHAR2(254)  NULL,	15
						    CODEPOSTALFESTIVAL INTEGER  NULL,		16
						    AUTRESCOMMUNES VARCHAR2(254)  NULL		17
						 */	
			    		h = new Festival();
			    		h.setNumeroIdentification(this.resultSet.getString(1));
			    		h.setNomManifestation(this.resultSet.getString(6));
			    		h.setMoisHabituelle(this.resultSet.getString(7));
			    		h.setSiteWeb(this.resultSet.getString(8));
			    		java.sql.Date d = this.resultSet.getDate(9);
			    		if(d == null)
			    		{
			    			h.setDateDebutF(null);
			    		}
			    		else
			    		{
			    			h.setDateDebutF(d.toLocalDate());
			    		}
			    		d = this.resultSet.getDate(10);
			    		if(d == null)
			    		{
			    			h.setDateFinF(null);
			    		}
			    		else
			    		{
			    			h.setDateFinF(d.toLocalDate());
			    		}
			    		d = this.resultSet.getDate(11);
			    		if(d == null)
			    		{
			    			h.setDateCreationF(null);
			    		}
			    		else
			    		{
			    			h.setDateCreationF(d.toLocalDate());
			    		}
			    		h.setCoordonneesF(this.resultSet.getString(12));
			    		h.setCodeInseeF(this.resultSet.getString(13));
			    		h.setNbPlacesFestival(this.resultSet.getInt(14));
			    		h.setCommunePrincipaleF(this.resultSet.getString(15));
			    		h.setCodePostalFestival(this.resultSet.getInt(16));
			    		//association
			    			
			    		
			    		//Organisateur
			    		OrganisateurDAO organisateurDao = new OrganisateurDAO(this.connection);
			    		Organisateur organisateur = organisateurDao.find(this.resultSet.getInt(5));
			    			
			    		
			    		//Complement Domaine  	
			    		ComplementDomaine cd = new ComplementDomaine(this.resultSet.getString(4));
			    		h.setComplementDomaine(cd);		
			    		
			    		//Domaine
			    		h.setDomaine(new Domaine(this.resultSet.getString(2)));		
			    		
			    		//Departement
			    		DepartementDAO departementDAO = new DepartementDAO(this.connection);
			    		h.setDpartement(departementDAO.find(this.resultSet.getInt(3)));
		    	festivals.add(h);	
		      }
		      
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return festivals;

	}		
	
	@Override
	public int create(Festival object) {
		int key = 0;
		try {
			  String sql = "INSERT INTO FESTIVAL(NOMDOMAINE,DEPTSK,NONSOUSDOMAINE,IDUTILISATEUR,NOMMANIFESTATION,MOISHABITUELLE,SITEWEB,DATEDEBUTF,DATEFINF,DATECREATIONF,COORDONEESF,CODEINSEEF,NBPLACESTOTAL,COMMUNEPRINCIPALF,CODEPOSTALFESTIVAL,AUTRESCOMMUNES) "
			  		+ "VALUES (?,?,?,?,?,?,?, ?, ?, ?,?,?,?,?,?,?)";
			  /*
			   * /*  NUMEROIDENTIFICATION INTEGER  NOT NULL, 1
						    NOMDOMAINE VARCHAR2(254)  NOT NULL,		2
						    DEPTSK INTEGER  NOT NULL,				3
						    NONSOUSDOMAINE VARCHAR2(254)  NOT NULL,	4
						    IDUTILISATEUR INTEGER  NOT NULL,		5
						    NOMMANIFESTATION VARCHAR2(254)  NULL,	6
						    MOISHABITUELLE VARCHAR2(254)  NULL,		7
						    SITEWEB VARCHAR2(254)  NULL,			8
						    DATEDEBUTF DATE  NULL,					9
						    DATEFINF DATE  NULL,					10
						    DATECREATIONF DATE  NULL,				11
						    COORDONEESF VARCHAR2(254)  NULL,		12
						    CODEINSEEF VARCHAR2(254)  NULL,			13
						    NBPLACESTOTAL INTEGER  NULL,			14
						    COMMUNEPRINCIPALF VARCHAR2(254)  NULL,	15
						    CODEPOSTALFESTIVAL INTEGER  NULL,		16
						    AUTRESCOMMUNES VARCHAR2(254)  NULL		17
						 */	
		      this.preparedStatement = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			  //this.preparedStatement.setString(1, object.getNumeroIdentification());
			  this.preparedStatement.setString(1, object.getDomaine().getNomDomaine());
			  this.preparedStatement.setInt(2, object.getDpartement().getDeptSk());
			  this.preparedStatement.setString(3, object.getComplementDomaine().getNomSousDomaine());
			  this.preparedStatement.setInt(4, object.getOrganisateur().getIdUtilisateur());
			  this.preparedStatement.setString(5, object.getNomManifestation());
			  this.preparedStatement.setString(6, object.getMoisHabituelle());
			  this.preparedStatement.setString(7, object.getSiteWeb());
			  this.preparedStatement.setDate(8, java.sql.Date.valueOf(object.getDateDebutF()));
			  this.preparedStatement.setDate(9, java.sql.Date.valueOf(object.getDateFinF()));
			  this.preparedStatement.setDate(10, java.sql.Date.valueOf(object.getDateCreationF()));
			  this.preparedStatement.setString(11,object.getCoordonneesF());
			  this.preparedStatement.setString(12,object.getCodeInseeF());
			  this.preparedStatement.setInt(13,object.getNbPlacesFestival());
			  this.preparedStatement.setString(14,object.getCommunePrincipaleF());
			  this.preparedStatement.setInt(15,object.getCodePostalFestival());
			  this.preparedStatement.setString(16,object.getAutresCommunes());
			  			  
			  preparedStatement.executeUpdate(); 
			  
			  ResultSet generatedKeys = this.preparedStatement.getGeneratedKeys();
		       if (generatedKeys.next()) 
		       {
		           key = (int) generatedKeys.getLong(1); 
		       }
		       
		      this.preparedStatement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}
	
	@Override
	public boolean update(Festival object) {
		//not yet
		return false;
	}
	
	@Override
	public boolean delete(Festival object) {
		int rows = 0;
		try {
			  String sql = "DELETE FROM FESTIVAL " + 
			  		"WHERE NUMEROIDENTIFICATION = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  preparedStatement.setString(1, object.getNumeroIdentification());			  
			  rows  = preparedStatement.executeUpdate(); 
		      this.preparedStatement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return (rows>0);
	}
	
	public List<Festival> findByOrganisateur(Organisateur organisateur) {
		ArrayList<Festival> festivals = new ArrayList<Festival>();
		
		try {
		      String sql = "SELECT * FROM FESTIVAL WHERE IDUTILISATEUR = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
		      this.preparedStatement.setInt(1, organisateur.getIdUtilisateur());				
			  this.resultSet  = preparedStatement.executeQuery(); 
		      
		      while(this.resultSet.next()) {
		    	 
		    		/*  NUMEROIDENTIFICATION INTEGER  NOT NULL, 1
					    NOMDOMAINE VARCHAR2(254)  NOT NULL,		2
					    DEPTSK INTEGER  NOT NULL,				3
					    NONSOUSDOMAINE VARCHAR2(254)  NOT NULL,	4
					    IDUTILISATEUR INTEGER  NOT NULL,		5
					    NOMMANIFESTATION VARCHAR2(254)  NULL,	6
					    MOISHABITUELLE VARCHAR2(254)  NULL,		7
					    SITEWEB VARCHAR2(254)  NULL,			8
					    DATEDEBUTF DATE  NULL,					9
					    DATEFINF DATE  NULL,					10
					    DATECREATIONF DATE  NULL,				11
					    COORDONEESF VARCHAR2(254)  NULL,		12
					    CODEINSEEF VARCHAR2(254)  NULL,			13
					    NBPLACESTOTAL INTEGER  NULL,			14
					    COMMUNEPRINCIPALF VARCHAR2(254)  NULL,	15
					    CODEPOSTALFESTIVAL INTEGER  NULL,		16
					    AUTRESCOMMUNES VARCHAR2(254)  NULL		17*/	
		    		Festival h ;
		    		h = new Festival();
		    		h.setNumeroIdentification(this.resultSet.getString(1));
		    		h.setNomManifestation(this.resultSet.getString(6));
		    		h.setMoisHabituelle(this.resultSet.getString(7));
		    		h.setSiteWeb(this.resultSet.getString(8));
		    		java.sql.Date d = this.resultSet.getDate(9);
		    		if(d == null)
		    		{
		    			h.setDateDebutF(null);
		    		}
		    		else
		    		{
		    			h.setDateDebutF(d.toLocalDate());
		    		}
		    		d = this.resultSet.getDate(10);
		    		if(d == null)
		    		{
		    			h.setDateFinF(null);
		    		}
		    		else
		    		{
		    			h.setDateFinF(d.toLocalDate());
		    		}
		    		d = this.resultSet.getDate(11);
		    		if(d == null)
		    		{
		    			h.setDateCreationF(null);
		    		}
		    		else
		    		{
		    			h.setDateCreationF(d.toLocalDate());
		    		}
		    		h.setCoordonneesF(this.resultSet.getString(12));
		    		h.setCodeInseeF(this.resultSet.getString(13));
		    		h.setNbPlacesFestival(this.resultSet.getInt(14));
		    		h.setCommunePrincipaleF(this.resultSet.getString(15));
		    		h.setCodePostalFestival(this.resultSet.getInt(16));
		    		//association
		    		
		    		//Places			    		
		    		PlaceDAO placeDao = new PlaceDAO(this.connection);
		    		ArrayList<Place> places = (ArrayList<Place>) placeDao.findByFestival(h);
		    		h.setPlaces(places);		
		    		
		    		//Organisateur
		    		h.setOrganisateur(organisateur);		    		
		    		//Complement Domaine  	
		    		ComplementDomaine cd = new ComplementDomaine(this.resultSet.getString(4));
		    		h.setComplementDomaine(cd);		
		    		
		    		//Domaine
		    		h.setDomaine(new Domaine(this.resultSet.getString(2)));		
		    		
		    		//Departement
		    		DepartementDAO departementDAO = new DepartementDAO(this.connection);
		    		h.setDpartement(departementDAO.find(this.resultSet.getInt(3)));

		    	festivals.add(h);
		      }

		      
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return festivals;
	}
	public List<Festival> findAll() {
		ArrayList<Festival> festivals = new ArrayList<Festival>();
		
		try {
		      String sql = "SELECT * FROM FESTIVAL";
		      this.preparedStatement = this.connection.prepareStatement(sql);			
			  this.resultSet  = preparedStatement.executeQuery(); 
		      int i = 10;
		      while(this.resultSet.next() && i>0) { i--;
		    	 
		    		/*  NUMEROIDENTIFICATION INTEGER  NOT NULL, 1
					    NOMDOMAINE VARCHAR2(254)  NOT NULL,		2
					    DEPTSK INTEGER  NOT NULL,				3
					    NONSOUSDOMAINE VARCHAR2(254)  NOT NULL,	4
					    IDUTILISATEUR INTEGER  NOT NULL,		5
					    NOMMANIFESTATION VARCHAR2(254)  NULL,	6
					    MOISHABITUELLE VARCHAR2(254)  NULL,		7
					    SITEWEB VARCHAR2(254)  NULL,			8
					    DATEDEBUTF DATE  NULL,					9
					    DATEFINF DATE  NULL,					10
					    DATECREATIONF DATE  NULL,				11
					    COORDONEESF VARCHAR2(254)  NULL,		12
					    CODEINSEEF VARCHAR2(254)  NULL,			13
					    NBPLACESTOTAL INTEGER  NULL,			14
					    COMMUNEPRINCIPALF VARCHAR2(254)  NULL,	15
					    CODEPOSTALFESTIVAL INTEGER  NULL,		16
					    AUTRESCOMMUNES VARCHAR2(254)  NULL		17*/	
		    		Festival h ;
		    		h = new Festival();
		    		h.setNumeroIdentification(this.resultSet.getString(1));
		    		h.setNomManifestation(this.resultSet.getString(6));
		    		h.setMoisHabituelle(this.resultSet.getString(7));
		    		h.setSiteWeb(this.resultSet.getString(8));
		    		java.sql.Date d = this.resultSet.getDate(9);
		    		if(d == null)
		    		{
		    			h.setDateDebutF(null);
		    		}
		    		else
		    		{
		    			h.setDateDebutF(d.toLocalDate());
		    		}
		    		d = this.resultSet.getDate(10);
		    		if(d == null)
		    		{
		    			h.setDateFinF(null);
		    		}
		    		else
		    		{
		    			h.setDateFinF(d.toLocalDate());
		    		}
		    		h.setCoordonneesF(this.resultSet.getString(12));
		    		h.setCodeInseeF(this.resultSet.getString(13));
		    		h.setNbPlacesFestival(this.resultSet.getInt(14));
		    		h.setCommunePrincipaleF(this.resultSet.getString(15));
		    		h.setCodePostalFestival(this.resultSet.getInt(16));
		    		//association
		    		
		    		//Places			    		
		    		PlaceDAO placeDao = new PlaceDAO(this.connection);
		    		ArrayList<Place> places = (ArrayList<Place>) placeDao.findByFestival(h);
		    		h.setPlaces(places);		
		    		
		    		//Organisateur
		    		OrganisateurDAO organisateurDao = new OrganisateurDAO(this.connection);
		    		Organisateur organisateur = organisateurDao.find(this.resultSet.getInt(5));
		    			    		
		    		//Complement Domaine  	
		    		ComplementDomaine cd = new ComplementDomaine(this.resultSet.getString(4));
		    		h.setComplementDomaine(cd);		
		    		
		    		//Domaine
		    		h.setDomaine(new Domaine(this.resultSet.getString(2)));		
		    		
		    		//Departement
		    		DepartementDAO departementDAO = new DepartementDAO(this.connection);
		    		h.setDpartement(departementDAO.find(this.resultSet.getInt(3)));

		    	festivals.add(h);
		      }

		      
		      this.resultSet.close();
		      this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return festivals;
	}


	/*
	 *findByMaxPrice
	 * findByBetweenDate
	 * findByDepartement
	 * findByDomaine
	 * findByRegion*/
	
	public static void main(String[] args) {
		FestivalDAO f = new FestivalDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
		for (Festival festival : f.findAll()) {
			System.out.println(festival);
		}
		LocalDate dateDebut = LocalDate.parse("2019-08-01");
		LocalDate dateFin = LocalDate.parse("2019-08-30");
		List<Festival> ff = f.findByCretaria(null, null, "Musiques actuelles", dateDebut, dateFin) ;
		System.out.println("ff " + ff.size());
	}
	@Override
	public Festival findForUpdate(Integer id) {
		return null;
	}

}