package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpementationClass implements IRetryAnalyzer {

	int limit = 2;
	int count = 0;
	
	public boolean retry(ITestResult result) {

		while(limit>count) {
			count++;
			return true;
		}
		
		
		return false;
	}
	
	

}
