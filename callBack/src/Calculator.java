import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Calculator {
	
	public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException{
		BufferedReader br = null;
		
		try{
		br = new BufferedReader(new FileReader(filepath));
		
		int ret = callback.doSomethingWithReader(br);
		
		return ret;
		}catch(IOException e){
			System.out.print(e.getMessage());
			throw e;
		}finally{
			if(br!=null){
				br.close();
			}
		}
	}

}
