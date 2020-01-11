package com.gill.msscbrewery.web.mappers;

import com.gill.msscbrewery.domain.Customer;
import com.gill.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);
}
