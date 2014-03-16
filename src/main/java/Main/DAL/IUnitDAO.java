package Main.DAL;

import Main.Entities.Facility.Unit;
import Main.Entities.usage.UnitUsage;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jackson on 2/10/14.
 */
public interface IUnitDAO {

    void CreateUnit(List<Unit> units) throws SQLException;

    Unit CreateUnit(Unit unit) throws SQLException;

    Unit GetUnit(int unit_id) throws SQLException;

    Unit UpdateUnit(Unit unit) throws Exception;

    List<Unit> GetUnitForFacility(int id) throws SQLException;

    void DeleteUnit(int id);

}
