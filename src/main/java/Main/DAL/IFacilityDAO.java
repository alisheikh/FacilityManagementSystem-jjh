package Main.DAL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IFacilityDAO {
    Facility create(Facility facilty);

    Facility update(Facility facility);

    void delete(int id);

    Facility get(int id);

    //units

    Unit getUnit(int unitID);

    Unit CreateUnitForFacility(int FacilityID, Unit newUnit);

    void DeleteUnit(Unit unit);

    Unit UpdateUnit(Unit unit);


}
