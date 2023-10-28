package genericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int generateRandoNo(int limit) {
		
		Random random = new Random();
		return random.nextInt(limit);
		
	}
	
	public String generateSystemDateTime() {
		
		Date date=new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
					
	}
	
	
	
	
	

}
