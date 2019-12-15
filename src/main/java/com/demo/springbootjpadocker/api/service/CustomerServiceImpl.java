package com.demo.springbootjpadocker.api.service;

import com.demo.springbootjpadocker.api.dto.CustomerDto;
import com.demo.springbootjpadocker.api.exception.CustomerNotFoundException;
import com.demo.springbootjpadocker.api.model.Customer;
import com.demo.springbootjpadocker.api.repository.CustomerRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public Customer findById(long id) {
        return customerRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public Customer add(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .name(customerDto.getName())
                .surname(customerDto.getSurname())
                .address(customerDto.getAddress())
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(CustomerDto customerDto, long id) {
        Customer customer=findById(id);
        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setAddress(customerDto.getAddress());
        return customerRepository.save(customer);
    }

    @Override
    public void delete(long id) {
        Customer customer=findById(id);
        customer.setDeleted(true);
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllByIdDeleteFalse() {
        return customerRepository.findCustomerByDeletedFalse();
    }
}
