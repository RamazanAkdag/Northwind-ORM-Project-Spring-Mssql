package org.repositorypattern.myrepo.helper.mapping;

import org.repositorypattern.myrepo.model.IEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GenericMapper<T extends IEntity> implements IGenericMapper<T> {

    private final Class<T> type;

    public GenericMapper(Class<T> type) {
        this.type = type;
    }
    @Override
    public T mapTo(ResultSet resultSet) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {

        T instance = type.getDeclaredConstructor().newInstance();
        Field[] fields = instance.getClass().getDeclaredFields();

        for (Field field : fields){
            field.setAccessible(true);
            String fieldName = field.getName();
            Object fieldValue = resultSet.getObject(fieldName);

            field.set(instance, fieldValue);

        }

        return instance;

    }
}
