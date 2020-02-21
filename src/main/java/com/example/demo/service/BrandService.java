package com.example.demo.service;

import com.example.demo.model.Brand;

import java.util.List;

public interface BrandService {

    void saveBrand(Brand brand);

    List<Brand> findAllBrands();
}
