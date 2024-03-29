package com.sadhin.ebanking.dto;

public class UserDetail {
    private int userId;
    private String email;
    private String password;
    private String name;
    private String phone;
    public UserDetail(){
    }

    public UserDetail(int userId, String email, String password, String name, String phone) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
