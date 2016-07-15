import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class UserDaoConnectionCountingTest {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao dao = context.getBean("userDao",UserDao.class);

		CountingConnectinMaker ccm = context.getBean("connectionMaker",CountingConnectinMaker.class);
		
		
		
		
		User user = new User();
		user.setId("1");
		user.setName("hkk");
		
		dao.add(user);
		
		dao.add(user);
		
		dao.add(user);
		
		
		
		
		
		System.out.println(ccm.getCounter());
	}

	
	
	
	
}
