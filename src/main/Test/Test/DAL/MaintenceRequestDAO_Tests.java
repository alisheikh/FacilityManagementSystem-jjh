package Test.DAL;

import Main.DAL.*;
import Main.Entities.Facility.Unit;
import Main.Entities.maintenance.MaintenanceRequest;
import Main.Entities.maintenance.MaintenanceStaff;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.print.resources.serviceui_zh_TW;
import sun.tools.jar.resources.jar;


import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by Jackson on 2/8/14.
 */
public class MaintenceRequestDAO_Tests {

        private MaintenanceRequest newRequest;
        private IMaintenanceRequestDAO maintenanceRequestDAO;

        @Before
        public void setup ()
        {
            java.util.Date dd = new java.util.Date();//does this set it to now?
            java.sql.Date d = new java.sql.Date(dd.getTime());


            maintenanceRequestDAO = new MaintenanceRequestDAO(new DatabaseConnector());
            newRequest = new MaintenanceRequest();
            newRequest.setRequest("REQUEST REQUEST will the real slim shady please stand up");
            newRequest.setDateRequested(d);
            MaintenanceStaff s = new MaintenanceStaff();
            s.setID(1);
            newRequest.setStaffMemberAssigned(s);
            Unit u = new Unit();
            u.setId(1);
            newRequest.setUnit(u);
            newRequest.setCompletionDate(d);

        }
        @After
        public void teardown()
        {
            newRequest = null;
            maintenanceRequestDAO = null;

        }

        @Test
        public void test_Create()
        {

            MaintenanceRequest returnedRequest = maintenanceRequestDAO.create(newRequest);

            //assert

            //clean up


        }

        @Test
        public void test_get()
        {

            //setup
            MaintenanceRequest mr=null;
            try {
                mr = maintenanceRequestDAO.get(1);
            }
            catch (Exception e) {
                e.printStackTrace();
                Assert.fail("ERROR");

            }
            Assert.assertNotNull(mr);
           //other asserts necesarry
        }

        @Test
        public void test_delete()
        {
            //setup


            //execute
            maintenanceRequestDAO.delete(1);


            //assert
            try{
                maintenanceRequestDAO.get(1);
            }
            catch(Exception e)//change to sqlexception
            {
                return;
            }
            Assert.fail("item wasn't deleted");
        }

    }
