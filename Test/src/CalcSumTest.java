import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;


public class CalcSumTest {

	@Test
	public void sumOFNumbers() throws IOException {
		Calculator calculator = new Calculator();
		
		int sum = calculator.calcSum(getClass().getResource("numbers.txt").getPath());
		
		assertThat(sum,is(10));
		
		
		
		
	}
	
	
	

}
