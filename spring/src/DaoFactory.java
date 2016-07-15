import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;




@Configuration
public class DaoFactory {
	
	@Bean
	public UserDao userDao() throws ClassNotFoundException {
		UserDao userDao=new UserDao() ;
		userDao.setDataSource(datasource());
		return userDao;
	}
	
	@Bean
	public DataSource datasource() throws ClassNotFoundException {
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass((Class<Driver>)Class.forName("oracle.jdbc.driver.OracleDriver"));
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
		dataSource.setUsername("ji");
		dataSource.setPassword("ji123");
		
		return dataSource;
	}
	
	

}
