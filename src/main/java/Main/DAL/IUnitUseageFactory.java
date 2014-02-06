package Main.DAL;

import Main.Entities.UnitUsage;

import java.util.List;

/**
 * Created by john on 2/5/14.
 */
public interface IUnitUseageFactory {
    UnitUsage Create(UnitUsage unitUsage);

    UnitUsage Update(UnitUsage unitUsage);

    void DeleteFacility(int ID);

    UnitUsage Get(int ID);

    List<UnitUsage> GetByUnitID(int unitID);


}
