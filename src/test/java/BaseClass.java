import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseClass {
//    public ExtentReports report;
//    public ExtentTest log;

//    @BeforeSuite
//    public void setUpSuite(){
//        ExtentHtmlReporter extent = new ExtentHtmlReporter("C:\\Users\\user\\eclipse-workspace\\APIAutomation\\Reports\\reports.html");
//        report = new ExtentReports();
//        report.attachReporter(extent);
//    }

    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "http://rest-api.upskills.in/api/rest_admin/";
//        RestAssured.authentication = RestAssured.preemptive().basic( "upskills_admin","Talent4$$");

    }

//    @AfterMethod
//    public void tearDownMethod(){
//        report.flush();
//    }
//    @BeforeClass
//    public void login(){
//        RestAssured.authentication = RestAssured.preemptive().basic( "upskills_admin","Talent4$$");
//    }


}