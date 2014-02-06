package Main.DAL;

import Main.Entities.UnitUsage;

import java.util.List;

/**
 * Created by john on 2/5/14.
 */
public interface IUnitUsegaeFactory {
    UnitUsage Create(UnitUsage unitUsage);

    UnitUsage Update(UnitUsage unitUsage);

    void DeleteFacility(int ID);

    UnitUsage Get(int ID);

    List<UnitUsage> GetByUnitID(int unitID);
}
