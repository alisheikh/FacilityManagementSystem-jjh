package Main.Entities.Facility;

import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUser;

import java.util.List;

/**
 * Created by Jackson on 3/13/14.
 */
public interface Unit {
    int getCapacity();

    void setCapacity(int capacity);

    int getId();

    void setId(int id);

    int getUnitNumber();

    void setUnitNumber(int unitNumber);

    int getFacilityId();

    void setFacilityId(int facilityId);
}
