package org.repositorypattern.myrepo.dataAccess.abstrct;

import lombok.RequiredArgsConstructor;
import org.repositorypattern.myrepo.dataAccess.abstrct.IGenericRepository;
import org.repositorypattern.myrepo.helper.db.MssqlDbContext;
import org.repositorypattern.myrepo.helper.mapping.IGenericMapper;
import org.repositorypattern.myrepo.model.IEntity;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    protected abstract String getDbName();
}
