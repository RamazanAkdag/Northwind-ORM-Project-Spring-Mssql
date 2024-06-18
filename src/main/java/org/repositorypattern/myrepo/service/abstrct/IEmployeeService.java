package org.repositorypattern.myrepo.service.abstrct;

import org.repositorypattern.myrepo.model.Customer;
import org.repositorypattern.myrepo.model.Employee;
import org.repositorypattern.myrepo.model.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAll();

    public void save(EmployeeDto employeeDto);
}
