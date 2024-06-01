package org.repositorypattern.myrepo.service.abstrct;

import org.repositorypattern.myrepo.model.Customer;

import java.util.List;

public interface ICustomerService {

    public List<Customer> getAll();
}
