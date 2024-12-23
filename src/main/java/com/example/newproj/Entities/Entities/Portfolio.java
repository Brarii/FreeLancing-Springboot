package com.example.newproj.Entities.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String link;
    private String fileName;


    @OneToOne(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private FreeLancer freelancer;
}

