package Main.DAL;

import Main.Entities.maintenance.MaintenanceStaff;

import java.sql.SQLException;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IMaintenanceStaffDAO {
    MaintenanceStaff Create(MaintenanceStaff newStaffMember);

    void Delete(int staffMemberId);

    MaintenanceStaff Get(int id) throws SQLException;

    MaintenanceStaff Update(MaintenanceStaff updatedStaffMember);
}
