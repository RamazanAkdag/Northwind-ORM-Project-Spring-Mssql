package org.repositorypattern.myrepo.controller;

import lombok.RequiredArgsConstructor;
import org.repositorypattern.myrepo.model.Customer;
import org.repositorypattern.myrepo.service.abstrct.ICustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping
    private List<Customer> getCustomers(){
        return customerService.getAll();
    }
}
