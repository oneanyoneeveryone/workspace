import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JTest {

	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException {
		
		ApplicationContext context=new GenericXmlApplicationContext("applicationContext.xml");
		UserDao userDao = context.getBean("userDao",UserDao.class);
		
		userDao.deleteAll();
		assertThat(userDao.getCount(),is(0));
		
		User user1 = new User("1","1");
		User user2 = new User("2","2");
		
		userDao.deleteAll();
		assertThat(userDao.getCount(),is(0));
		userDao.add(user1);
		userDao.add(user2);
		assertThat(userDao.getCount(),is(2));
		
		
		User userget1 = userDao.get(user1.getId());
		assertThat(userget1.getId(),is(user1.getId()));
		assertThat(userget1.getName(),is(user1.getName()));
		
		User userget2 = userDao.get(user2.getId());
		assertThat(userget2.getId(),is(user2.getId()));
		assertThat(userget2.getName(),is(user2.getName()));
		
	}
	
	public static void main(String[] args) {
		JUnitCore.main("JTest");

	}

}
