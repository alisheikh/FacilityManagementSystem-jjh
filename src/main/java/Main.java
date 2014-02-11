/**
 * User: alexthornburg
 * Date: 2/4/14
 * Time: 7:17 PM
 */
import Main.BL.FacilityService;
import Main.BL.FacilityUseService;
import Main.BL.IFacilityService;
import Main.BL.InspectionService;
import Main.DAL.*;
import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;
import Main.Entities.maintenance.Inspection;
import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUser;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        printTest(resp);
    }

    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new Main()),"/*");
        server.start();
        server.join();
    }

    public void printTest(HttpServletResponse resp) throws IOException {

        IDatabaseConnector connector = new DatabaseConnector();

        try{

            resp.getWriter().print("begining program");
            IMaintenanceStaffDAO maintenanceStaffDAO = new MaintenanceStaffDAO(connector);
            IUserDAO userDAO = new UserDAO(connector);
            IUnitDAO unitDAO = new UnitDAO(userDAO, connector);
            IFacilityDAO facilityDAO = new FacilityDAO(connector,unitDAO);
            IMaintenanceRequestDAO maintenanceRequestDAO = new MaintenanceRequestDAO(connector,facilityDAO,maintenanceStaffDAO);

            IUsageDAO usageDAO = new UsageDAO(connector, unitDAO, userDAO);

            FacilityService facilityService = new FacilityService(connector,facilityDAO, unitDAO);
            IInspectionDAO inpectionDAO = new InspectionDAO(connector, facilityService);
            FacilityUseService facilityUseService = new FacilityUseService(facilityDAO,unitDAO,inpectionDAO,usageDAO);

            Random r = new Random();

            List<Unit> units = new ArrayList<Unit>();

            Unit unit1 = new Unit();
            unit1.setCapacity(r.nextInt(3));
            unit1.setUnitNumber(111);
            units.add(unit1);

            Unit unit2 = new Unit();
            unit2.setCapacity(r.nextInt(3));
            unit2.setUnitNumber(r.nextInt(3));
            units.add(unit2);


            Unit unit3 = new Unit();
            unit3.setCapacity(r.nextInt(3));
            unit3.setUnitNumber(r.nextInt(3));
            units.add(unit3);


            Unit unit4 = new Unit();
            unit4.setCapacity(r.nextInt(3));
            unit4.setUnitNumber(r.nextInt(3));
            units.add(unit4);

            Facility facility1 = new Facility();
            facility1.setBuildingNumber(r.nextInt(4));
            facility1.setCapacity(50);
            facility1.setName("facility1");
            facility1.setUnits(units);


            Facility facility2 = new Facility();
            facility2.setBuildingNumber(r.nextInt(4));
            facility2.setCapacity(34);
            facility2.setName("facility2");
            facility2.setUnits(units);

            Facility facility3 = new Facility();
            facility3.setBuildingNumber(r.nextInt(4));
            facility3.setCapacity(23);
            facility3.setName("facility3");
            facility3.setUnits(units);

            Facility facility = new Facility();
            facility.setBuildingNumber(r.nextInt(4));
            facility.setCapacity(50);
            facility.setName("facility0");
            facility.setUnits(units);

            facility1 = facilityService.addNewFacility(facility1);
            facility2 = facilityService.addNewFacility(facility2);
            facility3 = facilityService.addNewFacility(facility3);
            facility = facilityService.addNewFacility(facility);

            try{

                Unit unitForUse =  facility2.getUnits().get(1);
                Unit unitForUse1 =  facility2.getUnits().get(2);
                Unit unitForUse2 =  facility2.getUnits().get(1);

                UnitUser user1 = new UnitUser();
                user1.setCreditCard(String.valueOf(r.nextInt(9)));
                user1.setEmailAddress("j@examle");
                user1.setCompanyName("random company "+ r.nextInt());
                user1.setFirstName("some user" + r.nextInt());//random makes sure these people look different in db
                user1.setLastName("lastName" + r.nextInt());
                user1.setPhoneNumber(r.nextInt(10));

                UnitUser user2 = new UnitUser();
                user2.setCreditCard(String.valueOf(r.nextInt(9)));
                user2.setEmailAddress("j@examle");
                user2.setCompanyName("random company "+ r.nextInt());
                user2.setFirstName("some user" + r.nextInt());//random makes sure these people look different in db
                user2.setLastName("lastName" + r.nextInt());
                user2.setPhoneNumber(r.nextInt(10));

                UnitUser user3 = new UnitUser();
                user3.setCreditCard(String.valueOf(r.nextInt(9)));
                user3.setEmailAddress("j@examle");
                user3.setCompanyName("random company "+ r.nextInt());
                user3.setFirstName("some user" + r.nextInt());//random makes sure these people look different in db
                user3.setLastName("lastName" + r.nextInt());
                user3.setPhoneNumber(r.nextInt(10));


                user1 = userDAO.Create(user1);
                user2 = userDAO.Create(user2);
                user3 = userDAO.Create(user3);


                UnitUsage usage1 = new UnitUsage();
                usage1.setUnit(unitForUse);
                usage1.setUnitUser(user1);
                usage1.setStartTime(new Date(new DateTime(2014,1,1,1,1).toDate().getTime()));
                usage1.setEndTime(new Date(new DateTime(2014,1,3,1,1).toDate().getTime()));

                UnitUsage usage2 = new UnitUsage();
                usage2.setUnit(unitForUse1);
                usage2.setUnitUser(user2);
                usage2.setStartTime(new Date(new DateTime(2024,2,2,2,2).toDate().getTime()));
                usage2.setEndTime(new Date(new DateTime(2024,2,3,2,2).toDate().getTime()));

                UnitUsage usage4 = new UnitUsage();
                usage4.setUnit(unitForUse1);
                usage4.setUnitUser(user3);
                usage4.setStartTime(new Date(new DateTime(2044,4,4,4,4).toDate().getTime()));
                usage4.setEndTime(new Date(new DateTime(2044,4,3,4,4).toDate().getTime()));

                UnitUsage usage3 = new UnitUsage();
                usage3.setUnit(unitForUse2);
                usage3.setUnitUser(user3);
                usage3.setStartTime(new Date(new DateTime(2034,3,3,3,3).toDate().getTime()));
                usage3.setEndTime(new Date(new DateTime(2034,3,3,3,3).toDate().getTime()));

                Date d1 = new Date(new DateTime(2034,3,3,3,3).toDate().getTime());
                Date d2 = new Date(new DateTime(2034,3,3,3,3).toDate().getTime());
                Date d3 = new Date(new DateTime(2034,3,3,3,3).toDate().getTime());
                Date d4 = new Date(new DateTime(2034,3,3,3,3).toDate().getTime());

                if(!facilityUseService.IsInUseDuringInterval(unitForUse.getId(),d1,d2))
                {
                    facilityUseService.assignFacilityToUse(d1,d2, user1,unitForUse);
                }

                if(!facilityUseService.IsInUseDuringInterval(unitForUse1.getId(),d2,d3))
                {
                    facilityUseService.assignFacilityToUse(d1,d2, user1,unitForUse1);
                }
                if(!facilityUseService.IsInUseDuringInterval(unitForUse2.getId(),d1,d3))
                {
                    facilityUseService.assignFacilityToUse(d1,d2, user1,unitForUse2);
                }

                if(!facilityUseService.IsInUseDuringInterval(unitForUse.getId(),d1,d2))
                {
                    facilityUseService.assignFacilityToUse(d1,d2, user1,unitForUse);
                }



            }
            catch(NullPointerException e)
            {
                e.printStackTrace();

            }

            List<UnitUsage> usagesforunit1 = facilityUseService.listActualUsage(unit1.getId());
            List<UnitUsage> usagesforunit2 = facilityUseService.listActualUsage(unit2.getId());
            List<UnitUsage> usagesforunit3 = facilityUseService.listActualUsage(unit3.getId());
            List<UnitUsage> usagesforunit4 = facilityUseService.listActualUsage(unit4.getId());







            resp.getWriter().print("Delete everything that was created");

            Facility testDelete = facilityService.getFacilityInformation(facility1.getID());

            List<Unit> unitsfordelte = testDelete.getUnits();
            for(Unit u: unitsfordelte)
            {
                facilityService.RemoveUnit(u);
            }//tests deletion of individual units.


            facilityService.removeFacility(facility);//delete facility and cascades all units and usages
            facilityService.removeFacility(facility1);
            facilityService.removeFacility(facility2);
            facilityService.removeFacility(facility3);
            facilityService.removeFacility(facility);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

}
