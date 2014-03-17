package Main.Application;

import Main.BL.FacilityService;
import Main.Entities.Facility.Facility;
import Main.Entities.Facility.FacilityImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");
        FacilityImpl facility = (FacilityImpl) context.getBean("Facility");
        System.out.println(facility.getName());
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
