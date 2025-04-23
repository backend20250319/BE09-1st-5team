package com.pizza.pizzahut.user.signup.dto;


public class UserDTO {
    private String id;
    private String password;
    private String name;

    public UserDTO(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    // Getter & Setter
    public String getId() { return id; }
    public String getPassword() { return password; }
    public String getName() { return name; }

    public void setPassword(String password) {
        this.password = password;
    }
}
