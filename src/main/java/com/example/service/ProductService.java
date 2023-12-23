package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired private ProductRepository productRepository;

    public List<Product> listAll() {
        return (List<Product>) productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product get(Integer id) throws ProductNotFoundException {
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ProductNotFoundException("не удалось найти продукт с таким id" + id);
    }

    public void delete(Integer id) throws ProductNotFoundException {
        Long count = productRepository.countById(id);
        if (count == null || count == 0) {
            throw new ProductNotFoundException("не удалось найти продукт с таким id" + id);
        }
        productRepository.deleteById(id);
    }
}
