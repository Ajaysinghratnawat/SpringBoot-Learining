package com.ajay.JPATuts.controllers;

import com.ajay.JPATuts.entities.Product;
import com.ajay.JPATuts.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping
//    public List<Product> getAllProducts(){
//        return productRepository.findByOrderByPrice();
//    }
    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "1") Integer pageNumber){
//        return productRepository.findBy(Sort.by(sortBy));
//        return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy)));
        Pageable pageable = PageRequest.of(pageNumber,1,Sort.by("price").ascending());
        return productRepository.findAll(pageable);
    }

}
