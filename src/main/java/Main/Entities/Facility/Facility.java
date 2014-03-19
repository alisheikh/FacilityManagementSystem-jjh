package Main.Entities.Facility;

import java.util.List;

/**
 * Created by Jackson on 3/13/14.
 */
public interface Facility {

    String getName();

    void setName(String name);

    List<Unit> getUnits();

    void setUnits(List<Unit> unit);

    int getFacilityId();

    void setFacilityId(int id);

    int getBuildingNumber();

    void setBuildingNumber(int buildingNumber);

    void setCapacity(int capacity);

    int getCapacity();

    int getTotalCapacity();
}
