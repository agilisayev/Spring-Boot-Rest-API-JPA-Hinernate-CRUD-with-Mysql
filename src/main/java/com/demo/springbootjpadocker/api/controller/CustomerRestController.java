package com.demo.springbootjpadocker.api.controller;

import com.demo.springbootjpadocker.api.dto.CustomerDto;
import com.demo.springbootjpadocker.api.dto.IdDto;
import com.demo.springbootjpadocker.api.model.Customer;
import com.demo.springbootjpadocker.api.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
@Api(value = "Customer Rest Api")
public class CustomerRestController {
    private CustomerService customerService;

    private static final String FIND_BY_ID = "Find Customer By Id";
    private static final String CUSTOMER_ID_MUST_BE_POSITIVE = "Customer id must be positive";
    private static final String ADD_CUSTOMER = "Add New Customer";
    private static final String UPDATE_CUSTOMER = "Add New Customer";
    private static final String DELETE_CUSTOMER = "Delete a Customer";
    private static final String FIND_ALL_CUSTOMERS = "Find All  Customers";


    @ApiOperation(value = FIND_BY_ID, response = Customer.class)
    @GetMapping(value = "/findById/{id}")
    public Customer findById(@PathVariable @Positive(message = CUSTOMER_ID_MUST_BE_POSITIVE) long id) {
        return customerService.findById(id);
    }

    @ApiOperation(value = ADD_CUSTOMER, response = Customer.class)
    @PostMapping(value = "add")
    public IdDto add(@RequestBody CustomerDto customerDto) {
        return new IdDto(customerService.add(customerDto).getId());
    }

    @ApiOperation(value = UPDATE_CUSTOMER, response = Customer.class)
    @PutMapping(value = "save/{id}")
    public IdDto save(@RequestBody CustomerDto customerDto, @PathVariable @Positive(message = CUSTOMER_ID_MUST_BE_POSITIVE) long id) {
        return new IdDto(customerService.update(customerDto, id).getId());
    }

    @ApiOperation(value = DELETE_CUSTOMER, response = Customer.class)
    @DeleteMapping(value = "/delete/{id}")
    public IdDto delete(@PathVariable @Positive(message = CUSTOMER_ID_MUST_BE_POSITIVE) long id) {
        customerService.delete(id);
        return new IdDto(id);
    }

    @ApiOperation(value = FIND_ALL_CUSTOMERS, response = Customer.class)
    @GetMapping(value = "/findAll")
    public List<Customer> findAll() {
        return customerService.findAllByIdDeleteFalse();
    }


}
