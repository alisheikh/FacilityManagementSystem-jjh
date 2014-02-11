package Test.DAL;

import Main.DAL.*;
import Main.Entities.Facility.Unit;
import Main.Entities.maintenance.MaintenanceRequest;
import Main.Entities.maintenance.MaintenanceStaff;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Jackson on 2/8/14.
 */
public class MaintenceRequestDAO_Tests {

        private MaintenanceRequest newRequest;
        private IMaintenanceRequestDAO maintenanceRequestDAO;

    public MaintenceRequestDAO_Tests()
    {
        maintenanceRequestDAO = new MaintenanceRequestDAO(
                new FacilityDAO(),
                new MaintenanceStaffDAO());//UGLY
    }



    @Before
        public void setup ()
        {
            java.util.Date dd = new java.util.Date();//does this set it to now?
            java.sql.Date d = new java.sql.Date(dd.getTime());




            newRequest = new MaintenanceRequest();
            newRequest.setRequest("REQUEST REQUEST will the real slim shady please stand up");
            newRequest.setDateRequested(d);
            MaintenanceStaff s = new MaintenanceStaff();
            s.setID(50);
            newRequest.setStaffMemberAssigned(s);
            Unit u = new Unit();
            u.setId(50);
            newRequest.setUnit(u);
            newRequest.setCompletionDate(d);

        }
        @After
        public void teardown()
        {
            newRequest = null;


        }

        @Test
        public void test_Create()
        {

            MaintenanceRequest returnedRequest = maintenanceRequestDAO.create(newRequest);

            //assert
            Assert.assertNotNull(returnedRequest);
            //clean up
            maintenanceRequestDAO.delete(newRequest.getID());

        }

        @Test
        public void test_get()
        {

            //setup

            newRequest = maintenanceRequestDAO.create(newRequest);

            MaintenanceRequest mr = new MaintenanceRequest();
            try {
                mr = maintenanceRequestDAO.get(newRequest.getID());
            }
            catch (Exception e) {
                e.printStackTrace();
                Assert.fail("ERROR");

            }
            Assert.assertNotNull(mr);
           //other asserts necesarry
            maintenanceRequestDAO.delete(newRequest.getID());
        }

        @Test
        public void test_delete()
        {
            //setup
            maintenanceRequestDAO.create(newRequest);

            //execute
            maintenanceRequestDAO.delete(50);


            //assert
            try{
                maintenanceRequestDAO.get(50);
            }
            catch(Exception e)//change to sqlexception
            {
                return;
            }
            Assert.fail("item wasn't deleted");
        }

    }
