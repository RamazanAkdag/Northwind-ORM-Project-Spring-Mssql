package org.repositorypattern.myrepo.dataAccess.abstrct;

import lombok.RequiredArgsConstructor;
import org.repositorypattern.myrepo.dataAccess.abstrct.IGenericRepository;
import org.repositorypattern.myrepo.helper.db.MssqlDbContext;
import org.repositorypattern.myrepo.helper.mapping.IGenericMapper;
import org.repositorypattern.myrepo.model.IEntity;

import java.lang.reflect.Field;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class GenericRepositoryBase<T extends IEntity> implements IGenericRepository<T> {
    protected final IGenericMapper<T> mapper;
    @Override
    public List<T> getAll() {
        try (Connection conn = new MssqlDbContext().getConnection()){
            List<T> list = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("select * from " + getDbName());

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                T obj = mapper.mapTo(resultSet);
                list.add(obj);
            }

            conn.close();

            return list;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(T t) {
        try(Connection conn = new MssqlDbContext().getConnection()){
            String[] fieldNames = mapper.getFields();
            System.out.println(t.toString());

            String sql = "INSERT INTO " + getDbName() + " (" +
                   String.join(", ", fieldNames) + ") VALUES (" +
                    Arrays.stream(fieldNames)
                            .map(name -> "?")
                            .collect(Collectors.joining(", ")) + ")";




            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for(int i = 0 ; i < fieldNames.length ; i++) {
                    Field field = t.getClass().getDeclaredField(fieldNames[i]);
                    field.setAccessible(true);

                    pstmt.setObject(i + 1, field.get(t));

                }
                pstmt.executeUpdate();
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    protected abstract String getDbName();
}
