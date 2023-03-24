package com.example.Project_123.repositories;

import com.example.Project_123.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product, Integer> {
}
