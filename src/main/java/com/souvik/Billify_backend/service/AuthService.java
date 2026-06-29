package com.souvik.Billify_backend.service;

import com.souvik.Billify_backend.model.Auth;
import com.souvik.Billify_backend.repo.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthRepo repo;


    public boolean signUp(String userName,String email, String password) {
        try{
            Auth ob = new Auth(userName,email,password);
            repo.save(ob);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }
    public Auth signIn(String email, String password) {
        try{
            Auth ob = repo.findByEmailAndPassword(email,password);
            if (ob!=null) {
                return ob;
            }
            return null;

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

