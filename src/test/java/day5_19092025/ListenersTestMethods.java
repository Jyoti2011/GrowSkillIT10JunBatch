package day5_19092025;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTestMethods implements ITestListener{
	
	public void onTestStart(ITestResult result) {
	   System.out.println("Now the test Method Execution Statrted: "+result.getName());
	  }

	 
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test Method is Passed: "+result.getName());
	  }

	  
	public void onTestFailure(ITestResult result) {
		 System.out.println("Test Method is Failed: "+result.getName());
	  }

	  
	public void onTestSkipped(ITestResult result) {
		 System.out.println("Test Method is Skipped: "+result.getName());
	  }

	  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  
	public void onStart(ITestContext context) {
		 System.out.println("Now Execution Started");
	  }

	public void onFinish(ITestContext context) {
	   System.out.println("The Execution Completed");
	  }

}
