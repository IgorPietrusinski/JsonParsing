package com.example.jsonparsing;

import java.util.Iterator;

public class Product {

    private String imageURL;
    private String name;
    private String description;
   // private boolean isSelected = false;

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

/*    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public boolean isSelected(){
        return isSelected;
    }*/
}
