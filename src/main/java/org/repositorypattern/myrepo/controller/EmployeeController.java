package org.repositorypattern.myrepo.controller;

import lombok.RequiredArgsConstructor;
import org.repositorypattern.myrepo.model.Employee;
import org.repositorypattern.myrepo.model.dto.EmployeeDto;
import org.repositorypattern.myrepo.service.abstrct.IEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody EmployeeDto employeeDto){

        employeeService.save(employeeDto);
        return ResponseEntity.ok("Employee added");
    }
}
