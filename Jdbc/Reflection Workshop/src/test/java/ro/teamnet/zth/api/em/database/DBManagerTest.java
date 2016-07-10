package ro.teamnet.zth.api.em.database;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.api.em.EntityUtils;
import ro.teamnet.zth.appl.domain.Department;


import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Adrian.Calancea on 7/8/16.
 */
public class DBManagerTest {

    @Test
    public void testGetConnectionMethod() throws SQLException, ClassNotFoundException {
       try{
        Connection con= (Connection) DBManager.getConnection();

           Assert.assertNotEquals("Table name should be departments!", con,null);
       }
           catch (SQLException|ClassNotFoundException e){
               System.out.println(e.getMessage());
           }
    }

    @Test
    public void testcheckConnectionMethod() throws SQLException, ClassNotFoundException {
        try{
            Connection con= (Connection) DBManager.getConnection();
int a=DBManager.checkConnection(con);
            Assert.assertEquals("Table name should be departments!", 1,a);
        }
        catch (SQLException|ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }


}
