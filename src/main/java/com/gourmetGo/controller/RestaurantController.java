package com.gourmetGo.controller;

import com.gourmetGo.dto.request.ProductRequestDto;
import com.gourmetGo.dto.request.user.RestaurantRequestDto;
import com.gourmetGo.exception.BadRequestException;
import com.gourmetGo.model.Order;
import com.gourmetGo.model.Product;
import com.gourmetGo.model.user.Restaurant;
import com.gourmetGo.service.ProductService;
import com.gourmetGo.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private RestaurantService restaurantService;
    private ProductService productService;

    public RestaurantController(RestaurantService restaurantService, ProductService productService) {
        this.restaurantService = restaurantService;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> registerRestaurant(@Valid @RequestBody RestaurantRequestDto restaurantRequestDto) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            Restaurant restaurant = restaurantService.registerRestaurant(restaurantRequestDto);
            restaurantService.save(restaurant);
            Map<String, String> data = new LinkedHashMap<>();
            data.put("id", restaurant.getId().toString());
            response.put("data", data);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (BadRequestException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.findAll();
    }

    @GetMapping("/id")
    public ResponseEntity<Map<String, Object>> getRestaurantById(@RequestParam UUID id) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            Restaurant restaurant = restaurantService.getById(id);
            response.put("data", restaurant);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadRequestException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Map<String, Object>> addProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
//            Restaurant restaurant = restaurantService.getById(productRequestDto.getRestaurantId());
            Product product = productService.addProduct(productRequestDto);
            productService.save(product);
//            productService.save(product, restaurant);
            Map<String, String> data = new LinkedHashMap<>();
            data.put("id", product.getId().toString());
            response.put("data", data);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (BadRequestException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<Map<String, Object>> getProductsById(@RequestParam UUID id) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            Restaurant restaurant = restaurantService.getById(id);
            response.put("data", restaurant.getProducts());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadRequestException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<Map<String, Object>> getOrdersById(@RequestParam UUID id) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            Restaurant restaurant = restaurantService.getById(id);
            response.put("data", restaurant.getOrders());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadRequestException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }


}
