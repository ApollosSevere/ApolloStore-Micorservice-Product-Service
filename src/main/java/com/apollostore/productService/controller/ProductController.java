package com.apollostore.productService.controller;

import com.apollostore.productService.model.ProductRequest;
import com.apollostore.productService.model.ProductResponse;
import com.apollostore.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
        long productId = productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(
            @PathVariable("id") long productId,
            @RequestHeader("username") String username,
            @RequestHeader("authorities") String authorities,
            @RequestHeader("auth-token") String authToken
    ) {
//        System.out.println(username + " " + authorities + " " + authToken + "<<<<<<<<<< --------");
        ProductResponse productResponse
                = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(
            @PathVariable("id") long productId,
            @RequestParam long quantity
    ) {
            productService.reduceQuantity(productId,quantity);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
