package com.bmt.webapp.models;

import jakarta.validation.constraints.NotEmpty;

public class ClientDto {

    @NotEmpty(message = "The ID is required")
    private String id;
    

    @NotEmpty(message = "The Email is required")
    private String email;

    @NotEmpty(message = "The Gender is required")
    private String gender;

    private String phone;

    @NotEmpty(message = "The Name is required")
    private String name;

    @NotEmpty(message = "The Password is required")
    private String password;

    private String role;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
