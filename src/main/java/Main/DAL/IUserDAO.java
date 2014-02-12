package main.DAL;

import main.Entities.usage.UnitUser;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IUserDAO {
    UnitUser create(UnitUser newUnitUser);

    void delete(int unitUserId);

    UnitUser get(int user_id);

    UnitUser update(UnitUser unitUser) throws Exception;

}
