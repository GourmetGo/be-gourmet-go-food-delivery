package com.gourmetGo.service;

import com.gourmetGo.dto.request.user.CourierRequestDto;
import com.gourmetGo.dto.response.user.CourierResponseDto;
import com.gourmetGo.exception.BadRequestException;
import com.gourmetGo.model.user.Courier;
import com.gourmetGo.repository.user.CourierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierService {
    private CourierRepository courierRepository;

    public CourierService(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    public List<Courier> findAll() {
        return courierRepository.findAll();
    }

    public void save(Courier courier) throws BadRequestException {
        if(courierRepository.findByUsername(courier.getUsername()) != null) {
            throw new BadRequestException("Username taken!");
        }
        //        customer.setPassword(); //ToDo: encode password
        courierRepository.save(courier);
    }

    public CourierResponseDto convertCourierToDto(Courier courier) {
        return new CourierResponseDto(
                courier.getId(),
                courier.getUsername(),
                courier.getPassword(),
                courier.getFirstname(),
                courier.getLastname(),
                courier.getEmail(),
                courier.getPhone()
        );
    }

    public Courier convertDtoToCourier(CourierRequestDto courierRequestDto) {
        return new Courier(
                courierRequestDto.getUsername(),
                courierRequestDto.getPassword(),
                courierRequestDto.getFirstname(),
                courierRequestDto.getLastname(),
                courierRequestDto.getEmail(),
                courierRequestDto.getPhone()
        );
    }
}
