package com.example.app.model.product;

import org.springframework.stereotype.Repository;

import com.example.app.model.AbstractRepository;

@Repository
public interface ProductRepository extends AbstractRepository<Product, Long> {
    //  custom methods 
}
