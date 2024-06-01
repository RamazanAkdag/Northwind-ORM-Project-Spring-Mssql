package org.repositorypattern.myrepo.service.concrete;

import lombok.RequiredArgsConstructor;
import org.repositorypattern.myrepo.dataAccess.abstrct.IEmployeeRepository;
import org.repositorypattern.myrepo.model.Employee;
import org.repositorypattern.myrepo.service.abstrct.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}
