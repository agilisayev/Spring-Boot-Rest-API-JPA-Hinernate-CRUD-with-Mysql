package restapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapi.exception.CustomerNotFoundException;
import restapi.model.Employee;
import restapi.service.EmployeeService;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        service.saveOrUpdate(employee);
        return employee;
    }

    @GetMapping("/list")
    public List<Employee> list(){
        return service.getAllEmployee();
    }


    @GetMapping("/list/{id}")
    public Employee getbyId(@PathVariable Long id){
        Employee employee=service.getById(id);
        if(employee==null) throw  new CustomerNotFoundException("Employee id not found - "+id);
        return employee;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable (value = "id") Long id){
        Employee theCustomer =service.getById(id);
        if(theCustomer == null) throw new CustomerNotFoundException("Customer id not found - " + id);
        service.deleteEmployee(id);
        return "Deleted Succsefully id = "+id;
    }

    @DeleteMapping("/delete2/{id}")
    public List<Employee> deleteEmployeee(@PathVariable (value = "id") Long id){
        Employee theCustomer =service.getById(id);
        if(theCustomer == null) throw new CustomerNotFoundException("Customer id not found - " + id);
        service.deleteEmployee(id);
        return service.getAllEmployee();
    }

}
