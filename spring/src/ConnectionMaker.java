import java.sql.Connection;
import java.sql.SQLException;


public interface ConnectionMaker {
	public Connection makeConnectionr() throws SQLException, ClassNotFoundException;

}
