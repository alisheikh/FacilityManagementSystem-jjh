package Main.DAL;

import Main.Entities.usage.UnitUser;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IUnitUserDAO {
    UnitUser Create(UnitUser newUnitUser);

    void Delete(int unitUserId);

}
