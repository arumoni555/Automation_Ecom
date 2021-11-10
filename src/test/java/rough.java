import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class rough {
    @Test
    public static void main(String[] args){
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
        Response responsePost = RestAssured.given().header("Content-Type", "application/json").body(payload)
                .when().post("http://rest-api.upskills.in/api/rest_admin/bulk_products");

        responsePost.prettyPrint();
        //System.out.println(responsePost.getBody().asString()); can print like this too.

        //----------------------------------------get all------------------------------------------------
        Response responseGetAll = RestAssured.given()
                .when().get("http://rest-api.upskills.in/api/rest_admin/products");

        responseGetAll.prettyPrint();
        //System.out.println(responseGetAll.getBody().asString());



    }
}
