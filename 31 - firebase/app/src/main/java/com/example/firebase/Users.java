package com.example.firebase;

public class Users {
    String firstname, lastname, userid;
    int age;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Users (){

    }

    public Users (String firstname, String lastname, int age, String userid){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.userid = userid;
    }
}
