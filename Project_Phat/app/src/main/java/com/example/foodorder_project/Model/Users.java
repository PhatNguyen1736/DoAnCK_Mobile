package com.example.foodorder_project.Model;

public class Users {
    private int uid;
    private String DOD;
    private String email;
    private String fullname;
    private String gender;
    private String locationID;
    private String password;
    private int phone;

    public Users() {
    }

    public Users(int uid, String DOD, String email, String fullname, String gender, String locationID, String password, int phone) {
        this.uid = uid;
        this.DOD = DOD;
        this.email = email;
        this.fullname = fullname;
        this.gender = gender;
        this.locationID = locationID;
        this.password = password;
        this.phone = phone;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDOD() {
        return DOD;
    }

    public void setDOD(String DOD) {
        this.DOD = DOD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
