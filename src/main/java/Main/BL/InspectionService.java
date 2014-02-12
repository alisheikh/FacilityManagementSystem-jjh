package main.BL;

import main.DAL.IInspectionDAO;
import main.Entities.maintenance.Inspection;

import java.util.List;

/**
 * User: alexthornburg
 * Date: 2/9/14
 * Time: 11:13 PM
 */

public class InspectionService implements IInspectionService{


    private IInspectionDAO inspectionDAO;

    public InspectionService(IInspectionDAO inspectionDAO) {
        this.inspectionDAO = inspectionDAO;
    }

    @Override
    public List<Inspection> listInspections(int facilityID) {
        return inspectionDAO.listAllInspections(facilityID);
    }

    @Override
    public Inspection getInspectionInformation(int id) {
        return inspectionDAO.get(id);
    }

    @Override
    public void addInspection(Inspection inspection) {
        inspectionDAO.create(inspection);
    }

    @Override
    public void removeInspection(Inspection inspection) {
      inspectionDAO.delete(inspection.getID());
    }
}
