package com.example.demo.repository;

import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
