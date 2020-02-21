package com.example.demo.service.impl;

import com.example.demo.model.Brand;
import com.example.demo.repository.BrandRepository;
import com.example.demo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository){
        this.brandRepository=brandRepository;
    }

    @Override
    public void saveBrand(Brand brand) {
        brandRepository.save(brand);

    }

    @Override
    public List<Brand> findAllBrands() {
        return brandRepository.findAll();
    }
}
