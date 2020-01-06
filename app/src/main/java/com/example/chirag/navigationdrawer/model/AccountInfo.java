package com.example.chirag.navigationdrawer.model;

public class AccountInfo {

    private String matter, details;
    public AccountInfo(String matter, String details) {
        this.matter = matter;
        this.details = details;
    }

    public String setMatter(String mattter)
    {
        return  this.matter=matter;
    }

    public String getMatter()
    {

        return matter;

    }

    public String getDetails()
    {
        return this.details=details;
    }

    public String setDetails(String Details)
    {

        return Details;
    }

}
