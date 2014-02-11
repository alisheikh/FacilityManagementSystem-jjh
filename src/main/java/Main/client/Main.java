package Main.client;

/**
 * User: alexthornburg
 * Date: 2/4/14
 * Time: 7:17 PM
 */
import Main.BL.FacilityService;
import Main.BL.IFacilityService;
import Main.BL.InspectionService;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
        IFacilityService service = new FacilityService();
        List<Facility> facilities = service.listFacilities();
        printAllFacilities(facilities,resp);
        resp.getWriter().print("--------------Adding Alex's House to Facilities----------------");
        Facility facility = new Facility();
        facility.setBuildingNumber(1226);
        facility.setCapacity(50);
        facility.setID(7);
        facility.setName("Alexs House");
        /**
         * Creating a unit
         */
        Unit unit = new Unit();
        unit.setCapacity(50);
        unit.setRoomNumber(2);
        unit.setFacilityId(7);
        unit.setId(5);
        /**
         * Creating a usage
         */
        UnitUsage sleeping = new UnitUsage();
        sleeping.setId(5);
        sleeping.setStartTime(new DateTime(DateTime.parse("2014-04-09T11:30:00Z")));
        sleeping.setEndTime(new DateTime(DateTime.parse("2014-04-10T8:30:00Z")));
        sleeping.setUnitId(5);
        sleeping.setUserId(5);
        /**
         * Creating a user
         */
        UnitUser sleeper = new UnitUser();
        sleeper.setEmailAddress("alexthornburg1@gmail.com");
        sleeper.setCompanyName("N/A");
        sleeper.setFirstName("Alex");
        sleeper.setLastName("Thornburg");
        sleeper.setCreditCard("5555555");
        sleeper.setID(5);
        sleeper.setPhoneNumber(5266225);
        List<UnitUsage> usages = new ArrayList<UnitUsage>();
        usages.add(sleeping);
        /**
         * adding users and usages to unit
         */
        List<UnitUser> users = new ArrayList<UnitUser>();
        users.add(sleeper);
        unit.setUsage(usages);
        unit.setUsers(users);
        /**
         * adding unit to facility
         */
        List<Unit> units = new ArrayList<Unit>();
        units.add(unit);
        facility.setUnits(units);
        /**
         * add to DB
         */
        service.addNewFacility(facility);
        printFacility(service.getFacilityInformation(7),resp);
        /**
         * Updating with new unit
         */
        System.out.println("-----------------------ADDING NEW UNIT---------------------");
        Unit unit2 = new Unit();
        unit2.setCapacity(20);
        unit2.setRoomNumber(3);
        unit2.setFacilityId(7);
        unit2.setId(6);
        UnitUsage sleeping2 = new UnitUsage();
        sleeping2.setId(6);
        sleeping2.setStartTime(new DateTime(DateTime.parse("2014-04-09T10:30:00Z")));
        sleeping2.setEndTime(new DateTime(DateTime.parse("2014-04-10T7:30:00Z")));
        sleeping2.setUnitId(6);
        sleeping2.setUserId(6);
        UnitUser sleeper2 = new UnitUser();
        sleeper2.setEmailAddress("someotherguy@gmail.com");
        sleeper2.setCompanyName("N/A");
        sleeper2.setFirstName("Roommate");
        sleeper2.setLastName("Guy");
        sleeper2.setCreditCard("513245136");
        sleeper2.setID(6);
        sleeper2.setPhoneNumber(2346245);
        List<UnitUsage> usages2 = new ArrayList<UnitUsage>();
        List<UnitUser> users2 = new ArrayList<UnitUser>();
        usages2.add(sleeping2);
        users2.add(sleeper2);
        unit2.setUsage(usages2);
        unit2.setUsers(users2);
        service.addFacilityDetail(7,unit2);
        Facility update = service.getFacilityInformation(7);
        printFacility(update,resp);


        /**
         * Adding an inspection..
         */
        resp.getWriter().print("----------------------Adding New Inspection-------------------");
        InspectionService insService = new InspectionService();
        List<Inspection> resultInsList = insService.listInspections();
        for(Inspection inspection:resultInsList){
            resp.getWriter().print("ID: "+inspection.getID());
            resp.getWriter().print("TIME: "+inspection.getInspectionDate());
            resp.getWriter().print("Date: "+inspection.getInspectionDate());
            resp.getWriter().print("Facility: "+inspection.getFacility().getName());
        }
        Inspection inspection = new Inspection();
        inspection.setID(5);
        inspection.setInspectingStaffID(50);
        inspection.setInspectionDate(Calendar.getInstance().getTime());
        inspection.setFacility(update);
        insService.addInspection(inspection);
        Inspection resultIns = insService.getInspectionInformation(5);
        resp.getWriter().print("ID: "+resultIns.getID());
        resp.getWriter().print("TIME: "+resultIns.getInspectionDate());
        resp.getWriter().print("Date: "+resultIns.getInspectionDate());
        resp.getWriter().print("Facility: "+resultIns.getFacility().getName());
        insService.removeInspection(inspection);
        service.removeFacility(update);

        resp.getWriter().print("------------------All data removed---------------");
    }

    public static void printAllFacilities(List<Facility> facilities,HttpServletResponse resp) throws IOException {
        for(Facility facility:facilities){
            resp.getWriter().print("Building Num: " + facility.getBuildingNumber());
            resp.getWriter().print("Facility ID: "+facility.getID());
            resp.getWriter().print("Facility Capacity: "+facility.getTotalCapacity());
            for(Unit unit:facility.getUnits()){
                resp.getWriter().print("Unit Capacity: "+unit.getCapacity());
                resp.getWriter().print("Unit ID: "+unit.getId());
                resp.getWriter().print("Room Number: "+unit.getRoomNumber());
                for(UnitUsage usage:unit.getUsage()){
                    resp.getWriter().print("UsageID: "+usage.getId());
                    resp.getWriter().print("Start Time: "+usage.getStartTime());
                    resp.getWriter().print("End Time: "+usage.getEndTime());
                    resp.getWriter().print("UsageID: "+usage.getUnitId());
                    resp.getWriter().print("Usage User ID: "+usage.getUserId());
                }
                for(UnitUser user:unit.getUsers()){
                    resp.getWriter().print("Unit user comp: "+user.getCompanyName());
                    resp.getWriter().print("Unit user cred card: "+user.getCreditCard());
                    resp.getWriter().print("Unit user email: "+user.getEmailAddress());
                    resp.getWriter().print("Unit user first: "+user.getFirstName());
                    resp.getWriter().print("Unit user last: "+user.getLastName());
                    resp.getWriter().print("Unit user id: "+user.getID());
                    resp.getWriter().print("Unit user phone: "+user.getPhoneNumber());
                }
            }
        }
    }

    public static void printFacility(Facility facility,HttpServletResponse resp) throws IOException {
        resp.getWriter().print("Building Num: " + facility.getBuildingNumber());
        resp.getWriter().print("Facility ID: " + facility.getID());
        resp.getWriter().print("Facility Capacity: " + facility.getTotalCapacity());
        for(Unit unit:facility.getUnits()){
            resp.getWriter().print("Unit Capacity: " + unit.getCapacity());
            resp.getWriter().print("Unit ID: " + unit.getId());
            resp.getWriter().print("Room Number: " + unit.getRoomNumber());
            for(UnitUsage usage:unit.getUsage()){
                resp.getWriter().print("UsageID: " + usage.getId());
                resp.getWriter().print("Start Time: " + usage.getStartTime());
                resp.getWriter().print("End Time: " + usage.getEndTime());
                resp.getWriter().print("UsageID: " + usage.getUnitId());
                resp.getWriter().print("Usage User ID: " + usage.getUserId());
            }
            for(UnitUser user:unit.getUsers()){
                resp.getWriter().print("Unit user comp: " + user.getCompanyName());
                resp.getWriter().print("Unit user cred card: " + user.getCreditCard());
                resp.getWriter().print("Unit user email: " + user.getEmailAddress());
                resp.getWriter().print("Unit user first: " + user.getFirstName());
                resp.getWriter().print("Unit user last: " + user.getLastName());
                resp.getWriter().print("Unit user id: " + user.getID());
                resp.getWriter().print("Unit user phone: " + user.getPhoneNumber());
            }
        }
    }


}
