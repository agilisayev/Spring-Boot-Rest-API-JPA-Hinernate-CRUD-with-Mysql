package restapi.service;

import restapi.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public Employee getById(Long id);

    public void saveOrUpdate(Employee employee);

    public void deleteEmployee(Long id);
}
