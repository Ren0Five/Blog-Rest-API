package com.ren0five.springbootblogrestapi.services;

import com.ren0five.springbootblogrestapi.DTOs.CreateBlogAccountDTO;
import com.ren0five.springbootblogrestapi.repositories.BlogAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class BlogAccountCreationService {

    private final BlogAccountRepository blogAccountRepository;
    public BlogAccountCreationService(BlogAccountRepository blogAccountRepository){
        this.blogAccountRepository = blogAccountRepository;
    }

    public boolean createAccount(CreateBlogAccountDTO createBlogAccountDTO){

        if(blogAccountRepository.countEmail(createBlogAccountDTO.getEmail()) > 0){
            return false;
        }

        blogAccountRepository.createBlogAccount(
                createBlogAccountDTO.getFirstName(),
                createBlogAccountDTO.getLastName(),
                createBlogAccountDTO.getEmail(),
                PasswordService.hashPassword(createBlogAccountDTO.getPassword()));

        return true;
    }
}
