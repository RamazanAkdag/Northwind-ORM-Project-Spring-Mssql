package org.repositorypattern.myrepo.config;

import org.repositorypattern.myrepo.helper.mapping.GenericMapper;
import org.repositorypattern.myrepo.helper.mapping.IGenericMapper;
import org.repositorypattern.myrepo.model.Customer;
import org.repositorypattern.myrepo.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public IGenericMapper<Customer> customerMapper(){
        return new GenericMapper<>(Customer.class);
    }

    @Bean
    public IGenericMapper<Employee> employeeMapper(){
        return new GenericMapper<>(Employee.class);
    }


}
