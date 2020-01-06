package com.gill.msscbrewery.services;

import com.gill.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().name("Rashpal")
                .uuid(UUID.randomUUID())
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .uuid(UUID.randomUUID())
                .name(customerDto.getName())
                .build();
    }

    @Override
    public CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto) {
        return CustomerDto.builder()
                .uuid(customerId)
                .name(customerDto.getName())
                .build();
    }

    @Override
    public void deleteById(UUID customerId) {
        log.info("Deleting a customer..." + customerId);
    }
}
