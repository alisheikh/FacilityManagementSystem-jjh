package Main.Entities.Facility;

import java.util.List;

public class Facility {

	private String id;

    private List<Unit> units;

	private int buildingNumber;

	private int capacity;

	public Facility() {

	}

    public List<Unit> getUnits(){
        return this.units;
    }

    public void setUnits(List<Unit> unit){
        this.units = unit;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }


    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getTotalCapacity() {
        int cap = 0;
        for (Unit unit:units){
           cap += unit.getCapacity();
        }
        return cap;
    }


}
