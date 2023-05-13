package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Product;
import com.springboot.blog.repository.ProductRepository;
import com.springboot.blog.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    // no need to annotate with @Autowired as spring will auto add this annotation when there is only one constructor
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProducts(query);
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
