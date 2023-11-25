package com.ren0five.springbootblogrestapi.session;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoggedInAccountsSessionManagement {

    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void logOutSession(){
        this.setFirstName(null);
        this.setLastName(null);
        this.setEmail(null);
    }

    public boolean isLoggedIn(){
        boolean isLoggedIn = (this.email != null && this.firstName != null) ? true : false;
        return isLoggedIn;
    }

}
