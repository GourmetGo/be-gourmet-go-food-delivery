package com.gourmetGo.controller;

import com.gourmetGo.dto.request.UserRequestDto;
import com.gourmetGo.exception.BadRequestException;
import com.gourmetGo.model.User;
import com.gourmetGo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> registerUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            User user = userService.convertDtoToUser(userRequestDto);
            userService.save(user);
            Map<String, String> data = new LinkedHashMap<>();
            data.put("id", user.getId().toString());
            response.put("data", data);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (BadRequestException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
