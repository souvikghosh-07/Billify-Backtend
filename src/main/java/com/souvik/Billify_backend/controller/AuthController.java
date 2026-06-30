package com.souvik.Billify_backend.controller;

import com.souvik.Billify_backend.model.Auth;
import com.souvik.Billify_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "https://billify-frontend.vercel.app","https://billify-frontend-b7wuqn4z8-souvik07.vercel.app"})

public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("/signup")
    public boolean signUp (@RequestParam String userName,@RequestParam String email,
                           @RequestParam String password) {
       return service.signUp(userName,email,password);

    }

    @PostMapping("/signin")
    public Auth signIn (@RequestParam String email, @RequestParam String password) {
        return service.signIn(email,password);

    }
}
