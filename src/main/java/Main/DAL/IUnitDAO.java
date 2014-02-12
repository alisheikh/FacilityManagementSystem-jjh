package Main.DAL;

import Main.Entities.Facility.Unit;
import Main.Entities.usage.UnitUsage;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jackson on 2/10/14.
 */
public interface IUnitDAO {
    UnitUsage createUsage(UnitUsage usage) throws SQLException;

    List<UnitUsage> getUsagesForUnit(Unit unit);

    UnitUsage updateUsage(UnitUsage unit) throws Exception;

    void deleteUsage(int id);

    UnitUsage getUsage(int id);

    void createUnit(List<Unit> units) throws SQLException;

    Unit createUnit(Unit unit) throws SQLException;

    Unit getUnit(int unit_id) throws SQLException;

    Unit updateUnit(Unit unit) throws Exception;

    List<Unit> getUnitForFacility(int id) throws SQLException;

    void deleteUnit(int id);

}
