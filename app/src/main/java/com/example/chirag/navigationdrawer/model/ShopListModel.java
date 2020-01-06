package com.example.chirag.navigationdrawer.model;

public class ShopListModel {


    private String title, image;
    public ShopListModel(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String setTitle(String title)
    {
        return  this.title=title;
    }

    public String getTitle() { return title; }

    public String setImage(String image) { return this.image=image; }

    public String getImage() { return image; }
}
