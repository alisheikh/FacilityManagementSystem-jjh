package Main.DAL;

import Main.Entities.FacilityUser;

/**
 * Created by john on 2/5/14.
 */
public interface IFacilityUserFactory {
    FacilityUserFactory Create(FacilityUser user);

    FacilityUserFactory Update(FacilityUser user);

    void Delete(int ID);

    FacilityUser Get(int ID);
}
