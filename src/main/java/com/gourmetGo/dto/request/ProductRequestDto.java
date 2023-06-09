package com.gourmetGo.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

import java.util.UUID;

public class ProductRequestDto {
//    @NotNull
//    private UUID restaurantId;
    @NotNull
    @Size(min = 3, message = "Product name must be at least 3 characters long")
    private String name;
    @Nullable
    private String description;
    @NotNull
    @PositiveOrZero
    private Double price;
    @NotNull
    private String category;

//    public ProductRequestDto(@NotNull UUID restaurantId, @NotNull String name, @Nullable String description, @NotNull Double price, @NotNull String category) {
//        this.restaurantId = restaurantId;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.category = category;
//    }

    public ProductRequestDto(@NotNull String name, @Nullable String description, @NotNull Double price, @NotNull String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }


//    public UUID getRestaurantId() {
//        return restaurantId;
//    }

    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
