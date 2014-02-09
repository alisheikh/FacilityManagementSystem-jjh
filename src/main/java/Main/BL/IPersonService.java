package Main.BL;

import Main.Entities.maintenance.MaintenanceStaff;
import Main.Entities.usage.UnitUser;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IPersonService {

    MaintenanceStaff AddNewMaintenanceStaff (MaintenanceStaff newStaffMember);

    void DeleteMaintenanceStaff(int staffMemberId);

    UnitUser AddNewUnitUser(UnitUser newUnitUser);

    void DeleteUnitUser(int UnitUserId);


}
