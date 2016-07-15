import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public   class UserDao {
	
	private JdbcContext jdbcContext;
	
	public void setJdbcContext(JdbcContext jdbcContext) {
		this.jdbcContext = jdbcContext;
	}
	
	
	public void deleteAll() throws SQLException {
		this.jdbcContext.wokrWithStatementStrategy(
				new StatementStrategy(){
					public PreparedStatement makeStatement(Connection c) throws SQLException{
						return c.prepareStatement("delete from users");
					}
			
				}
		);
	}
	
	public void add(final User user) throws SQLException {
		this.jdbcContext.wokrWithStatementStrategy(
				new StatementStrategy(){
					public PreparedStatement makeStatement(Connection c) throws SQLException{
						PreparedStatement ps = c.prepareStatement("insert into users(id,name)values(?,?)");
						
						ps.setString(1, user.getId());
						ps.setString(2, user.getName());
						
						return c.prepareStatement("delete from users");
					}
			
				}
		);
	}
	
}
