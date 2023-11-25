package com.ren0five.springbootblogrestapi.repositories;

import com.ren0five.springbootblogrestapi.models.BlogAccount;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogAccountRepository extends CrudRepository<BlogAccount, Long> {


    @Modifying
    @Query("INSERT INTO BlogAccounts (firstName, lastName, email, password) VALUES (:firstName, :lastName, :email, :password)")
    void createBlogAccount(String firstName, String lastName, String email, String password);

    @Query("SELECT * FROM BlogAccounts WHERE email = :email")
    List<BlogAccount> getBlogAccountByEmail(String email);


    @Query("SELECT COUNT(*) FROM BlogAccounts WHERE email = :value")
    int countEmail(String value);
}
