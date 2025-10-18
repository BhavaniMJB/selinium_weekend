package ExtendReport;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReports {
	@Test 
	public void createReport() {
		 String time = LocalDateTime.now().toString().replace(":", "-");
	// step1: create ExtentSparkReporter object
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_Reports/ExtentReports_"+time+".html");
	
	//step2: create ExtentReports object
	ExtentReports ereport=new ExtentReports();
	
	//step3: attach ExtentSparkReporter to ExtentReports 
	 ereport.attachReporter(spark);
	 
	 //step4: create ExtentTest object
	 ExtentTest test= ereport.createTest("createReport");
	 
	 //step5: call log(status, message)
	  test.log(Status.PASS,"message added in report");
      test.log(Status.INFO, "message added");
      
	  //step6: call flush()
	  ereport.flush();
	  
}	

}
