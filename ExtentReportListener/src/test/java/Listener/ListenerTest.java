package Listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import TestLoad.load;


	public class ListenerTest extends load implements ITestListener  {
		public void onTestStart(ITestResult result) {  
		extentTest=extent.startTest(result.getName());
			} 
			  
		 
			public void onTestSuccess(ITestResult result) {  
			if(result.getStatus()==ITestResult.SUCCESS)
				{
					extentTest.log(LogStatus.PASS, "Testcase passed is "+ result.getName());
				}
			}  
		 
			public void onTestFailure(ITestResult result) {  
				
				if(result.getStatus()==ITestResult.FAILURE) {
					extentTest.log(LogStatus.FAIL,"Testcase failed is "+ result.getName());
					extentTest.log(LogStatus.FAIL, "Testcase failed is "+ result.getThrowable());
				}
			}
			  
		 
			public void onTestSkipped(ITestResult result) {  
			if(result.getStatus()==ITestResult.SKIP)
				{
					extentTest.log(LogStatus.SKIP, "Testcase skipped is "+ result.getName());
					
				}
			}
		  
}
