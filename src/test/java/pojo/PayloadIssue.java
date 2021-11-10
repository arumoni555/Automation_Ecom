package pojo;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class PayloadIssue {

    private String model;
    private String quantity;
    private String price;
    private List<pojo.productDescription> productDescription = null;

    public PayloadIssue() {
    }


    public PayloadIssue(String model, String quantity, String price, List<pojo.productDescription> productDescription) {
        super();
        this.model = model;
        this.quantity = quantity;
        this.price = price;
        this.productDescription = productDescription;
    }

    public PayloadIssue(String model, String quantity, String price, Comparable<String> productDescription) {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<pojo.productDescription> getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(List<pojo.productDescription> productDescription) {
        this.productDescription = productDescription;
    }

}
