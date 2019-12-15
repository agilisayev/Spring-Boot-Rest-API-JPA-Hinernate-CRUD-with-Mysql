package com.demo.springbootjpadocker.api.repository;


import com.demo.springbootjpadocker.api.model.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Optional<Customer> findByIdAndDeletedFalse(long id);

    List<Customer> findCustomerByDeletedFalse();
}
