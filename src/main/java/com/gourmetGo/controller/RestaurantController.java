package com.gourmetGo.controller;

import com.gourmetGo.dto.request.user.RestaurantRequestDto;
import com.gourmetGo.exception.BadRequestException;
import com.gourmetGo.model.user.Restaurant;
import com.gourmetGo.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
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
}
