package Main.BL;

import Main.DAL.InspectionDAO;
import Main.Entities.maintenance.Inspection;

import java.util.List;

/**
 * User: alexthornburg
 * Date: 2/9/14
 * Time: 11:13 PM
 */

public class InspectionService implements IInspectionService{

    @Override
    public List<Inspection> listInspections() {
        return new InspectionDAO().listAllInspections();
    }

    @Override
    public Inspection getInspectionInformation(int id) {
        return new InspectionDAO().get(id);
    }

    @Override
    public void addInspection(Inspection inspection) {
        new InspectionDAO().create(inspection);
    }

    @Override
    public void removeInspection(Inspection inspection) {
       new InspectionDAO().delete(inspection.getID());
    }
}
