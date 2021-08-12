package persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Hebergement;

public class HebergementDAO extends OracleDAO<Hebergement>
{

	
	public HebergementDAO(Connection connection) {
		super(connection);
}
	public HebergementDAO(String url, String user, String password) {
		super(url, user, password);

	}


	public static void main(String[] args) {
		//System.out.println(HebergementDAO.fakeBD);
		HebergementDAO f = new HebergementDAO("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "boudourm", "Passw0rd");
		for (Hebergement festival : f.findByTypologie("HOTEL")) {
			System.out.println(festival);
		}

	}
	
	@Override
	public Hebergement find(Integer id) {
		return null;

	}

	@Override
	public int create(Hebergement hebergement) {
				return 0;
	}

	@Override
	public boolean update(Hebergement object) {
		//Pas de Modif pour l'instant 
		return false;
	}

	@Override
	public boolean delete(Hebergement object) {
		return false;
	}

	@Override
	public List<Hebergement> findAll() {
		return null;
	}
	
	public List<Hebergement> findByTypologie(String typologie) {
		ArrayList<Hebergement> hebergements = new ArrayList<Hebergement>();
		
		try {
		      int i = 10;
		      String sql = "SELECT * FROM HEBERGEMENT WHERE TYPOLOGIEH = ?";
		      this.preparedStatement = this.connection.prepareStatement(sql);
			  this.preparedStatement.setString(1, typologie);				
			  this.resultSet  = preparedStatement.executeQuery(); 
		      
		      while(this.resultSet.next()  && i > 0 ) { i--;
		    	 
		    		/*      IDHEBERGEMENT INTEGER  NULL,			1
						    NOMDEPARTEMENT VARCHAR2(254)  NULL,		2
						    IDUTILISATEUR INTEGER  NULL,			3	
						    DATECLASSEMENTH DATE  NULL,				4
						    DATEPUBLICATIONH DATE  NULL,			5
						    TYPOLOGIEH VARCHAR2(254)  NULL,			6
						    CLASSEMENTH VARCHAR2(254)  NULL,		7
						    TELEPHONEH VARCHAR2(254)  NULL,			8
						    COURRIELH VARCHAR2(254)  NULL,			9
						    SITEINTERNETH VARCHAR2(254)  NULL,		10
						    CAPACITEACCEUILH INTEGER  NULL,			11
						    COORDONNEESH VARCHAR2(254)  NULL,		12
						    NOTEH FLOAT NULL,						13
						    DESCRIPTIONH VARCHAR2(254)  NULL,		14
						    NOMCOMERCIALH VARCHAR2(254)  NULL,		15
						    ADRESSEH VARCHAR2(254)  NULL,			16
						    CODEPOSTALH INTEGER  NULL,				17
						    COMMUNEH VARCHAR2(254)  NULL,  			18
						    NOMEPCI VARCHAR2(254)  NULL, 			19
					*/	
		    		Hebergement h = new Hebergement();
		    		h.setIdHebergement(this.resultSet.getInt(1));
		    		//Departement
		    		DepartementDAO deptdao = new DepartementDAO(this.connection);
		    		h.setDepartement(deptdao.find(this.resultSet.getString(2)));
		    		//Hebergeur
		    		HebergeurDAO hebDAO = new HebergeurDAO(this.connection);
		    		h.setHebergeur(hebDAO.find(this.resultSet.getInt(3)));
		    		java.sql.Date d = this.resultSet.getDate(4);
		    		if(d == null)
		    		{
		    			h.setDateClassementH(null);
		    		}
		    		else
		    		{
		    			h.setDateClassementH(d.toLocalDate());
		    		}
		    		d = this.resultSet.getDate(5);
		    		if(d == null)
		    		{
		    			h.setDatePublicationH(null);
		    		}
		    		else
		    		{
		    			h.setDatePublicationH(d.toLocalDate());
		    		}
		    		h.setTypologieH(this.resultSet.getString(6));
		    		h.setClassementH(this.resultSet.getString(7));
		    		h.setTelephoneH(this.resultSet.getString(8));
		    		h.setCourrierH(this.resultSet.getString(9));
		    		h.setSiteInternet(this.resultSet.getString(10));
		    		h.setCapaciteAcceuilH(this.resultSet.getInt(11));
		    		h.setCoordonneesH(this.resultSet.getString(12));
		    		h.setNoteH(this.resultSet.getFloat(13));
		    		h.setDescriptionH(this.resultSet.getString(14));
		    		h.setNomCommercialH(this.resultSet.getString(15));
		    		h.setAdresseH(this.resultSet.getString(16));
		    		h.setCodePostalH(this.resultSet.getInt(17));
		    		h.setCommuneH(this.resultSet.getString(18));

		    	hebergements.add(h);
		      }

		      
		      this.resultSet.close();
		      preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hebergements;

	}
	@Override
	public Hebergement findForUpdate(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
