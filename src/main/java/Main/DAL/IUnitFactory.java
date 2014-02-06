package Main.DAL;

import Main.Entities.Unit;

import java.util.List;

/**
 * Created by john on 2/6/14.
 */
public interface IUnitFactory {
    Unit Create(Unit unit);

    void Delete(int unitID);

    Unit Get(int ID);

    Unit Update(Unit unit);

    List<Unit> GetByFacilityID(int facilityID);
}
