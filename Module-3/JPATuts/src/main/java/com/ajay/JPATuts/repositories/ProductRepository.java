package com.ajay.JPATuts.repositories;

import com.ajay.JPATuts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
