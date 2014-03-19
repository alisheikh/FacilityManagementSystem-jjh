package Main.DAL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;

import java.util.List;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IFacilityDAO {
    Facility create(Facility facilty);

    Facility update(Facility facility);

    void delete(Facility facility);

    Facility get(int id);

    List<Facility> getAll();

    IUnitDAO getUnitDAO();


    void setUnitDAO(IUnitDAO unitDAO);

    DatabaseConnector getDatabaseConnector();

    void setDatabaseConnector(DatabaseConnector databaseConnector);
}
