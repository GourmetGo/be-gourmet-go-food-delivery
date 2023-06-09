package com.gourmetGo.service;

import com.gourmetGo.dto.request.ProductRequestDto;
import com.gourmetGo.model.Product;
import com.gourmetGo.model.user.Restaurant;
import com.gourmetGo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    public void save(Product product, Restaurant restaurant) {
//        productRepository.setProduct(product.getId(), restaurant.getId());
//    }

    public Product addProduct(ProductRequestDto productRequestDto) {
        return new Product(
                productRequestDto.getName(),
                productRequestDto.getDescription(),
                productRequestDto.getPrice(),
                productRequestDto.getCategory()
        );
    }
}
