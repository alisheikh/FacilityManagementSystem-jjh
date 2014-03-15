package Main.Entities.Facility;

/**
 * User: alexthornburg
 * Date: 2/6/14
 * Time: 1:22 PM
 */

import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUsageImpl;
import Main.Entities.usage.UnitUser;

import java.util.ArrayList;
import java.util.List;

public class UnitImpl implements Unit {

    private int capacity;

    private int unitNumber;

    private int id;

    private int facilityId;

    public UnitImpl(){
       //usages = new ArrayList<UnitUsageImpl>();
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
    public int getUnitNumber() {
        return unitNumber;
    }

    @Override
    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }
    @Override
    public int getFacilityId(){
        return facilityId;
    }

    @Override
    public void setFacilityId(int facilityId){
        this.facilityId = facilityId;
    }




}
