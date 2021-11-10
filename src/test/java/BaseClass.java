import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseClass {

    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "http://rest-api.upskills.in/api/rest_admin/";
    }
}