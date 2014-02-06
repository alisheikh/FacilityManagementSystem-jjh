package Main.DAL;

import Main.Entities.MaintenanceStaff;

/**
 * Created by john on 2/5/14.
 */
public interface IMaintanceStaffFactory {
    MaintanceStaffFactory Create(MaintenanceStaff staff);

    MaintanceStaffFactory Update(MaintenanceStaff staff);

    void Delete(int ID);

    MaintenanceStaff Get(int ID);
}
