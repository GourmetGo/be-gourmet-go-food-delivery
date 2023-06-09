package com.gourmetGo.controller;

import com.gourmetGo.dto.request.user.CustomerRequestDto;
import com.gourmetGo.exception.BadRequestException;
import com.gourmetGo.model.user.Customer;
import com.gourmetGo.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> registerCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            Customer customer = customerService.registerCustomer(customerRequestDto);
            customerService.save(customer);
            Map<String, String> data = new LinkedHashMap<>();
            data.put("id", customer.getId().toString());
            response.put("data", data);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (BadRequestException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }
}
