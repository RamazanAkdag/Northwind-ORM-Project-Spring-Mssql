package org.repositorypattern.myrepo.service.concrete;

import lombok.RequiredArgsConstructor;
import org.repositorypattern.myrepo.dataAccess.abstrct.ICustomerRepository;
import org.repositorypattern.myrepo.model.Customer;
import org.repositorypattern.myrepo.service.abstrct.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerManager implements ICustomerService {

    private final ICustomerRepository customerRepository;
    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
}
