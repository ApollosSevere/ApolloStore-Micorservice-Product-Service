package com.apollostore.productService.service;

import com.apollostore.productService.model.ProductResponse;
import com.apollostore.productService.model.ProductRequest;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
