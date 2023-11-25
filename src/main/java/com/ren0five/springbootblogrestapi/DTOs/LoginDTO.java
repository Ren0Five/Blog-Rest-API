package com.ren0five.springbootblogrestapi.DTOs;

import org.springframework.data.relational.core.mapping.Column;

public class LoginDTO {

    @Column("email")
    private String email;
    @Column("password")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
