import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public  class UserDao {
	
	
	
	private ConnectionMaker connectionMaker;
	
	public void setConnectionMaker(ConnectionMaker connectionMaker){
		this.connectionMaker = connectionMaker;
	}
	
	
//	public UserDao(ConnectionMaker connectionMaker){
//		this.connectionMaker = connectionMaker;
//	}
	
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnectionr();
		
		
		PreparedStatement ps = c.prepareStatement("insert into users(id,name)values(?,?)");
		
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
		
	}
	
	public User get(String id) throws SQLException, ClassNotFoundException{
		
		Connection c = connectionMaker.makeConnectionr();
		
		
		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		User user = new User();
		while(rs.next()){
			user.setId(rs.getString("id"));
			user.setName(rs.getNString("name"));
		}
		
		
		rs.close();
		c.close();
		
		return user;
		
	}
	

}
