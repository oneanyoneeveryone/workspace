import java.sql.SQLException;

import org.junit.Test;
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
		UserDao userDao = context.getBean("userDao",UserDao.class);
		
//		UserDao userDao = new DaoFactory().userDao();
		
		
		
		userDao.deleteAll();
		User user1 = new User();
		user1.setId("1");
		user1.setName("hkk");
		
		userDao.add(user1);
		
		
		
		System.out.println(user1.getId());
		System.out.println(user1.getName());
		
		
		
		
	}

}
