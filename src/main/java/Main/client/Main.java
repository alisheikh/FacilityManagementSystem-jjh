package Main.client;

/**
 * User: alexthornburg
 * Date: 2/4/14
 * Time: 7:17 PM
 */
import Main.BL.FacilityService;
import Main.BL.IFacilityService;
import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;
import Main.Entities.maintenance.Inspection;
import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUser;
import org.joda.time.DateTime;
import Main.BL.InspectionService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
public class Main {
    public static void main(String[] args){

       IFacilityService service = new FacilityService();
       List<Facility> facilities = service.listFacilities();
       printAllFacilities(facilities);
       System.out.println("--------------Adding Alex's House to Facilities----------------");
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
       printFacility(service.getFacilityInformation(7));
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
        printFacility(update);


        /**
         * Adding an inspection..
         */
        System.out.println("----------------------Adding New Inspection-------------------");
        InspectionService insService = new InspectionService();
        List<Inspection> resultInsList = insService.listInspections();
        for(Inspection inspection:resultInsList){
            System.out.println("ID: "+inspection.getID());
            System.out.println("TIME: "+inspection.getInspectionDate());
            System.out.println("Date: "+inspection.getInspectionDate());
            System.out.println("Facility: "+inspection.getFacility().getName());
        }
        Inspection inspection = new Inspection();
        inspection.setID(5);
        inspection.setInspectingStaffID(50);
        inspection.setInspectionDate(Calendar.getInstance().getTime());
        inspection.setFacility(update);
        insService.addInspection(inspection);
        Inspection resultIns = insService.getInspectionInformation(5);
        System.out.println("ID: "+resultIns.getID());
        System.out.println("TIME: "+resultIns.getInspectionDate());
        System.out.println("Date: "+resultIns.getInspectionDate());
        System.out.println("Facility: "+resultIns.getFacility().getName());
        insService.removeInspection(inspection);
        service.removeFacility(update);

        System.out.println("------------------All data removed---------------");


    }

    public static void printAllFacilities(List<Facility> facilities){
        for(Facility facility:facilities){
            System.out.println("Building Num: "+facility.getBuildingNumber());
            System.out.println("Facility ID: "+facility.getID());
            System.out.println("Facility Capacity: "+facility.getTotalCapacity());
            for(Unit unit:facility.getUnits()){
                System.out.println("Unit Capacity: "+unit.getCapacity());
                System.out.println("Unit ID: "+unit.getId());
                System.out.println("Room Number: "+unit.getRoomNumber());
                for(UnitUsage usage:unit.getUsage()){
                    System.out.println("UsageID: "+usage.getId());
                    System.out.println("Start Time: "+usage.getStartTime());
                    System.out.println("End Time: "+usage.getEndTime());
                    System.out.println("UsageID: "+usage.getUnitId());
                    System.out.println("Usage User ID: "+usage.getUserId());
                }
                for(UnitUser user:unit.getUsers()){
                    System.out.println("Unit user comp: "+user.getCompanyName());
                    System.out.println("Unit user cred card: "+user.getCreditCard());
                    System.out.println("Unit user email: "+user.getEmailAddress());
                    System.out.println("Unit user first: "+user.getFirstName());
                    System.out.println("Unit user last: "+user.getLastName());
                    System.out.println("Unit user id: "+user.getID());
                    System.out.println("Unit user phone: "+user.getPhoneNumber());
                }
            }
        }
    }

    public static void printFacility(Facility facility){
        System.out.println("Building Num: "+facility.getBuildingNumber());
        System.out.println("Facility ID: "+facility.getID());
        System.out.println("Facility Capacity: "+facility.getTotalCapacity());
        for(Unit unit:facility.getUnits()){
            System.out.println("Unit Capacity: "+unit.getCapacity());
            System.out.println("Unit ID: "+unit.getId());
            System.out.println("Room Number: "+unit.getRoomNumber());
            for(UnitUsage usage:unit.getUsage()){
                System.out.println("UsageID: "+usage.getId());
                System.out.println("Start Time: "+usage.getStartTime());
                System.out.println("End Time: "+usage.getEndTime());
                System.out.println("UsageID: "+usage.getUnitId());
                System.out.println("Usage User ID: "+usage.getUserId());
            }
            for(UnitUser user:unit.getUsers()){
                System.out.println("Unit user comp: "+user.getCompanyName());
                System.out.println("Unit user cred card: "+user.getCreditCard());
                System.out.println("Unit user email: "+user.getEmailAddress());
                System.out.println("Unit user first: "+user.getFirstName());
                System.out.println("Unit user last: "+user.getLastName());
                System.out.println("Unit user id: "+user.getID());
                System.out.println("Unit user phone: "+user.getPhoneNumber());
            }
        }
    }


}
