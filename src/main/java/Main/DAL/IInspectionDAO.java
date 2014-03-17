package Main.DAL;

import Main.Entities.maintenance.Inspection;

import java.util.List;

/**
 * Created by Jackson on 2/10/14.
 */
public interface IInspectionDAO {
    Inspection add(Inspection inspection);

    Inspection update(Inspection inspection);

    void delete(Inspection inspection);

    Inspection get(int id);

    List<Inspection> listAllInspections();

    void setMaintenanceStaffDAO(IMaintenanceStaffDAO maintenanceStaffDAO);

    void setFacilityDAO(IFacilityDAO facilityDAO);
}
