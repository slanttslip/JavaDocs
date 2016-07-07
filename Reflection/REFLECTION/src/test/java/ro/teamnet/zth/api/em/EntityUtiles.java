package ro.teamnet.zth.api.em;

import org.testng.annotations.Test;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.appl.domain.Departament;
import ro.teamnet.zth.appl.domain.Location;

import java.util.*;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Adrian.Calancea on 7/7/16.
 */
public class EntityUtiles {
    List<String> lista= Arrays.asList("LOCATION_ID", "STREET_ADDRESS", "POSTAL_CODE", "CITY", "STATE_PROVINCE");
    List<String> lista_field_column= Arrays.asList("streetAddress", "postalCode", "city", "stateProvince");
    List<String> lista_field_id= Arrays.asList("id");
    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.GetTableName(Departament.class);
        assertEquals("Table name should be departments!", "DEPARTMENTS", tableName);
        assertEquals("Table name should be Location!", "LOCATIONS", EntityUtils.GetTableName(Location.class));
    }


    @Test
    public void testGetColumnsMethod() {
List <String>lista_mea=new ArrayList<String>();
        for (ColumnInfo cm:EntityUtils.GetColumns(Location.class)){
           lista_mea.add(cm.getDbName());
        }
        assertEquals("List of all Fileds of !",lista,lista_mea);
    }

    @Test
    public void testcastFromSqlTypeMethod() {
        boolean b;
        Object obj = EntityUtils.castFromSqlType(2.00, Double.class);
        if (obj.getClass().equals(Double.class)) b = true;
        else b = false;
        assertEquals("Trebuie sa afieze", true, b);
    }

    @Test
    public void testgetFieldsByAnnotationsMethod() {
        List<String> lista_mea=new ArrayList<>();
        for (String cm:EntityUtils.getFieldsByAnnotations(Location.class,Column.class)){
            lista_mea.add(cm);
        }

        List<String> lista_mea1=new ArrayList<>();
        for (String cm:EntityUtils.getFieldsByAnnotations(Location.class,Id.class)){
            lista_mea1.add(cm);
        }

        assertEquals("List of all Fileds of !",lista_field_column,lista_mea);
        assertEquals("List of all id of !",lista_field_id,lista_mea1);
    }

    @Test
    public void testgetSqlValueMethod() {
       Location l=new Location();
        Object o=new Object();
        l.setId(new Long(1));
try {
    Object object = EntityUtils.getSqlValue(l);
    assertEquals("List of all Fileds of !","1",object.toString());
}

catch (IllegalAccessException e){
    System.out.println(e.getMessage());
}



    }



}
