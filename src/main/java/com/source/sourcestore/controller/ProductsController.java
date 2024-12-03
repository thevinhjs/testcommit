package com.source.sourcestore.controller;

import com.source.sourcestore.dto.request.ProductsCreationRequest;
import com.source.sourcestore.dto.request.ProductsUpdateRequest;
import com.source.sourcestore.entity.Products;
import com.source.sourcestore.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @PostMapping
    Products createProducts (@RequestBody ProductsCreationRequest request) {
        return  productsService.createProducts(request);
    }
    @GetMapping
    List<Products> getAllProducts () {
        return productsService.getAllProducts();
    }
    @GetMapping("/{productId}")
        Products getProductById (@PathVariable String productId) {
        return productsService.getProducts(productId);
        }
    @PutMapping ("/{productId}")
    Products updateProducts (@PathVariable String productId, @RequestBody ProductsUpdateRequest request) {
        return productsService.updateProducts(productId, request);
    }
    @DeleteMapping("/{productId}")
    String deleteProduct (@PathVariable String productId) {
        productsService.deleteProduct(productId);
        return "Product has been deleted";
    }
}
