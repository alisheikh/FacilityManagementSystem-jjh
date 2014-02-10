package Test.DAL;

import Main.DAL.DatabaseConnector;
import Main.DAL.IMaintenanceStaffDAO;
import Main.DAL.MaintenanceStaffDAO;
import Main.Entities.maintenance.MaintenanceStaff;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;


/**
 * Created by Jackson on 2/8/14.
 */
public class MaintenanceStaffDAO_Tests {


    private MaintenanceStaff newStaff;
    private IMaintenanceStaffDAO maintenanceStaffDAO;


    public MaintenanceStaffDAO_Tests() {

        maintenanceStaffDAO = new MaintenanceStaffDAO(new DatabaseConnector());
    }

    @Before
    public void setup ()
    {

        newStaff = new MaintenanceStaff();
        newStaff.setFullTime(false);
        newStaff.setHoursPerWeek(35);
        newStaff.setFirstName("jackson");
        newStaff.setLastName("hayes");
        newStaff.setEmailAddress("jackson@jackson.com");
        newStaff.setPayPerHour(12.12);
        newStaff.setPhoneNumber(1234567);

    }
    @After
    public void teardown()
    {

        maintenanceStaffDAO = null;
    }

    @Test
    public void test_Create()
    {

        MaintenanceStaff returnedStaff = maintenanceStaffDAO.create(newStaff);

        Assert.assertEquals("First Name", newStaff.getFirstName(), returnedStaff.getFirstName());
        Assert.assertEquals("Last Name", newStaff.getLastName(), returnedStaff.getLastName());
        Assert.assertEquals("Phone Number", newStaff.getPhoneNumber(), returnedStaff.getPhoneNumber());
        Assert.assertEquals("Email Address", newStaff.getEmailAddress(), returnedStaff.getEmailAddress());
        Assert.assertEquals("Pay Per Hour", newStaff.getPayPerHour(), returnedStaff.getPayPerHour(), 0.0);

        //clean up

        maintenanceStaffDAO.delete(returnedStaff.getID());
    }

    @Test
    public void test_get()
    {

        //setup
        MaintenanceStaff ms = null;
        try {
            ms = maintenanceStaffDAO.get(50);
        }
        catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("ERROR");

        }
        Assert.assertNotNull(ms);
        Assert.assertNotNull(ms.getFirstName());
        Assert.assertNotNull(ms.getLastName());
        Assert.assertTrue(ms.getID()!=0);
    }

    @Test
    public void test_delete()
    {
        //setup
        MaintenanceStaff sm = maintenanceStaffDAO.create(newStaff);

        //execute
        maintenanceStaffDAO.delete(sm.getID());


        //assert
        try{
        maintenanceStaffDAO.get(sm.getID());
        }
        catch(SQLException e)
        {
            return;
        }
        Assert.fail("item wasn't deleted");

    }

}