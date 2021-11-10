import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.PayloadIssue;
import pojo.productDescription;

import java.util.List;


public class TestScenarios extends BaseClass {


    //get Access Token
    @Test
    public void Get_AccessToken() {

        RequestSpecification request = RestAssured.given()
                .header("Authorization", "Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=")
                .queryParam("grant_type", "client_credentials")
                .header("Content-Type", "application/json");
        Response response = request.post("/oauth2/token/client_credentials");

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is not matching");

        String jsonString = response.getBody().asString();
        JsonPath jp = new JsonPath(jsonString);
        String tokenGenerated = jp.getString("access_token");
        System.out.println("token is " + tokenGenerated);
    }

    @Test
    public void AdminUserOperations() {
        //Admin user login into the system
        String Payload = "{\n" +
                "  \"username\": \"upskills_admin\",\n" +
                "  \"password\": \"Talent4$$\"\n" +
                "}";
        Response response1 = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer" + "tokenGenerated").body(Payload)
                .post("/login");

        JsonPath jp1 = new JsonPath(response1.getBody().asString());
        String User_name1 = jp1.getString("username");

        response1.prettyPrint();

        Assert.assertEquals(response1.getStatusCode(), 200, "Expected status code is not matching");
        Assert.assertEquals(User_name1, "upskills_admin", "Username is not matching");

        //get Admin user account details
        Response response2 = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer" + "tokenGenerated").get("/user");

        JsonPath jp2 = new JsonPath(response2.getBody().asString());
        String User_name2 = jp2.getString("username");

        response2.prettyPrint();

        Assert.assertEquals(response2.getStatusCode(), 200, "Expected status code is not matching");
        Assert.assertEquals(User_name2, "upskills_admin", "Username is not matching");

        //loging out of logged in Admin user system
        Response response3 = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer" + "tokenGenerated").post("/logout");

        response3.prettyPrint();

        Assert.assertEquals(response3.getStatusCode(), 200, "Expected status code is not matching");
    }


    @Test
    public void BulkProducts() throws JsonProcessingException {

        productDescription payload = new productDescription("DELL","DELL 3000");
        PayloadIssue payload1 = new PayloadIssue("Inspiron 3511","2000","47,900","payload");

        ObjectMapper mapper = new ObjectMapper();
        String p = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload1);
        System.out.println(p);
//
        Response responsePost = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization","Bearer"+"tokenGenerated").body(payload1)
                .when().post("/bulk_products");

        responsePost.prettyPrint();

        Assert.assertEquals(responsePost.getStatusCode(),200,"Expected status code is not matching");

        Response responseGet = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization","Bearer"+"tokenGenerated").pathParam("product_id","58")
                .when().get("{product_id}");

        JsonPath jp = new JsonPath(responseGet.getBody().asString());
        int id = jp.getInt("id");
        responseGet.prettyPrint();
        Assert.assertEquals(responseGet.getStatusCode(),200,"Expected status code is not matching");
        Assert.assertEquals(id,"58","Expected product_id is not matching");
    }

    @Test
    public void getAllProducts(){

        Response responseGetAll = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization","Bearer"+"tokenGenerated")
                .when().get("/products");

        responseGetAll.prettyPrint();

        Assert.assertEquals(responseGetAll.getStatusCode(),200,"Expected status code is not matching");
    }
}

