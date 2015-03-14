
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconn {
	Connection con = null;

	public Connection getLocalConnection() {
		try {

			DAOProperties daoProperty = new DAOProperties(null);
			String driver = daoProperty.getDriver();
			String url = daoProperty.getUrl();
			String passwd = daoProperty.getPasswd();
			String username = daoProperty.getUsername();
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, passwd);
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException in getConnection, "
					+ e.getMessage());
		} catch (SQLException e) {
			System.err.println("SQLException in getConnection, "
					+ e.getMessage());
		}
		return con;
	}

	public void setConnectionClose() throws SQLException {
		con.close();
	}
}
