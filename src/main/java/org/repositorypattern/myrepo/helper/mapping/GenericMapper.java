package org.repositorypattern.myrepo.helper.mapping;

import org.repositorypattern.myrepo.model.IEntity;

import java.lang.reflect.Field;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;


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

    @Override
    public String[] getFields() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        T instance = type.getDeclaredConstructor().newInstance();
        Field[] fields = instance.getClass().getDeclaredFields();
        return Arrays.stream(fields)
                .skip(1)
                .map(Field::getName)
                .toArray(String[]::new);

    }
}
