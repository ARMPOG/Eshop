package com.example.demo.security;


import com.example.demo.model.UserModel;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private UserModel user;

    public CurrentUser(UserModel user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getType().name()));
        this.user=user;
    }

    public UserModel getUser() {
        return user;
    }

    public int getId(){
        return user.getId();
    }
}
