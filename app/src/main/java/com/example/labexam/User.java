package com.example.labexam;

public class User {
    private int id;
    private String name;
    private String gender;
    private String password;
    private String location;

    public User(int id, String name, String gender, String password, String location) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.location = location;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getPassword() { return password; }
    public String getLocation() { return location; }
}