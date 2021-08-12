package persistance;

import java.sql.Connection;

/*
 * 
 */
public interface DAOAbstractFactory {

  public AbstractDAO<?> createHebergementDAO(Connection Connection);

  public AbstractDAO<?> createLOgementDAO(Connection Connection);

  public AbstractDAO<?> createFestivalDAO(Connection Connection);

  public AbstractDAO<?> createUtilisateurDAO(Connection Connection);
  
  public AbstractDAO<?> createReservationDAO(Connection Connection);

}