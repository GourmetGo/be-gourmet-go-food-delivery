package com.gourmetGo.service;

import com.gourmetGo.dto.request.user.RestaurantRequestDto;
import com.gourmetGo.dto.response.user.RestaurantResponseDto;
import com.gourmetGo.exception.BadRequestException;
import com.gourmetGo.model.Product;
import com.gourmetGo.model.user.Restaurant;
import com.gourmetGo.repository.ProductRepository;
import com.gourmetGo.repository.user.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantService {
    private RestaurantRepository restaurantRepository;
    private ProductRepository productRepository;


    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public Restaurant getById(UUID id) {
        if(restaurantRepository.findById(id).isEmpty()){
            throw new BadRequestException("Restaurant with id " + id + " not found!");
        }
        return restaurantRepository.findById(id).orElse(null);
    }

    public void save(Restaurant restaurant) throws BadRequestException {
        if(restaurantRepository.findByUsername(restaurant.getUsername()) != null) {
            throw new BadRequestException("Username taken!");
        }
    //        restaurant.setPassword(); //ToDo: encode password
        restaurantRepository.save(restaurant);
    }

    public RestaurantResponseDto convertRestaurantToDto(Restaurant restaurant) {
        return new RestaurantResponseDto(
                restaurant.getId(),
                restaurant.getUsername(),
                restaurant.getPassword(),
                restaurant.getName(),
                restaurant.getEmail(),
                restaurant.getPhone(),
                restaurant.getAddress(),
                restaurant.getProducts(),
                restaurant.getOrders()
        );
    }

    public Restaurant registerRestaurant(RestaurantRequestDto restaurantRequestDto) {
        return new Restaurant(
                restaurantRequestDto.getUsername(),
                restaurantRequestDto.getPassword(),
                restaurantRequestDto.getEmail(),
                restaurantRequestDto.getPhone(),
                restaurantRequestDto.getName(),
                restaurantRequestDto.getAddress(),
                null,
                null
        );
    }
}
