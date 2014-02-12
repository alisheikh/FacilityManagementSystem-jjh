package Main.DAL;

import Main.Entities.Facility.Unit;
import Main.Entities.usage.UnitUsage;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jackson on 2/10/14.
 */
public interface IUsageDAO {
    UnitUsage createUsage(UnitUsage usage) throws SQLException;

    List<UnitUsage> getUsagesForUnit(Unit unit);

    UnitUsage updateUsage(UnitUsage unit) throws Exception;

    void deleteUsage(int id);


    List<UnitUsage> getAll();
}
