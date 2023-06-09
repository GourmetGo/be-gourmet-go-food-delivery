package com.gourmetGo.repository;

import com.gourmetGo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
//    @Modifying
//    @Query("UPDATE Product p SET p.restaurant_id = :restaurantId WHERE p.id = :productId")
//    void setProduct(@Param("restaurantId")UUID restaurantId, @Param("productId")UUID productId);
}
