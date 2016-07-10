package ro.teamnet.zth.api.em;

import com.sun.org.apache.bcel.internal.generic.Select;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.domain.Job;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by Adrian.Calancea on 7/8/16.
 */
public class EntityManagerImpl implements EntityManager {

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {


        List<T> tlist = new ArrayList<T>();
        Connection con;
        try {
            con = (Connection) DBManager.getConnection();
            Statement st = con.createStatement();
            QueryBuilder qb = new QueryBuilder();
            qb.setTableName(EntityUtils.getTableName(entityClass));
            qb.setQueryType(QueryType.SELECT);

            List<ColumnInfo> list = EntityUtils.getColumns(entityClass);
            qb.addQueryColumns(list);


            ResultSet rs = st.executeQuery(qb.createQuery().toString());

            while (rs.next()) {
                T t = entityClass.newInstance();//cream o instanta a clasei noastre
                //luam toate campurile de pe clasa noastra
                for (ColumnInfo ci : list) {// fiecare camp are cate un column info asa ca parcurem campurile adica parcurgem toate clumn infurile si gasim fildeul respectiv
                    Field f = entityClass.getDeclaredField(ci.getColumnName());//scoatem toate filderurile
                    f.setAccessible(true);//il facem accesibil
                    f.set(t, EntityUtils.castFromSqlType(rs.getObject(ci.getDbName()), ci.getColumnType()));//setam valoatea in stantele de obiectul nostru(din parametru)
                }
                tlist.add(t);//adaugam nstaneltele intr-un list
            }
            con.close();

            return tlist;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return null;
    }


    @Override
    public <T> T findById(Class<T> entityClass, Long id) {

        try {
            T t = entityClass.newInstance();
            Connection con = (Connection) DBManager.getConnection();
            Statement st = con.createStatement();
            QueryBuilder qb = new QueryBuilder();
            qb.setTableName(EntityUtils.getTableName(entityClass));
            qb.setQueryType(QueryType.SELECT);

            String a = null;
            List<ColumnInfo> list = EntityUtils.getColumns(entityClass);
            qb.addQueryColumns(list);
            for (ColumnInfo ci : list) {// fiecare camp are cate un column info asa ca parcurem campurile adica parcurgem toate clumn infurile si gasim fildeul respectiv
                if (ci.isId()) {
                    a = ci.getDbName();//scoatem toate filderurile
                    break;
                }
            }
            Condition condition = new Condition(a, id);
            qb.addCondition(condition);
            ResultSet rs = st.executeQuery(qb.createQuery().toString());

            while (rs.next()) {
                t = entityClass.newInstance();//cream o instanta a clasei noastre
                //luam toate campurile de pe clasa noastra
                for (ColumnInfo ci : list) {// fiecare camp are cate un column info asa ca parcurem campurile adica parcurgem toate clumn infurile si gasim fildeul respectiv
                    Field f = entityClass.getDeclaredField(ci.getColumnName());//scoatem toate filderurile
                    f.setAccessible(true);//il facem accesibil
                    f.set(t, EntityUtils.castFromSqlType(rs.getObject(ci.getDbName()), ci.getColumnType()));//setam valoatea in stantele de obiectul nostru(din parametru)
                }
            }
            con.close();
            return t;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Long getNextIdVal(String tableName, String columnIdName) {

        try {

            Connection con = (Connection) DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select max(" + columnIdName + ") from " + tableName);

            rs.next();
            Long value = rs.getLong(1);
            con.close();
            return value + 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public <T> Object insert(T entity) {
        String value = null;
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            QueryBuilder qb = new QueryBuilder();
            qb.setQueryType(QueryType.INSERT);
            qb.setTableName(EntityUtils.getTableName(entity.getClass()));
            List<ColumnInfo> list = EntityUtils.getColumns(entity.getClass());
            qb.addQueryColumns(list);
            for (ColumnInfo ci : list) {
                if (ci.isId()) {
                    ci.setValue(getNextIdVal(EntityUtils.getTableName(entity.getClass()), ci.getDbName()));
                    value = ci.getDbName();
                } else {
                    Field f = entity.getClass().getDeclaredField(ci.getColumnName());
                    f.setAccessible(true);
                    ci.setValue(f.get(entity));
                }
            }
            //list = EntityUtils.getColumns(entity.getClass());
            //System.out.println(qb.createQuery());
            st.executeUpdate(qb.createQuery());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return findById(entity.getClass(), getNextIdVal(EntityUtils.getTableName(entity.getClass()), value) - 1);
    }


    public static void main(String[] args) {

        EntityManagerImpl t = new EntityManagerImpl();
        Department a = new Department();
        a.setDepartmentName("Adrian");
        a.setLocations(1000);
//Location a = new Location();
        //Employee a=new Employee();
        /*a=t.findById(a.getClass(),new Long(171));
        System.out.println(a.getFirstName());*/
      /*  Job a=new Job();
        Job list2[] = new Job[t.findAll(a.getClass()).size()];
list2=t.findAll(a.getClass()).toArray(list2);
        System.out.println(list2[1].getJobTitle());*/

        //System.out.println(t.findAll(a.getClass()).size());

/*
        String value=null;
List<ColumnInfo> list =EntityUtils.getColumns(a.getClass());
        for (ColumnInfo ci : list) {
            if (ci.isId()) {
                value = ci.getDbName();
                break;
            }
        }
System.out.println(t.getNextIdVal(EntityUtils.getTableName(a.getClass()),value));
*/
        System.out.println(t.insert(a));
    }
}
