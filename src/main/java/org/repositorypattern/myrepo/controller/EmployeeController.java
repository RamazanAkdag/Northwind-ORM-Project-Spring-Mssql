package org.repositorypattern.myrepo.controller;

import lombok.RequiredArgsConstructor;
import org.repositorypattern.myrepo.model.Employee;
import org.repositorypattern.myrepo.service.abstrct.IEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
