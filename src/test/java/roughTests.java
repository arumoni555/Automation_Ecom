import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class roughTests {

    @Test
    public void postProducts() {
        String payload = "[\n" +
                "{\n" +
                "\"model\": \"Lenovo Laptop\",\n" +
                "\"quantity\": \"100\",\n" +
                "\"price\": \"67000.00\",\n" +
                "\"product_description\": [\n" +
                "{\n" +
                "\"name\": \"Lenovo S200\",\n" +
                "\"meta_title\": \"Lenovo IdeaPad S200\"\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"model\": \"HP Laptop\",\n" +
                "\"quantity\": \"500\",\n" +
                "\"price\": \"78000.00\",\n" +
                "\"product_description\": [\n" +
                "{\n" +
                "\"name\": \"HP S300\",\n" +
                "\"meta_title\": \"HP note S300\"\n" +
                "}\n" +
                "]\n" +
                "}\n" +
                "]";
        Response responsePost = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization","Bearer"+"tokenGenerated").body(payload)
                .when().post("http://rest-api.upskills.in/api/rest_admin/bulk_products/");

        responsePost.prettyPrint();
        //System.out.println(responsePost.getBody().asString()); can print like this too.
        Assert.assertEquals(responsePost.getStatusCode(),200,"Expected status code is not matching");

        Response responsePost1 = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization","Bearer"+"tokenGenerated").body(payload)
                .when().post("http://rest-api.upskills.in/api/rest_admin/bulk_products/58");

        JsonPath jp = new JsonPath(responsePost1.getBody().asString());
        int id = jp.getInt("id");
        responsePost1.prettyPrint();
        Assert.assertEquals(responsePost1.getStatusCode(),200,"Expected status code is not matching");
        Assert.assertEquals(id,"58","Expected product_id is not matching");
    }

    @Test
    public void getAllProducts(){
        //----------------------------------------get all------------------------------------------------
        Response responseGetAll = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization","Bearer"+"tokenGenerated")
                .when().get("http://rest-api.upskills.in/api/rest_admin/products");

        responseGetAll.prettyPrint();
        //System.out.println(responseGetAll.getBody().asString());
        }
}
