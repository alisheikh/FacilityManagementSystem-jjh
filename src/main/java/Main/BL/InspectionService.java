package Main.BL;

import Main.DAL.IFacilityDAO;
import Main.DAL.IInspectionDAO;
import Main.DAL.IMaintenanceStaffDAO;
import Main.Entities.maintenance.Inspection;
import Main.Entities.maintenance.InspectionImpl;

import java.sql.Date;
import java.util.List;

/**
 * User: alexthornburg
 * Date: 2/9/14
 * Time: 11:13 PM
 */

public class InspectionService implements IInspectionService{


    private IInspectionDAO inspectionDAO;
    private IFacilityDAO facilityDAO;
    private IMaintenanceStaffDAO maintenanceStaffDAO;

    public InspectionService(IInspectionDAO inspectionDAO, IFacilityDAO facilityDAO, IMaintenanceStaffDAO maintenanceStaffDAO) {
        this.inspectionDAO = inspectionDAO;
        this.facilityDAO = facilityDAO;
        this.maintenanceStaffDAO = maintenanceStaffDAO;
    }

    @Override
    public List<Inspection> listInspections(int facilityID) {
        return inspectionDAO.listAllInspections(facilityID);
    }

    @Override
    public List<Inspection> listInspections() {
        return inspectionDAO.listAllInspections();
    }

    @Override
    public Inspection getInspectionInformation(int id) {
        return inspectionDAO.get(id);
    }

    @Override
    public Inspection addInspection(int facilityID, int staffMemberId, Date inspectionDate) {

        Inspection inspection = new InspectionImpl();

            inspection.setFacility(facilityDAO.get(facilityID));
            inspection.setMaintenanceStaff(maintenanceStaffDAO.get(staffMemberId));
            inspection.setInspectionDate(inspectionDate);
            return inspectionDAO.add(inspection);

    }

    @Override
    public void removeInspection(Inspection inspection) {
        inspectionDAO.delete(inspection);
    }

    @Override
    public List<Inspection> getInspectionForFacility(int id) {
        return inspectionDAO.listAllInspections(id);

    }
}
