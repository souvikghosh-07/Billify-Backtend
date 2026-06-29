package com.souvik.Billify_backend.repo;

import com.souvik.Billify_backend.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AuthRepo extends JpaRepository<Auth,Integer> {
    Auth findByEmailAndPassword(String email, String password);
}
