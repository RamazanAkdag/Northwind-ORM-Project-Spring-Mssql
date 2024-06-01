package org.repositorypattern.myrepo.helper.mapping;

import org.repositorypattern.myrepo.model.IEntity;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IGenericMapper<T extends IEntity> {

    public T mapTo(ResultSet resultSet) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
