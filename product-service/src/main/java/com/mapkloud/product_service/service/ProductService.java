package com.mapkloud.product_service.service;

import com.mapkloud.product_service.dto.ProductRequest;
import com.mapkloud.product_service.dto.ProductResponse;
import com.mapkloud.product_service.model.Product;
import com.mapkloud.product_service.repository.ProductRepository;
import com.mapkloud.product_service.util.ProductHelper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.ProductBuilder.aProduct()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(ProductHelper::convertProductToProductResponse)
                .toList();
    }

}
