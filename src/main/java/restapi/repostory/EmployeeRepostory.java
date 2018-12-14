package restapi.repostory;

import org.springframework.data.repository.CrudRepository;
import restapi.model.Employee;

public interface EmployeeRepostory extends CrudRepository<Employee, Long> {


}
