package Main.DAL;

import Main.Entities.Facility.Unit;

/**
 * Created by Jackson on 2/10/14.
 */
public interface IUnitDAO {

    Unit create(Unit unit);

    Unit get(int unit_id);

    Unit update(Unit unit) throws Exception;

    void delete(Unit unit);

}
