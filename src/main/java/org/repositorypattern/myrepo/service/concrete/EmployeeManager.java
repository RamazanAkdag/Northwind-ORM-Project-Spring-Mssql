package org.repositorypattern.myrepo.service.concrete;

import lombok.RequiredArgsConstructor;
import org.repositorypattern.myrepo.dataAccess.abstrct.IEmployeeRepository;
import org.repositorypattern.myrepo.model.Employee;
import org.repositorypattern.myrepo.model.dto.EmployeeDto;
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

    @Override
    public void save(EmployeeDto employeeDto) {
        Employee employee = Employee.builder()
                .City(employeeDto.getCity())
                .FirstName(employeeDto.getFirstName())
                .Address(employeeDto.getAddress())
                .BirthDate(employeeDto.getBirthDate())
                .Country(employeeDto.getCountry())
                .Title(employeeDto.getTitle())
                .LastName(employeeDto.getLastName())
                .PostalCode(employeeDto.getPostalCode())
                .Region(employeeDto.getRegion())
                .HomePhone(employeeDto.getHomePhone())
                .HireDate(employeeDto.getHireDate())
                .Extension(employeeDto.getExtension())
                .TitleOfCourtesy(employeeDto.getTitleOfCourtesy())
                .build();



        employeeRepository.save(employee);
    }
}
