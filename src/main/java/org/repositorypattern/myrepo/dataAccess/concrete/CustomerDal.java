package org.repositorypattern.myrepo.dataAccess.concrete;



import org.repositorypattern.myrepo.dataAccess.abstrct.GenericRepositoryBase;
import org.repositorypattern.myrepo.dataAccess.abstrct.ICustomerRepository;
import org.repositorypattern.myrepo.helper.mapping.IGenericMapper;
import org.repositorypattern.myrepo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDal extends GenericRepositoryBase<Customer> implements ICustomerRepository {

    @Autowired
    public CustomerDal(IGenericMapper<Customer> mapper) {
        super(mapper);
    }

    @Override
    protected String getDbName() {
        return "dbo.Customers";
    }
}
