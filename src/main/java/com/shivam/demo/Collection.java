package com.shivam.demo;

public class Collection {
    

    private String title;
    private String[] items;


    public Collection(String title, String[] items) {
        this.title = title;
        this.items = items;
    }

    public String getTitle(){
        return title;
    }

    public String[] getItems(){
        return items;
    }
}
