package Main.DAL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IFacilityDAO {
    Facility create(Facility facilty);

    Facility update(Facility facility);

    void delete(Facility facility);

    Facility get(int id);

    Unit getUnit(int unitId);


}
