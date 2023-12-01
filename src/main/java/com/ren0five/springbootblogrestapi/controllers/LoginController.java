package com.ren0five.springbootblogrestapi.controllers;

import com.ren0five.springbootblogrestapi.DTOs.CreateBlogAccountDTO;
import com.ren0five.springbootblogrestapi.DTOs.LoginDTO;
import com.ren0five.springbootblogrestapi.processors.LoginProcessor;
import com.ren0five.springbootblogrestapi.servicesImpl.BlogAccountCreationServiceImpl;
import com.ren0five.springbootblogrestapi.session.LoggedInAccountsSessionManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {

    private final BlogAccountCreationServiceImpl blogAccountCreationServiceImpl;
    private final LoginProcessor loginProcessor;
    private final LoggedInAccountsSessionManagement loggedInAccountsSessionManagement;

    public LoginController(
            BlogAccountCreationServiceImpl blogAccountCreationServiceImpl,
            LoginProcessor loginProcessor,
            LoggedInAccountsSessionManagement loggedInAccountsSessionManagement

    ){
        this.blogAccountCreationServiceImpl = blogAccountCreationServiceImpl;
        this.loginProcessor = loginProcessor;
        this.loggedInAccountsSessionManagement = loggedInAccountsSessionManagement;
    }


    @GetMapping
    public ResponseEntity<String> loginPage(){
        return ResponseEntity.status(200).body("Input your username and password to log-in or sign-up");
    }

    @PostMapping("login")
    public ResponseEntity<String> login(
            @RequestBody LoginDTO loginDTO
            ){
        var result =  loginProcessor.loginValidation(loginDTO.getEmail(), loginDTO.getPassword());
        if(result)
            return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Login Failed :(");
    }

    @GetMapping("logout")
    public ResponseEntity<String> logout(){
        loggedInAccountsSessionManagement.logOutSession();
        return ResponseEntity.status(200).body("Logged out...");
    }

    @GetMapping("signup")
    public ResponseEntity<String> signUpPage(){
        return ResponseEntity.status(200)
                .body("Please input your first name, last name, email, and password");
    }

    @PostMapping("signup")
    public ResponseEntity<String> signUp(
            @RequestBody CreateBlogAccountDTO createBlogAccountDTO
            ){
        String response = this.blogAccountCreationServiceImpl.createAccount(createBlogAccountDTO)?
                "Account creation successful":
                "Account already Exists";
        return ResponseEntity.status(200).body(response);
        }
}


