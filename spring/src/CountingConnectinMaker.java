import java.sql.Connection;
import java.sql.SQLException;


public class CountingConnectinMaker implements ConnectionMaker {
	
	
	int counter = 0;
	private ConnectionMaker realConnectionMaker;
	
	public CountingConnectinMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker = realConnectionMaker;
	}

	@Override
	public Connection makeConnectionr() throws SQLException,ClassNotFoundException {
		
		this.counter++;
		return realConnectionMaker.makeConnectionr();
	}

	public int getCounter(){
		return this.counter;
	}
}
