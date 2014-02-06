package Main.DAL;

import Main.Entities.UnitUsage;

/**
 * Created by john on 2/5/14.
 */
public interface IFacilityUsegaeFactory {
    FacilityUsegaeFactory Create(UnitUsage unitUsage);

    FacilityUsegaeFactory Update(UnitUsage unitUsage);

    void DeleteFacility(int ID);

    UnitUsage Get(int ID);
}
