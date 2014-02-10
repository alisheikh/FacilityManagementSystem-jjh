package Main.BL;

import Main.DAL.IMaintenanceStaffDAO;
import Main.DAL.IUserDAO;
import Main.Entities.maintenance.MaintenanceStaff;
import Main.Entities.usage.UnitUser;

/**
 * Created by Jackson on 2/8/14.
 * We can talk about this. Alex thinks its unnecessary.
 */
public class PersonService implements IPersonService {

    /*private IMaintenanceStaffDAO StaffDao;

    private IUserDAO UnitUserDao;

    public PersonService(IMaintenanceStaffDAO staffDao, IUserDAO unitUserDao){
        StaffDao = staffDao;
        UnitUserDao = unitUserDao;
    }

    @Override
    public MaintenanceStaff AddNewMaintenanceStaff(MaintenanceStaff newStaffMember) {
       return StaffDao.create(newStaffMember);
    }

    @Override
    public void DeleteMaintenanceStaff(int staffMemberId) {
        StaffDao.delete(staffMemberId);
    }

    @Override
    public UnitUser AddNewUnitUser(UnitUser newUnitUser) {
        return UnitUserDao.create(newUnitUser);
    }

    @Override
    public void DeleteUnitUser(int UnitUserId) {
        UnitUserDao.delete(UnitUserId);
    }*/
}
