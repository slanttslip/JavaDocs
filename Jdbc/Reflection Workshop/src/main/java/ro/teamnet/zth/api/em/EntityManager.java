package ro.teamnet.zth.api.em;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Adrian.Calancea on 7/8/16.
 */
public interface EntityManager {
    <T> List<T> findAll(Class<T> entityClass) throws SQLException, ClassNotFoundException;
    <T> T findById(Class<T> entityClass, Long id);
    Long getNextIdVal(String tableName, String columnIdName);
    <T> Object insert(T entity);

}
