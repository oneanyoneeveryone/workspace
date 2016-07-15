import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DconnectionMaker implements ConnectionMaker {

	@Override
	public Connection makeConnectionr() throws SQLException,ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","ji","ji123");
		return c;
	}

}
