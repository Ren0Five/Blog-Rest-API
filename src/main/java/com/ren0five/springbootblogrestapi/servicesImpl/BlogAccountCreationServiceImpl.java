package com.ren0five.springbootblogrestapi.servicesImpl;

import com.ren0five.springbootblogrestapi.DTOs.CreateBlogAccountDTO;
import com.ren0five.springbootblogrestapi.repositories.BlogAccountRepository;
import com.ren0five.springbootblogrestapi.servicesImpl.servicesInterfaces.BlogAccountCreationService;
import org.springframework.stereotype.Service;

@Service
public class BlogAccountCreationServiceImpl implements BlogAccountCreationService {

    private final BlogAccountRepository blogAccountRepository;
    public BlogAccountCreationServiceImpl(BlogAccountRepository blogAccountRepository){
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
                PasswordServiceImpl.hashPassword(createBlogAccountDTO.getPassword()));

        return true;
    }
}
