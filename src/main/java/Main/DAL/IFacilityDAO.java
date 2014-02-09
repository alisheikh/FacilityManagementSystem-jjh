package Main.DAL;

import Main.Entities.Facility.Facility;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IFacilityDAO {
    FacilityDAO create(Facility facilty);

    FacilityDAO update(Facility facility);

    void delete(int id);

    Facility get(int id);
}
