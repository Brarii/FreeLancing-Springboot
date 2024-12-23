package com.example.newproj.repositories;

import com.example.newproj.Entities.Entities.appuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<appuser, String> {
    appuser findByUsername(String username);
}
