package Main.BL;

import Main.DAL.IMaintenanceStaffDAO;
import Main.DAL.IUnitUserDAO;
import Main.Entities.maintenance.MaintenanceStaff;
import Main.Entities.usage.UnitUser;

/**
 * Created by Jackson on 2/8/14.
 */
public class PersonService implements IPersonService {

    private IMaintenanceStaffDAO StaffDao;

    private IUnitUserDAO UnitUserDao;

    public PersonService(IMaintenanceStaffDAO staffDao, IUnitUserDAO unitUserDao){
        StaffDao = staffDao;
        UnitUserDao = unitUserDao;
    }

    @Override
    public MaintenanceStaff AddNewMaintenanceStaff(MaintenanceStaff newStaffMember) {
       return StaffDao.Create(newStaffMember);
    }

    @Override
    public void DeleteMaintenanceStaff(int staffMemberId) {
        StaffDao.Delete(staffMemberId);
    }

    @Override
    public UnitUser AddNewUnitUser(UnitUser newUnitUser) {
        return UnitUserDao.Create(newUnitUser);
    }

    @Override
    public void DeleteUnitUser(int UnitUserId) {
        UnitUserDao.Delete(UnitUserId);
    }
}
