package Main.Entities.Facility;

import java.util.List;

public class FacilityImpl implements Facility {

	private int facilityId;

    private String name;

    private List<Unit> units;

	private int buildingNumber;

	private int capacity;

    public FacilityImpl(){
        setFacilityId(-1);
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public List<Unit> getUnits(){
        return this.units;
    }

    @Override
    public void setUnits(List<Unit> units){

        this.units = units;
    }

    @Override
    public int getFacilityId() {
        return facilityId;
    }

    @Override
    public void setFacilityId(int id) {
        this.facilityId = id;
    }

    @Override
    public int getBuildingNumber() {
        return buildingNumber;
    }


    @Override
    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Override
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    @Override
    public int getCapacity(){
        return capacity;
    }

    @Override
    public int getTotalCapacity() {
        int cap = 0;
        if(units != null && !units.isEmpty() && units.size() > 0)
        for (Unit unit:units){
           cap += unit.getCapacity();
        }
        return cap+capacity;
    }


}
