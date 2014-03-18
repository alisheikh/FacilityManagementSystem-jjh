package Main.Entities.Facility;

/**
 * User: alexthornburg
 * Date: 2/6/14
 * Time: 1:22 PM
 */

public class UnitImpl implements Unit {

    private int capacity;

    private int unitNumber;

    private int id;

    private Facility facility;


    @Override
    public Facility getFacility() {
        return facility;
    }

    @Override
    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public int getCapacity(){
        return this.capacity;
    }

    @Override
    public void setCapacity(int capacity) {
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







}
