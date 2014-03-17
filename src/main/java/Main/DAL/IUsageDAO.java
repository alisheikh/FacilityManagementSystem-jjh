package Main.DAL;

import Main.Entities.usage.UnitUsage;

import java.util.List;

/**
 * Created by Jackson on 2/10/14.
 */
public interface IUsageDAO {
    UnitUsage create(UnitUsage usage);

    UnitUsage get(int id);

    UnitUsage update(UnitUsage unit) throws Exception;

    void delete(UnitUsage usage);

    List<UnitUsage> getAll();
}
