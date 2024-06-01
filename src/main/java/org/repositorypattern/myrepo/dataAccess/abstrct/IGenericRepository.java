package org.repositorypattern.myrepo.dataAccess.abstrct;

import org.repositorypattern.myrepo.helper.mapping.IGenericMapper;
import org.repositorypattern.myrepo.model.IEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IGenericRepository<T extends IEntity> {


    List<T> getAll();

}
