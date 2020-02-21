package com.example.demo;

import com.example.demo.model.UserModel;
import com.example.demo.model.UserType;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private UserService userService;

    @Autowired
    public DemoApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String email = "admin@mail.ru";
        UserModel oneByEmail = userService.findAllByEmail(email);
        if (oneByEmail == null) {
            userService.saveUser(UserModel.builder()
                    .email(email)
                    .password(new BCryptPasswordEncoder().encode("123456"))
                    .name("admin")
                    .surname("adminyan")
                    .type(UserType.MANAGER)
                    .build());
        }
    }
}



