package org.repositorypattern.myrepo.dataAccess.concrete;

import org.repositorypattern.myrepo.dataAccess.abstrct.GenericRepositoryBase;
import org.repositorypattern.myrepo.dataAccess.abstrct.IEmployeeRepository;
import org.repositorypattern.myrepo.helper.mapping.IGenericMapper;
import org.repositorypattern.myrepo.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDal extends GenericRepositoryBase<Employee> implements IEmployeeRepository {
    public EmployeeDal(IGenericMapper<Employee> mapper) {
        super(mapper);
    }

    @Override
    protected String getDbName() {
        return "dbo.Employees";
    }
}
