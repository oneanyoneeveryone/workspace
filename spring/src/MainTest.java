import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainTest {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		ApplicationContext context=new GenericXmlApplicationContext("applicationContext.xml");
		
		
		UserDao userDao = new DaoFactory().userDao();
		
		User user = new User();
		user.setId("1");
		user.setName("hkk");
		
		userDao.add(user);
		
		UserDao userDao2 = new DaoFactory().userDao();
		userDao2.get(user.getId());
		
		
	}

}
