package com.example.newproj.repositories.Repositories;
import com.example.newproj.Entities.Entities.FreeLancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FreeLancerRepository extends JpaRepository<FreeLancer,Long> {
    Optional<FreeLancer> findByEmail(String email);
}
