package com.list;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "activity_db")
public class Activity extends PanacheEntity {

    @JsonbProperty("Activity_name")
    @Column
    public String Activity_name;

    public Activity(){}

    public Activity(String activityName) {
        this.Activity_name = activityName;
    }

    @Override
    public String toString(){
        return "Activity Name: " + Activity_name + "\n";
    }
}
