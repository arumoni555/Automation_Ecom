import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.PayloadIssue;
import pojo.productDescription;

import java.util.List;

public class CreateIssue {
    public static void main(String[] args) throws JsonProcessingException {
        productDescription type = new productDescription("Lenovo IdeaPad S200","Lenovo IdeaPad S200");
        PayloadIssue payload = new PayloadIssue("Lenovo Ideapad Laptop","1000","54000.00", (List<productDescription>) type);

        ObjectMapper mapper = new ObjectMapper();
        String p = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);
        System.out.println(p);
    }
}
