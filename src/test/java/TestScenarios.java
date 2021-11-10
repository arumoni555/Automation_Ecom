import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.PayloadIssue;


public class TestScenarios extends BaseClass {

    static String access_token;

    //get Access Token
    @Test
    public void Get_AccessToken() {

        RequestSpecification request = RestAssured.given()
                .header("Authorization", "Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=")
                .queryParam("grant_type", "client_credentials")
                .header("Content-Type", "application/json");
        Response response = request.post("/oauth2/token/client_credentials");
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200,"Expected status code is not matching");

//        access_token = response.getBody().path("access_token");
//        System.out.println("the access token is " + access_token);

//        JsonPath jp = new JsonPath(response.getBody().asString());
//        String data = jp.getString("data");
//        request.header("Content-Type", "application/json");
//        System.out.println("data is " +data);


//        String jsonString = response.getBody().asString();
//        String tokenGenerated = JsonPath.from(jsonString).get("token");
//        request.header("Authorization","Bearer "+tokenGenerated)
//                .header("Content-Type", "application/json");
//        System.out.println("----------token-----------" +tokenGenerated);

//        String jsonString = response.getBody().asString();
//        JsonPath jp = new JsonPath(jsonString);
//        String tokenGenerated = jp.getString("access_token");
//        System.out.println("token is " +tokenGenerated);

    }

//    @Test
//    public void Login() {
//        String url = "/login";
//        String Payload = "{\n" +
//                "  \"username\": \"upskills_admin\",\n" +
//                "  \"password\": \"Talent4$$\"\n" +
//                "}";
//        RequestSpecification request = RestAssured.given().header("Content-Type", "application/json");
//        Response response = request.body(Payload).post("/login");
//        int status_code = response.getStatusCode();
//        String response_body = response.asString();
//        System.out.println("----------status code-----------" + status_code);
//        System.out.println("----------response body-----------" + response_body);
//    }
//    @Test
//    public void Login() {
//        String url = "/login";
//        RequestSpecification request = RestAssured.given();
//        request.header("Content-Type", "application/json");
//
//        Response response = request.post("/login");
//        int status_code = response.getStatusCode();
//        String response_body = response.asString();
//        System.out.println("----------status code-----------" + status_code);
//        System.out.println("----------response body-----------" + response_body);
//    }

//    {"success":1,
//            "error":[],
//        "data":{"access_token":"cc8cf4d1b789c0d9a187918766596acef9adb6db",
//            "expires_in":86400,"token_type":"Bearer"}
//    }
    @Test
    public void login(){

        String Payload = "{\n" +
                "  \"username\": \"upskills_admin\",\n" +
                "  \"password\": \"Talent4$$\"\n" +
                "}";
        Response response1 = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer"+"tokenGenerated").body(Payload)
                .post("/login");

        JsonPath jp = new JsonPath(response1.getBody().asString());
        String User_name = jp.getString("username");
        response1.prettyPrint();
        Assert.assertEquals(response1.getStatusCode(),200,"Expected status code is not matching");
        Assert.assertEquals(User_name,"upskills_admin","Username is not matching");

        //get
        Response response2 = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer"+"tokenGenerated").get("/user");
        JsonPath jp2 = new JsonPath(response1.getBody().asString());
        String User_name2 = jp.getString("username");
        response1.prettyPrint();
        Assert.assertEquals(response2.getStatusCode(),200,"Expected status code is not matching");
        Assert.assertEquals(User_name2,"upskills_admin","Username is not matching");





    }
}

