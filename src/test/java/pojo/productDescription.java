package pojo;

public class productDescription {
    private String name;
    private String meta_title;

    public productDescription(String name, String meta_title) {
        this.name = name;
        this.meta_title = meta_title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeta_title() {
        return meta_title;
    }

    public void setMeta_title(String meta_title) {
        this.meta_title = meta_title;
    }
}

//[
//        {
//        "model": "Lenovo Ideapad Laptop",
//        "quantity": "1000",
//        "price": "54000.00",
//        "product_description": [
//        {
//        "name": "Lenovo IdeaPad S200",
//        "meta_title": "Lenovo IdeaPad S200"
//        }
//        ]
//        },
//
//
//
//        {
//        "model": "Lenovo Ideapad Laptop",
//        "quantity": "1000",
//        "price": "64000.00",
//        "product_description": [
//        {
//        "name": "Lenovo IdeaPad S300",
//        "meta_title": "Lenovo IdeaPad S300"
//        }
//        ]
//        }
//        ]
