package Main.BL;

import Main.DAL.DatabaseConnector;
import Main.DAL.InspectionDAO;
import Main.Entities.maintenance.Inspection;

import java.util.List;

/**
 * User: alexthornburg
 * Date: 2/9/14
 * Time: 11:13 PM
 */

public class InspectionService implements IInspectionService{
    DatabaseConnector connector = new DatabaseConnector();

    @Override
    public List<Inspection> listInspections() {
        return new InspectionDAO(connector).listAllInspections();
    }

    @Override
    public Inspection getInspectionInformation(int id) {
        return new InspectionDAO(connector).get(id);
    }

    @Override
    public void addInspection(Inspection inspection) {
        new InspectionDAO(connector).create(inspection);
    }

    @Override
    public void removeInspection(Inspection inspection) {
       new InspectionDAO(connector).delete(inspection.getID());
    }
}
