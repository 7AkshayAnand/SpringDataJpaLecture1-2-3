package com.example.akshay.Db.controllers;

import com.example.akshay.Db.entities.ProductEntity;
import com.example.akshay.Db.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/products")

public class ProductController {
    private final int pageSize=5;
    public final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

//   @GetMapping
//    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id")String sortBy){
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy));
//    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id")String sortBy, @RequestParam(defaultValue = "1") Integer pageNumber){
        Pageable pageable= PageRequest.of(pageNumber,pageSize,Sort.by(sortBy));
        return productRepository.findAll(pageable).getContent();
    }
}
