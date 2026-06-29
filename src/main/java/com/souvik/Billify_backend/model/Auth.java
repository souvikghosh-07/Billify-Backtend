package com.souvik.Billify_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    String userName;
    String email;
    String password;

    public Auth(String password, String email, String userName) {
        this.password = password;
        this.email = email;
        this.userName = userName;
    }
}
