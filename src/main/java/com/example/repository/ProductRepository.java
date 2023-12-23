package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    public Long countById(Integer id);
}
