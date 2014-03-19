package Main.Entities.Facility;

/**
 * Created by Jackson on 3/13/14.
 */
public interface Unit {

    int getCapacity();

    void setCapacity(int capacity);

    int getUnitId();

    void setUnitId(int id);

    int getUnitNumber();

    void setUnitNumber(int unitNumber);

    Facility getFacility();

    void setFacility(Facility facility);
}
