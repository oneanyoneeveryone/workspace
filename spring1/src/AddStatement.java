import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddStatement implements StatementStrategy {
	
	User user;
	
	public AddStatement(User user){
		this.user=user;
	}
	
	public AddStatement(){
	}

	@Override
	public PreparedStatement makeStatement(Connection c) throws SQLException {
		PreparedStatement ps = c.prepareStatement("insert into users(id,name)values(?,?)");
		
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.executeUpdate();
		
		ps.close();
		c.close();
		return ps;
	}

}
