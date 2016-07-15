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
		
		User user1 = new User();
		user1.setId("1");
		user1.setName("hkk");
		
		userDao.add(user1);
		
		
		
		System.out.println(user1.getId());
		System.out.println(user1.getName());
		
		
		
		User user2 =userDao.get(user1.getId());
		System.out.println(user2.getId());
		System.out.println(user2.getName());
		
		
		if(!user1.getId().equals(user2.getId())){
			System.out.println("실패");
		}else if(!user1.getName().equals(user2.getName())){
			System.out.println("실패");
		}else{
			System.out.println("성공");
		}
		
		
		
	}

}
