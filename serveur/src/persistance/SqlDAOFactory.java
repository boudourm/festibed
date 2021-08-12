package persistance;

import java.sql.Connection;
import java.util.ArrayList;

/*
 */
public class SqlDAOFactory  implements DAOAbstractFactory {

	//attributes
  private Connection connection;
  public static ArrayList<AbstractDAO<?>> fakeDB ;
  static
  {
	  fakeDB = new ArrayList<AbstractDAO<?>>();

  }
  private static SqlDAOFactory instance;

  private void SqlDAOFactory(Connection connection) {
  }

  public static SqlDAOFactory getInstance() {
      if (instance == null)
    	  instance = new SqlDAOFactory();
      return instance;
  }

@Override
public AbstractDAO<?> createHebergementDAO(Connection Connection) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public AbstractDAO<?> createLOgementDAO(Connection Connection) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public AbstractDAO<?> createFestivalDAO(Connection Connection) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public AbstractDAO<?> createUtilisateurDAO(Connection Connection) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public AbstractDAO<?> createReservationDAO(Connection Connection) {
	// TODO Auto-generated method stub
	return null;
}

}