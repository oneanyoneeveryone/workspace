import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountingDaoFactory {
	
	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
		
	}
	@Bean
	public ConnectionMaker connectionMaker(){
		return new CountingConnectinMaker(realConnectionMaker());
	}
	
	@Bean
	public ConnectionMaker realConnectionMaker(){
		return new DconnectionMaker();
	}

}
