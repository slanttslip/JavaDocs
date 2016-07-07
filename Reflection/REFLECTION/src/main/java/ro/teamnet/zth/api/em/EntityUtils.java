package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian.Calancea on 7/7/16.
 */
public class EntityUtils {
    private static Annotation annotation;

    private void EntityUtiles() throws UnsupportedOperationException {
    }

    public static String GetTableName(Class entity) {
        Table mytable = (Table) entity.getAnnotation(Table.class);
        if (mytable instanceof Table)
            return mytable.name();
        else return null;

    }

    public static List<ColumnInfo> GetColumns(Class entity) {
        List<ColumnInfo> mylist = new ArrayList<ColumnInfo>();

        Field[] myfield = entity.getDeclaredFields();

        for (Field f : myfield) {
            Column col = (Column) f.getAnnotation(Column.class);
            Id id = (Id) f.getAnnotation(Id.class);
            ColumnInfo colinfo = new ColumnInfo();
            colinfo.setColumnName(f.getName());
            colinfo.setColumnType(f.getType());

            if (col == null) {
                colinfo.setId(true);
                colinfo.setDbName(id.name());
            } else {
                colinfo.setId(false);
                colinfo.setDbName(col.name());
            }
            mylist.add(colinfo);
        }

    return mylist;}


    public static Object castFromSqlType(Object value, Class wantedType){

            if (value.getClass().equals(BigDecimal.class) && wantedType.getClass().equals(Integer.class))
                return (Integer) value;
            if (value.getClass().equals(BigDecimal.class) && wantedType.getClass().equals(Long.class))
                return (Long) value;
            if (value.getClass().equals(BigDecimal.class) && wantedType.getClass().equals(Float.class))
                return (Float) value;
            if (value.getClass().equals(BigDecimal.class) && wantedType.getClass().equals(Double.class))
                return (Double) value;
            if (value.getClass().equals(BigDecimal.class) && wantedType.getClass().equals(Long.class))
                return (Long) value;
    return value;
    }

    public static List <String> getFieldsByAnnotations(Class clazz, Class annotation){
List listamea=new ArrayList();
        Field[] myfield=clazz.getDeclaredFields();
        for (Field f: myfield) {
            if(f.getAnnotation(annotation)!=null)
                listamea.add(f.getName());

        }
        return listamea;}

    public static Object getSqlValue(Object object) throws IllegalAccessException{
        Field f[];
        Field f1=null;
        f=object.getClass().getDeclaredFields();

        if(object.getClass().getAnnotation(Table.class)!=null){


            for(Field field  : object.getClass().getDeclaredFields())
            {
                if (field.isAnnotationPresent(Id.class))
                {
                    f1= field;
                }
                f1.setAccessible(true);
        }
            return f1.get(object);}
        else return object;
}
}