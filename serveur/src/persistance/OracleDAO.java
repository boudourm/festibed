package persistance;

import java.sql.Connection;

/*
 */
public abstract class OracleDAO<T> extends AbstractDAO<T> {

	
	public OracleDAO(Connection connection) {
		super(connection);
}
	public OracleDAO(String url, String user, String password) {
		super(url, user, password);
		// TODO Auto-generated constructor stub
	}
	
}