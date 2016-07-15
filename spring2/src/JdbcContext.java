import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;


public class JdbcContext {

	private DataSource datasource;
	
	public void setDataSource(DataSource dataSource) {
		this.datasource = dataSource;
	}
	
	public void wokrWithStatementStrategy(StatementStrategy stmt){
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = datasource.getConnection();
			ps = stmt.makeStatement(c);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
