package pojo;

public class PayloadIssue {
    private String model;
    private String quantity;
    private String price;
    private productDescription product_description;

    public PayloadIssue(String model, String quantity, String price, productDescription product_description) {
        this.model = model;
        this.quantity = quantity;
        this.price = price;
        this.product_description = product_description;
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

    public productDescription getProduct_description() {
        return product_description;
    }

    public void setProduct_description(productDescription product_description) {
        this.product_description = product_description;
    }
}
