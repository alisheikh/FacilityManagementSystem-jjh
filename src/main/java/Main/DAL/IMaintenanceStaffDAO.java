package Main.DAL;

import Main.Entities.maintenance.MaintenanceStaff;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IMaintenanceStaffDAO {
    MaintenanceStaff create(MaintenanceStaff newStaffMember);

    void delete(MaintenanceStaff maintenanceStaff);

    MaintenanceStaff get(int id);

    MaintenanceStaff update(MaintenanceStaff updatedStaffMember);
}
