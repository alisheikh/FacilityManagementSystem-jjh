package Main.Application;

import Main.BL.FacilityService;
import Main.Entities.Facility.Facility;
import Main.Entities.Facility.FacilityImpl;
import Main.Entities.Facility.Unit;
import Main.Entities.Facility.UnitImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: alexthornburg
 * Date: 3/17/14
 * Time: 10:58 AM
 */
public class TestFacility /*extends HttpServlet*/ {
    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        printTest(resp);
    } */

    public static void main(String[] args) /*throws Exception*/{
        /*Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new Main()),"/*");
        server.start();
        server.join();*/
        Random r = new Random();
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");
        FacilityService service = (FacilityService) context.getBean("facilityService");
        List<Unit> units = new ArrayList<Unit>();

        Unit unit1 = new UnitImpl();
        unit1.setCapacity(r.nextInt(3));
        unit1.setUnitNumber(111);
        units.add(unit1);

        Unit unit2 = new UnitImpl();
        unit2.setCapacity(r.nextInt(3));
        unit2.setUnitNumber(r.nextInt(3));
        units.add(unit2);


        Unit unit3 = new UnitImpl();
        unit3.setCapacity(r.nextInt(3));
        unit3.setUnitNumber(r.nextInt(3));
        units.add(unit3);


        Unit unit4 = new UnitImpl();
        unit4.setCapacity(r.nextInt(3));
        unit4.setUnitNumber(r.nextInt(3));
        units.add(unit4);
        Facility facility1 = new FacilityImpl();
        facility1.setBuildingNumber(r.nextInt(4));
        facility1.setCapacity(50);
        facility1.setName("facility1");
        facility1.setUnits(units);
        service.addNewFacility(facility1);
        List<Facility> list = service.listFacilities();
        for(Facility facility:list){
            System.out.println(facility.getName());
        }
        printTest();
    }

    public static void printTest(/*HttpServletResponse resp*/) /*throws IOException*/ {
        FacilityService service = new FacilityService();
        List<Facility> facilities = service.listFacilities();
        for(Facility facility:facilities){
            System.out.println(facility.getName());
        }
    }
}
