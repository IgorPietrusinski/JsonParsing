package com.example.jsonparsing;

public class Product {

    private String imageURL;
    private String name;
    private String description;

    public Product(){}

    public Product(String imageURL, String name, String description) {
        this.imageURL = imageURL;
        this.name = name;
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
