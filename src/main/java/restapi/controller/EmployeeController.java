package restapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapi.exception.EmployeeNotFoundException;
import restapi.model.Employee;
import restapi.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        employeeService.saveOrUpdate(employee);
        return employee;
    }

    @GetMapping("/list")
    public List<Employee> list(){
        return employeeService.getAllEmployee();
    }


    @GetMapping("/list/{id}")
    public Employee getbyId(@PathVariable Long id){
        Employee employee=employeeService.getById(id);
        if(employee==null) throw  new EmployeeNotFoundException("Employee id not found - "+id);
        return employee;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable (value = "id") Long id){
        Employee theCustomer =employeeService.getById(id);
        if(theCustomer == null) throw new EmployeeNotFoundException("Customer id not found - " + id);
        employeeService.deleteEmployee(id);
        return "Deleted Succsefully id = "+id;
    }

    @DeleteMapping("/delete2/{id}")
    public List<Employee> deleteEmployeee(@PathVariable (value = "id") Long id){
        Employee theCustomer =employeeService.getById(id);
        if(theCustomer == null) throw new EmployeeNotFoundException("Customer id not found - " + id);
        employeeService.deleteEmployee(id);
        return employeeService.getAllEmployee();
    }

}
