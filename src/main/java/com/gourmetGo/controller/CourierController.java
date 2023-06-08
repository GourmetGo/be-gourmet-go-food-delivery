package com.gourmetGo.controller;

import com.gourmetGo.dto.request.user.CourierRequestDto;
import com.gourmetGo.exception.BadRequestException;
import com.gourmetGo.model.user.Courier;
import com.gourmetGo.service.CourierService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/couriers")
public class CourierController {
    private CourierService courierService;

    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> registerCourier(@Valid @RequestBody CourierRequestDto courierRequestDto) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            Courier courier = courierService.convertDtoToCourier(courierRequestDto);
            courierService.save(courier);
            Map<String, String> data = new LinkedHashMap<>();
            data.put("id", courier.getId().toString());
            response.put("data", data);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (BadRequestException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }
    @GetMapping
    public List<Courier> getAllCouriers() {
        return courierService.findAll();
    }
}
