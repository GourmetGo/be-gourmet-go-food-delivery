package com.gourmetGo.service;

import com.gourmetGo.dto.request.UserRequestDto;
import com.gourmetGo.exception.BadRequestException;
import com.gourmetGo.dto.response.UserResponseDto;
import com.gourmetGo.model.User;
import com.gourmetGo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) throws BadRequestException {
        if(userRepository.findByUsername(user.getUsername()) != null) {
            throw new BadRequestException("Username taken!");
        }
//        user.setPassword(); //ToDo: encode password
        userRepository.save(user);
    }

    public UserResponseDto convertUserToDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPhone()
        );
    }

    public User convertDtoToUser(UserRequestDto userRequestDto) {
        return new User(
                userRequestDto.getUsername(),
                userRequestDto.getPassword(),
                userRequestDto.getFirstname(),
                userRequestDto.getLastname(),
                userRequestDto.getEmail(),
                userRequestDto.getPhone()
        );
    }
}
