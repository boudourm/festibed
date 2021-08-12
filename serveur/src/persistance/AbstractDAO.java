package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/*
 */
public abstract class AbstractDAO<T> {

	//Attributes
	protected Connection connection;
	protected String url;
	protected String user;
	protected String password;
	
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;
	protected ResultSetMetaData resultSetMetaData;
	
	//Contructor
	public AbstractDAO(Connection connection) {
		super();
			this.connection = connection;
	}
	  public AbstractDAO(String url, String user, String password) {
			super();
			try
			{
				this.url = url;
				this.user = user;
				this.password = password;
				this.connection = DriverManager.getConnection(url, user, password);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
		}

public abstract T find(Integer id) ;

public abstract  int create(T object) ;

 public abstract boolean update(T object);

 public abstract boolean delete(T object) ;
 
 public abstract List<T> findAll();
 
 public abstract T findForUpdate(Integer id) ;
 

	public void closeConnection() {
		try 
		{
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}