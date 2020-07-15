package com.example.jsonparsing;

public class Product {

    private String imageURL;
    private String thumbnailURL;
    private String name;
    private String description;

    public Product(){}

    public Product(String imageURL, String thumbnailURL, String name, String description) {
        this.imageURL = imageURL;
        this.thumbnailURL = thumbnailURL;
        this.name = name;
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
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
