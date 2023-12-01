package com.ren0five.springbootblogrestapi.servicesImpl;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordServiceImpl{

    public static String hashPassword(String plainPassword) {
        String pass = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
        return pass;
    }
    public static boolean checkPassword(String enteredPassword, String storedHashedPassword) {
        return BCrypt.checkpw(enteredPassword,storedHashedPassword);
    }
}
