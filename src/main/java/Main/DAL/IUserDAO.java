package Main.DAL;

import Main.Entities.usage.UnitUser;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IUserDAO {
    UnitUser create(UnitUser user);

    void delete(UnitUser user);

    UnitUser get(int id);

    UnitUser update(UnitUser user);

}
