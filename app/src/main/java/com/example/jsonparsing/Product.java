package com.example.jsonparsing;

import java.util.Iterator;

public class Product {

    private String imageURL;
    private String name;
    private String description;

    //public Product(){}

    public Product(String name, String description, String imageURL) {
        this.imageURL = imageURL;
        this.name = name;
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

}
