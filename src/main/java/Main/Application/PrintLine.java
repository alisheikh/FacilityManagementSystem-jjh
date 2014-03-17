package Main.Application;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;

import java.io.IOException;
import java.util.List;

/**
 * Created by Jackson on 2/12/14.
 */
public class PrintLine {
    public static void main(String[] args)
    {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");

        IDatabaseConnector connector = new DatabaseConnector();//create bean?

        try{




            System.out.println("----------------begining program---------------");


            //Create DAO objects

            IMaintenanceStaffDAO maintenanceStaffDAO = (IMaintenanceStaffDAO) context.getBean("MaintenanceStaffDAO");
            IUserDAO userDAO =(IUserDAO) context.getBean("UserDAO");
            IUnitDAO unitDAO = (IUnitDAO) context.getBean("UnitDAO");
            IFacilityDAO facilityDAO = (IFacilityDAO) context.getBean("FacilityDAO");
            IMaintenanceRequestDAO maintenanceRequestDAO = (IMaintenanceRequestDAO) context.getBean("MaintenanceRequestDAO");
            IFacilityMaintenanceService facilityMaintenanceService = new FacilityMaintenanceService(facilityDAO,unitDAO,maintenanceRequestDAO,maintenanceStaffDAO);

            IUsageDAO usageDAO = (IUsageDAO) context.getBean("UsageDAO");

            FacilityService facilityService = new FacilityService(connector,facilityDAO, unitDAO);
            IInspectionDAO inspectionDAO = (IInspectionDAO) context.getBean("InspectionDAO");
            FacilityUseService facilityUseService = new FacilityUseService(facilityDAO,unitDAO,inspectionDAO,usageDAO);

            IInspectionService inspectionService = new InspectionService(inspectionDAO, facilityDAO, maintenanceStaffDAO);



            Random r = new Random();

            List<Unit> units = new ArrayList<Unit>();
            System.out.println("initialize test units");

            Unit unit1 = (Unit) context.getBean("Unit");
            unit1.setCapacity(r.nextInt(3));
            unit1.setUnitNumber(111);
            units.add(unit1);

            Unit unit2 =(Unit) context.getBean("Unit");
            unit2.setCapacity(r.nextInt(3));
            unit2.setUnitNumber(r.nextInt(3));
            units.add(unit2);


            Unit unit3 =(Unit) context.getBean("Unit");
            unit3.setCapacity(r.nextInt(3));
            unit3.setUnitNumber(r.nextInt(3));
            units.add(unit3);


            Unit unit4 = (Unit) context.getBean("Unit");
            unit4.setCapacity(r.nextInt(3));
            unit4.setUnitNumber(r.nextInt(3));
            units.add(unit4);


            //Jackson test here TODO:DELETE


            ///

            System.out.print("create facilities objects and add to units to facilities");
            Facility facility1 = (Facility) context.getBean("Facility");
            facility1.setBuildingNumber(r.nextInt(4));
            facility1.setCapacity(50);
            facility1.setName("facility1");
            facility1.setUnits(units);


            Facility facility2 = (Facility) context.getBean("Facility");
            facility2.setBuildingNumber(r.nextInt(4));
            facility2.setCapacity(34);
            facility2.setName("facility2");
            facility2.setUnits(units);

            Facility facility3 = (Facility) context.getBean("Facility");
            facility3.setBuildingNumber(r.nextInt(4));
            facility3.setCapacity(23);
            facility3.setName("facility3");
            facility3.setUnits(units);

            Facility facility =(Facility) context.getBean("Facility");
            facility.setBuildingNumber(r.nextInt(4));
            facility.setCapacity(50);
            facility.setName("facility0");
            facility.setUnits(units);

            System.out.print("add facilities with units to the database");

            facility1 = facilityService.addNewFacility(facility1);
            facility2 = facilityService.addNewFacility(facility2);
            facility3 = facilityService.addNewFacility(facility3);
            facility = facilityService.addNewFacility(facility);

            System.out.print("facilities current facilities in DB:");


            printAllFacilities(facilityService.listFacilities());


            Unit unitForUse =  facility2.getUnits().get(0);
            Unit unitForUse1 =  facility2.getUnits().get(1);
            Unit unitForUse2 =  facility2.getUnits().get(2);

            UnitUser user1 = (UnitUser) context.getBean("UnitUser");
            user1.setCreditCard(String.valueOf(r.nextInt(9)));
            user1.setEmailAddress("j@examle");
            user1.setCompanyName("random company "+ r.nextInt());
            user1.setFirstName("some user" + r.nextInt());//random makes sure these people look different in db
            user1.setLastName("lastName" + r.nextInt());
            user1.setPhoneNumber(r.nextInt(10));

            UnitUser user2 =(UnitUser) context.getBean("UnitUser");
            user2.setCreditCard(String.valueOf(r.nextInt(9)));
            user2.setEmailAddress("j@examle");
            user2.setCompanyName("random company "+ r.nextInt());
            user2.setFirstName("some user" + r.nextInt());//random makes sure these people look different in db
            user2.setLastName("lastName" + r.nextInt());
            user2.setPhoneNumber(r.nextInt(10));

            UnitUser user3 = (UnitUser) context.getBean("UnitUser");
            user3.setCreditCard(String.valueOf(r.nextInt(9)));
            user3.setEmailAddress("j@examle");
            user3.setCompanyName("random company "+ r.nextInt());
            user3.setFirstName("some user" + r.nextInt());//random makes sure these people look different in db
            user3.setLastName("lastName" + r.nextInt());
            user3.setPhoneNumber(r.nextInt(10));


            user1 = userDAO.Create(user1);
            user2 = userDAO.Create(user2);
            user3 = userDAO.Create(user3);


            UnitUsage usage1 = (UnitUsage) context.getBean("UnitUsage");
            usage1.setUnit(unitForUse);
            usage1.setUnitUser(user1);
            usage1.setStartTime(new Date(new DateTime(2014,1,1,1,1).toDate().getTime()));
            usage1.setEndTime(new Date(new DateTime(2014,1,3,1,1).toDate().getTime()));

            UnitUsage usage2 = (UnitUsage) context.getBean("UnitUsage");
            usage2.setUnit(unitForUse1);
            usage2.setUnitUser(user2);
            usage2.setStartTime(new Date(new DateTime(2024,2,2,2,2).toDate().getTime()));
            usage2.setEndTime(new Date(new DateTime(2024,2,3,2,2).toDate().getTime()));

            UnitUsage usage4 =(UnitUsage) context.getBean("UnitUsage");
            usage4.setUnit(unitForUse1);
            usage4.setUnitUser(user3);
            usage4.setStartTime(new Date(new DateTime(2044,4,4,4,4).toDate().getTime()));
            usage4.setEndTime(new Date(new DateTime(2044,4,3,4,4).toDate().getTime()));

            UnitUsage usage3 = (UnitUsage) context.getBean("UnitUsage");
            usage3.setUnit(unitForUse2);
            usage3.setUnitUser(user3);
            usage3.setStartTime(new Date(new DateTime(2034,3,3,3,3).toDate().getTime()));
            usage3.setEndTime(new Date(new DateTime(2034,3,3,3,3).toDate().getTime()));

            Date d1 = new Date(new DateTime(2034,2,3,3,3).toDate().getTime());
            Date d2 = new Date(new DateTime(2034,4,3,3,3).toDate().getTime());
            Date d3 = new Date(new DateTime(2034,5,3,3,3).toDate().getTime());

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





            List<UnitUsage> usagesforunit1 = facilityUseService.listActualUsage(unitForUse.getId());
            List<UnitUsage> usagesforunit2 = facilityUseService.listActualUsage(unitForUse1.getId());
            List<UnitUsage> usagesforunit3 = facilityUseService.listActualUsage(unitForUse2.getId());




            System.out.println("------Print sample Usages Just Created-----------");


            if(usagesforunit1!=null){

                for(UnitUsage uu :usagesforunit1)
                {
                    System.out.println("unit:");
                    System.out.println(uu.getUnit());
                    System.out.println("unit user id");
                    System.out.println(uu.getUnitUser());
                    System.out.println(uu.getStartTime().toString());
                    System.out.println(uu.getEndTime());
                    System.out.println();
                }}

            System.out.println("------Print all usages for -----------");
            List<UnitUsage> usagestopring = facilityUseService.listUsages();
            for (UnitUsage uu:usagestopring)
            {
                System.out.println("unit:");
                System.out.println(uu.getUnit());
                System.out.println("unit user id");
                System.out.println(uu.getUnitUser());
                System.out.println(uu.getStartTime().toString());
                System.out.println(uu.getEndTime());
                System.out.println();

            }

            Facility facilityForMaintenance = facilityDAO.get(facility1.getId());

            MaintenanceStaff staff = (MaintenanceStaff) context.getBean("MaintenanceStaff");
            staff.setHoursPerWeek(34);
            staff.setPayPerHour(23);
            staff.setEmailAddress("j@examle");
            staff.setFirstName("some staff" + r.nextInt());//random makes sure these people look different in db
            staff.setLastName("staffmember" + r.nextInt());
            staff.setPhoneNumber(r.nextInt(100000));
            staff.setFullTime(false);

            staff = maintenanceStaffDAO.create(staff);
            System.out.println("Created Staff Member :"+ staff.getFirstName());
            System.out.println("ID " + staff.getId());


            staff.setPayPerHour(45);
            staff = maintenanceStaffDAO.update(staff);
            System.out.println("And then we gave him a raise to 45 dollars ");


            Date d4 = new Date(new DateTime(2014,6,3,3,3).toDate().getTime());
            Date d5 = new Date(new DateTime(2015,6,3,3,3).toDate().getTime());
            Date foreverFromNow = new Date(new DateTime(2050,6,3,3,3).toDate().getTime());


            System.out.println("Facility "+ facilityForMaintenance.getName());

            System.out.println("Adding maintence requests for facility:" + facilityForMaintenance.getName()+
                    "id:"+facilityForMaintenance.getId());

            for(Unit unit:facilityForMaintenance.getUnits())
            {

                facilityMaintenanceService.makeFacilityMaintRequest(unit.getId(),"I need stuff Fixed");
                facilityMaintenanceService.makeFacilityMaintRequest(unit.getId(),"I need more stuff Fixed ");

            }
            List<MaintenanceRequest> requests = facilityMaintenanceService.listMaintenanceRequests(facilityForMaintenance.getId());


            for(MaintenanceRequest request:requests)
            {
                request = facilityMaintenanceService.scheduleMaintenance(request.getId(),
                        staff.getId(),r.nextInt(6),d4);
            }

            System.out.println("Facility "+ facilityForMaintenance.getName());
            System.out.println("Maintenance Cost: " + facilityMaintenanceService.calcMaintenanceCostForFacility(facilityForMaintenance.getId()));
            System.out.println("Problem Rate: " + facilityMaintenanceService.calcProblemRateForFacility(facilityForMaintenance.getId()));


            System.out.println("add inspections to facility:" + facility1.getName());

            inspectionService.addInspection(facility1.getId(), staff.getId(), d1);
            inspectionService.addInspection(facility1.getId(), staff.getId(), d2);
            inspectionService.addInspection(facility1.getId(), staff.getId(), d3);
            inspectionService.addInspection(facility1.getId(), staff.getId(), d4);

            System.out.println("Inspections Scheduled for"+ facility1.getId());

            List<Inspection> inspections = inspectionService.getInspectionForFacility(facility1.getId());

            for(Inspection inspection:inspections)
            {
                System.out.println("Inspection ID:" + inspection.getId());
                System.out.println("Staff Member Assign ID"+inspection.getInspectingStaff().getId());
                System.out.println("Staff Member Name"+inspection.getInspectingStaff().getFirstName());
                System.out.println("Date :" +inspection.getInspectionDate());


            }








            System.out.print("Delete everything that was created");

            //should be encapsalated in a service later
            maintenanceRequestDAO.delete(staff.getId());
            userDAO.Delete(user1.getId());
            userDAO.Delete(user2.getId());
            userDAO.Delete(user3.getId());


            ////

            Facility testDelete = facilityService.getFacilityInformation(facility1.getId());

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


    public static void printFacility(Facility facility,HttpServletResponse resp) throws IOException {
        System.out.print("Building Num: " + facility.getBuildingNumber()+"\n");
        System.out.print("Facility ID: " + facility.getId()+"\n");
        System.out.print("Facility Capacity: " + facility.getTotalCapacity()+"\n");
        for(Unit unit:facility.getUnits()){
            System.out.print("Unit Capacity: " + unit.getCapacity()+"\n");
            System.out.print("Unit ID: " + unit.getId()+"\n");
            System.out.print("Room Number: " + unit.getUnitNumber()+"\n");

          /* */
        }
    //}

    public static void printAllFacilities(List<Facility> facilities) throws IOException {
        for(Facility facility:facilities){
            System.out.print("Building Num: " + facility.getBuildingNumber()+"\n");
            System.out.print("Facility ID: " + facility.getId()+"\n");
            System.out.print("Facility Capacity: " + facility.getTotalCapacity()+"\n");
            for(Unit unit:facility.getUnits()){
                System.out.print("Unit Capacity: " + unit.getCapacity()+"\n");
                System.out.print("Unit ID: " + unit.getId()+"\n");
                System.out.print("Room Number: " + unit.getUnitNumber()+"\n");


            }

        }
    }
}