package com.source.sourcestore.service;

import com.source.sourcestore.dto.request.ProductsCreationRequest;
import com.source.sourcestore.dto.request.ProductsUpdateRequest;
import com.source.sourcestore.entity.Products;
import com.source.sourcestore.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired

    private ProductsRepository productsRepository;
    public Products createProducts (ProductsCreationRequest request) {

        Products products = new Products();

        products.setProductName(request.getProductName());
        products.setProductPrice(request.getProductPrice());
        products.setProductSize(request.getProductSize());
        products.setProductColor(request.getProductColor());
        products.setProductDescription(request.getProductDescription());

        return productsRepository.save(products);
    }

    public void deleteProduct(String productId) {
        productsRepository.deleteById(productId);
    }

   public List<Products> getAllProducts() {
        return productsRepository.findAll();
   }
   public Products getProducts(String productId) {
        return productsRepository.findById(productId).
                orElse(null);
   }
   public Products updateProducts(String productId, ProductsUpdateRequest request) {
        Products products = getProducts(productId);

        products.setProductName(request.getProductName());
        products.setProductPrice(request.getProductPrice());
        products.setProductSize(request.getProductSize());
        products.setProductColor(request.getProductColor());
        products.setProductDescription(request.getProductDescription());

        return productsRepository.save(products);

   }
}
