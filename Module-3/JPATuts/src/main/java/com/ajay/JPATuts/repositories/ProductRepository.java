package com.ajay.JPATuts.repositories;

import com.ajay.JPATuts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByTitle(String title, Pageable pageable);

    List<Product> findByCreatedAtAfterOrderByTitle(LocalDateTime after);

    List<Product> findByQuantityGreaterThanOrPriceLessThan(int quantity, BigDecimal price);

    List<Product> findByTitleLike(String title);

    List<Product> findByTitleContainingIgnoreCase(String title,  Pageable pageable);

//    Optional<Product> findByTitleAndPrice(String title, BigDecimal price);

    @Query("select e.title, e.price from ProductEntity e where e.title=:title and e.price=:price")
    Optional<Product> findByTitleAndPrice(String title, BigDecimal price);

}
