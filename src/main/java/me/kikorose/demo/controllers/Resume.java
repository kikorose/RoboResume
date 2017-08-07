package me.kikorose.demo.controllers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
@Entity
Index index;



public class Index {
@NotNull
    private String name;

@NotNull
    private String email;

@NotNull
    private String organization;

@Null
    private String startDate;

@Null
    private String enddate;


    public String getName() {
        return name;
    }
   public  String getEmail(){
    return email;
}
    public String getOrganization(){
    return organization;
    }
    public String getStartDate(){
        return startDate;
    }
    public String getEnddate(){
        return enddate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public void set(String Name, String email, String organization, String startDate, String enddate){
        setName(name);
        setEmail(email);
        setOrganization(organization);
        setStartDate(startDate);
        setEnddate(enddate);
    }
}
