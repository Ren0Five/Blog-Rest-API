package com.ren0five.springbootblogrestapi.servicesImpl.servicesInterfaces;

import com.ren0five.springbootblogrestapi.DTOs.CreateBlogAccountDTO;

public interface BlogAccountCreationService {
    public boolean createAccount(CreateBlogAccountDTO createBlogAccountDTO);
}
