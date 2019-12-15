package com.demo.springbootjpadocker.api.service;


import com.demo.springbootjpadocker.api.dto.CustomerDto;
import com.demo.springbootjpadocker.api.model.Customer;
import java.util.List;

public interface CustomerService {
    Customer findById(long id);
    Customer add(CustomerDto customerDto);
    Customer update (CustomerDto customerDto,long id);
    void  delete(long id);
    List<Customer> findAllByIdDeleteFalse();
}
