package com.list;

import javax.json.bind.annotation.JsonbProperty;


public class Activity{
    @JsonbProperty("Activity name")
    private String name;
    public Activity(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Activity Name: " + name + "\n";
    }
}
