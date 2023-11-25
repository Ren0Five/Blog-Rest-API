package com.ren0five.springbootblogrestapi.processors;

import com.ren0five.springbootblogrestapi.models.BlogAccount;
import com.ren0five.springbootblogrestapi.repositories.BlogAccountRepository;
import com.ren0five.springbootblogrestapi.session.LoggedInAccountsSessionManagement;
import com.ren0five.springbootblogrestapi.services.PasswordService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedInAccountsSessionManagement loggedInAccountsSessionManagement;
    private final BlogAccountRepository blogAccountRepository;

    public LoginProcessor(
            LoggedInAccountsSessionManagement loggedInAccountsSessionManagement,
            BlogAccountRepository blogAccountRepository
    ){
        this.loggedInAccountsSessionManagement = loggedInAccountsSessionManagement;
        this.blogAccountRepository = blogAccountRepository;
    }

    public boolean loginValidation(String email, String password){
        boolean isValid = false;
       List<BlogAccount> blogAccount = blogAccountRepository.getBlogAccountByEmail(email);
       if(blogAccount.isEmpty())
           return isValid;
        if(blogAccount.get(0).getEmail().equals(email) &&
                PasswordService.checkPassword(password, blogAccount.get(0).getPassword())) {
            System.out.println(blogAccount.get(0) + "logged in!");
            isValid = true;
            setSessionAccount(blogAccount.get(0));
        }

        return isValid;
    }

    public void setSessionAccount(BlogAccount blg){
        loggedInAccountsSessionManagement.setFirstName(blg.getFirstName());
        loggedInAccountsSessionManagement.setLastName(blg.getLastName());
        loggedInAccountsSessionManagement.setEmail(blg.getEmail());
    }

}


