package ro.teamnet.zth.api.em.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.api.em.EntityUtils;
import ro.teamnet.zth.appl.domain.Department;

import static org.junit.Assert.assertEquals;

/**
 * Created by Adrian.Calancea on 7/10/16.
 */
public class EntityManagerImplTest {

    EntityManagerImpl t=new EntityManagerImpl();
    @Test
    public void testFindALLMethod() {


        Assert.assertNotEquals("List should be not null", null,t.findAll(Department.class));
    }
    @Test
    public void testFindbyIDMethod() {
        //EntityManagerImpl t=new EntityManagerImpl();

        Assert.assertEquals("List should be null", "Department{id=null, departmentName='null', locations=null}",t.findById(Department.class,new Long(-2)).toString());
    }
    @Test
    public void testNExtIDMethod() {


        Assert.assertTrue(t.getNextIdVal("departments","DEPARTMENT_ID")>=31);
    }
    @Test
    public void testInsertMethod() {
Department a=new Department();
        a.setDepartmentName("Acasa");
        a.setLocations(1000);
        Assert.assertNotEquals("List should be not null", null,t.insert(a));
    }


}
