package pojo;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class productDescription {

    private String name;
    private String metaTitle;

    public productDescription() {
    }

    public productDescription(String name, String metaTitle) {
        super();
        this.name = name;
        this.metaTitle = metaTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

}