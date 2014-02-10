package Test.DAL;

import Main.BL.FacilityService;
import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;
import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUser;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: alexthornburg
 * Date: 2/9/14
 * Time: 9:36 PM
 */
public class FacilityService_Test {

    FacilityService service;
    Facility facility;

    public FacilityService_Test(){
        facility = new Facility();
        service = new FacilityService();
    }


    @Test
    public void testCreateGet(){
        System.out.println("--------------Adding Alex's House to Facilities----------------");
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
        Facility test = service.getFacilityInformation(7);
        Assert.assertEquals(test.getID(),facility.getID());
        Assert.assertEquals(test.getBuildingNumber(),facility.getBuildingNumber());
        Assert.assertEquals(test.getName(),facility.getName());
        List<Unit> unitsTest = facility.getUnits();
        for(int i=0;i<unitsTest.size();i++){
            Assert.assertEquals(test.getUnits().get(i).getCapacity(),unitsTest.get(i).getCapacity());
            Assert.assertEquals(test.getUnits().get(i).getFacilityId(),unitsTest.get(i).getFacilityId());
            Assert.assertEquals(test.getUnits().get(i).getId(),unitsTest.get(i).getId());
            Assert.assertEquals(test.getUnits().get(i).getRoomNumber(),unitsTest.get(i).getRoomNumber());
            List<UnitUsage>usagesTest = test.getUnits().get(i).getUsage();
            for(int j=0;j<usagesTest.size();j++){
                Assert.assertEquals(usagesTest.get(j).getId(),test.getUnits().get(i).getUsage().get(i).getId());
                Assert.assertEquals(usagesTest.get(j).getUnitId(),test.getUnits().get(i).getUsage().get(j).getUnitId());
                Assert.assertEquals(usagesTest.get(j).getUserId(),test.getUnits().get(i).getUsage().get(j).getUserId());
                Assert.assertEquals(usagesTest.get(j).getEndTime(),test.getUnits().get(i).getUsage().get(j).getEndTime());
                Assert.assertEquals(usagesTest.get(j).getStartTime(),test.getUnits().get(i).getUsage().get(j).getStartTime());
            }
            List<UnitUser>userTest = test.getUnits().get(i).getUsers();
            for(int k=0;k<userTest.size();k++){
                Assert.assertEquals(userTest.get(k).getCompanyName(),test.getUnits().get(i).getUsers().get(i).getCompanyName());
                Assert.assertEquals(userTest.get(k).getCreditCard(),test.getUnits().get(i).getUsers().get(k).getCreditCard());
                Assert.assertEquals(userTest.get(k).getUnitUserId(),test.getUnits().get(i).getUsers().get(k).getUnitUserId());
                Assert.assertEquals(userTest.get(k).getEmailAddress(),test.getUnits().get(i).getUsers().get(k).getEmailAddress());
                Assert.assertEquals(userTest.get(k).getFirstName(),test.getUnits().get(i).getUsers().get(k).getFirstName());
                Assert.assertEquals(userTest.get(k).getLastName(),test.getUnits().get(i).getUsers().get(k).getLastName());
                Assert.assertEquals(userTest.get(k).getID(),test.getUnits().get(i).getUsers().get(k).getID());
                Assert.assertEquals(userTest.get(k).getPhoneNumber(),test.getUnits().get(i).getUsers().get(k).getPhoneNumber());

            }
        }

    }

    @Test
    public void addUnitAndUpdate(){
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
        List<Unit> unitTest = facility.getUnits();
        service.addFacilityDetail(7,unit2);
        Facility update = service.getFacilityInformation(7);
            Assert.assertEquals(unit2.getCapacity(),update.getUnits().get(1).getCapacity());
            Assert.assertEquals(unit2.getId(),update.getUnits().get(1).getId());
            Assert.assertEquals(unit2.getFacilityId(),update.getUnits().get(1).getFacilityId());
            Assert.assertEquals(unit2.getRoomNumber(),update.getUnits().get(1).getRoomNumber());
            List<UnitUsage> usageTest = unit2.getUsage();
            for(int j=0;j<usageTest.size()-1;j++){
                Assert.assertEquals(usageTest.get(j).getId(),update.getUnits().get(1).getUsage().get(j).getId());
                Assert.assertEquals(usageTest.get(j).getEndTime(),update.getUnits().get(1).getUsage().get(j).getEndTime());
                Assert.assertEquals(usageTest.get(j).getStartTime(),update.getUnits().get(1).getUsage().get(j).getStartTime());
                Assert.assertEquals(usageTest.get(j).getUserId(),update.getUnits().get(1).getUsage().get(j).getUserId());
                Assert.assertEquals(usageTest.get(j).getUnitId(),update.getUnits().get(1).getUsage().get(j).getUnitId());
            }
            List<UnitUser> userTest = unit2.getUsers();
            for(int k=0;k<userTest.size()-1;k++){
                Assert.assertEquals(userTest.get(k).getUnitUserId(),update.getUnits().get(1).getUsers().get(k).getUnitUserId());
                Assert.assertEquals(userTest.get(k).getPhoneNumber(),update.getUnits().get(1).getUsers().get(k).getPhoneNumber());
                Assert.assertEquals(userTest.get(k).getCreditCard(),update.getUnits().get(1).getUsers().get(k).getCreditCard());
                Assert.assertEquals(userTest.get(k).getID(),update.getUnits().get(1).getUsers().get(k).getID());
                Assert.assertEquals(userTest.get(k).getEmailAddress(),update.getUnits().get(1).getUsers().get(k).getEmailAddress());
                Assert.assertEquals(userTest.get(k).getCompanyName(),update.getUnits().get(1).getUsers().get(k).getCompanyName());
                Assert.assertEquals(userTest.get(k).getFirstName(),update.getUnits().get(1).getUsers().get(k).getFirstName());
                Assert.assertEquals(userTest.get(k).getLastName(),update.getUnits().get(1).getUsers().get(k).getLastName());

            }
        }


    @Test
    public void testDelete(){
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
        service.removeFacility(facility);
        Facility facility = service.getFacilityInformation(7);
        Assert.assertEquals(0,facility.getBuildingNumber());
        Assert.assertEquals(null,facility.getUnits());
        Assert.assertEquals(0,facility.getID());
        Assert.assertEquals(0,facility.getCapacity());
        Assert.assertEquals(null,facility.getName());
    }
}
