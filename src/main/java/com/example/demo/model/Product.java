package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private double price;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brand brand;

    private String picUrl;

    private Timestamp timestamp;

    @PrePersist
    public void prePersist(){
        timestamp = Timestamp.valueOf(LocalDateTime.now());
    }


}
