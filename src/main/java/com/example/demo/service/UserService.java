package com.example.demo.service;

import com.example.demo.model.UserModel;

public interface UserService {

    UserModel findAllByEmail(String email);

    void saveUser(UserModel userModel);
}
