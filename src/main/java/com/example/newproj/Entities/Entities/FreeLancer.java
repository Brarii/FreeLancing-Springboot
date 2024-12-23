package com.example.newproj.Entities.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FreeLancer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String skills;


    @OneToOne(cascade = CascadeType.ALL)
    private Portfolio portfolio;


@ManyToMany(mappedBy = "freelancers",cascade = CascadeType.ALL)
    private List<Job> jobs;
}
