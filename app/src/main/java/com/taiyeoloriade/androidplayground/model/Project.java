package com.taiyeoloriade.androidplayground.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project {

@SerializedName("title")
@Expose
private String title;
@SerializedName("description")
@Expose
private String description;
@SerializedName("ranking")
@Expose
private Integer ranking;
@SerializedName("date")
@Expose
private String date;

    public Project(String title,String description,int ranking)
    {
        this.title = title;
        this.description = description;
        this.ranking = ranking;



    }

    public Project(String title,String description,int ranking,String date)
    {
        this.title = title;
        this.description = description;
        this.ranking = ranking;
        this.date = date;


    }


public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Integer getRanking() {
return ranking;
}

public void setRanking(Integer ranking) {
this.ranking = ranking;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

}