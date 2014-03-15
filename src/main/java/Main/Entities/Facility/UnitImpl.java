package Main.Entities.Facility;

/**
 * User: alexthornburg
 * Date: 2/6/14
 * Time: 1:22 PM
 */

import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUser;

import java.util.ArrayList;
import java.util.List;

public class UnitImpl implements Unit {

    private int capacity;

    private int unitNumber;

    private int id;

    private int facilityId;

    private List<UnitUsage> usages;

    private List<UnitUser> users;

    public UnitImpl(){
        usages = new ArrayList<UnitUsage>();
    }

    @Override
    public int getCapacity(){
        return this.capacity;
    }

    @Override
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    @Override
    public int getId(){
        return id;
    }

    @Override
    public void setId(int id){
        this.id = id;
    }

    @Override
    public List<UnitUsage> getUsages(){
        return usages;
    }

    @Override
    public void setUsages(List<UnitUsage> usages){
        this.usages = usages;
    }

    @Override
    public int getUnitNumber() {
        return unitNumber;
    }

    @Override
    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }
/*
    public List<UnitUser> getUsers(){
        return users;
    }

    public void setUsers(List<UnitUser> users){
        this.users = users;
    }
*/
    @Override
    public int getFacilityId(){
        return facilityId;
    }

    @Override
    public void setFacilityId(int facilityId){
        this.facilityId = facilityId;
    }


    @Override
    public List<UnitUser> getUsers() {
        List<UnitUser> users = new ArrayList<UnitUser>();

        for(UnitUsage usage: usages)
        {
            users.add(usage.getUnitUser());
        }
        return users;
    }


}
