package com.gourmetGo.service;

import com.gourmetGo.dto.request.user.CustomerRequestDto;
import com.gourmetGo.exception.BadRequestException;
import com.gourmetGo.dto.response.user.CustomerResponseDto;
import com.gourmetGo.model.user.Customer;
import com.gourmetGo.repository.user.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void save(Customer customer) throws BadRequestException {
        if(customerRepository.findByUsername(customer.getUsername()) != null) {
            throw new BadRequestException("Username taken!");
        }
//        customer.setPassword(); //ToDo: encode password
        customerRepository.save(customer);
    }

    public CustomerResponseDto convertCustomerToDto(Customer customer) {
        return new CustomerResponseDto(
                customer.getId(),
                customer.getUsername(),
                customer.getPassword(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getAddress()
        );
    }

    public Customer convertDtoToCustomer(CustomerRequestDto customerRequestDto) {
        return new Customer(
                customerRequestDto.getUsername(),
                customerRequestDto.getPassword(),
                customerRequestDto.getFirstname(),
                customerRequestDto.getLastname(),
                customerRequestDto.getEmail(),
                customerRequestDto.getPhone(),
                customerRequestDto.getAddress()
        );
    }
}
