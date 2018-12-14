package restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restapi.model.Employee;
import restapi.repostory.EmployeeRepostory;
import restapi.service.EmployeeService;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepostory repostory;

    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>)repostory.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return repostory.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Employee employee) {
     repostory.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
     repostory.deleteById(id);
    }
}
