package com.example.chirag.navigationdrawer.model;

public class ShopListModel {


    private String title;
    public ShopListModel(String title) {
        this.title = title;

    }

    public String setTitle(String title)
    {
        return  this.title=title;
    }

    public String getTitle() { return title; }

}
