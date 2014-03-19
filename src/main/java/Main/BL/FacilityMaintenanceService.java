package Main.BL;

import Main.DAL.IFacilityDAO;
import Main.DAL.IMaintenanceRequestDAO;
import Main.DAL.IMaintenanceStaffDAO;
import Main.DAL.IUnitDAO;
import Main.Entities.Facility.Unit;
import Main.Entities.maintenance.MaintenanceRequest;
import Main.Entities.maintenance.MaintenanceRequestImpl;
import Main.Entities.maintenance.MaintenanceStaff;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class FacilityMaintenanceService implements IFacilityMaintenanceService {

    private MaintenanceRequest request;
    private IFacilityDAO facilityDAO;
    private IUnitDAO unitDAO;
    private IMaintenanceRequestDAO maintenanceRequestDAO;
    private IMaintenanceStaffDAO maintenanceStaffDAO;

    public FacilityMaintenanceService(IFacilityDAO facilityDAO, IUnitDAO unitDAO, IMaintenanceRequestDAO maintenanceRequestDAO, IMaintenanceStaffDAO maintenanceStaffDAO){
        this.unitDAO = unitDAO;
        this.maintenanceRequestDAO = maintenanceRequestDAO;
        this.maintenanceStaffDAO = maintenanceStaffDAO;
    }
    @Override
    public MaintenanceRequest makeFacilityMaintRequest(int unitId, String request) {
        MaintenanceRequest newRequest = new MaintenanceRequestImpl();
        newRequest.setRequest(request);
        newRequest = maintenanceRequestDAO.create(newRequest);

        return newRequest;
    }

    @Override
    public MaintenanceRequest scheduleMaintenance(int MaintainenceRequestID, int staffMemberId, int estimatedTime, java.sql.Date completionDate) {

        MaintenanceRequest request = new MaintenanceRequestImpl();

        try {
            request = maintenanceRequestDAO.get(MaintainenceRequestID);

            MaintenanceStaff staff = maintenanceStaffDAO.get(staffMemberId);
            System.out.println("StaffMemberID in scheduleMaintenceService" + staff.getId());

            request.setHoursToComplete(estimatedTime);
            request.setMaintenanceStaff(staff);
            request.setCompletionDate(completionDate);

            return maintenanceRequestDAO.update(request);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;
    }


    @Override
    public double calcMaintenanceCostForFacility(int facilityID) {
            List<Unit> units = unitDAO.getAll(facilityID);
            List<MaintenanceRequest> requests = new ArrayList<MaintenanceRequest>();


            for(Unit unit:units)
            {
              requests.addAll(maintenanceRequestDAO.getAll(unit.getUnitId()));
            }
            double cost = 0.0;
            for(MaintenanceRequest maintenanceRequest:requests)
            {
               cost += maintenanceRequest.getMaintenanceStaff().getHoursPerWeek() * maintenanceRequest.getHoursToComplete();
            }
            return cost;

        }

    @Override
    public float calcDownTimeForFacility(int FacilityID, Date startDate, Date endDate) {
        return 0;
    }

    @Override
    public float calcProblemRateForFacility(int facilityID) {
            List<Unit> units = unitDAO.getAll(facilityID);
            List<MaintenanceRequest> requests = new ArrayList<MaintenanceRequest>();

            int numberOfunits = 0;
            for(Unit unit:units)
            {
                requests.addAll(maintenanceRequestDAO.getAll(unit.getUnitId()));
                numberOfunits++;
            }
            int numberOfProblems=0;
            for(MaintenanceRequest maintenanceRequest:requests)
            {
                numberOfProblems++;
            }
            return (float) numberOfProblems/numberOfunits;
    }


    @Override
    public List<MaintenanceRequest> listMaintenanceRequests(int facilityID) {

        List<MaintenanceRequest> requests = new ArrayList<MaintenanceRequest>();


            List<Unit> units = unitDAO.getAll(facilityID);
            for(Unit unit:units)
            {
                requests.addAll(maintenanceRequestDAO.getAll(unit.getUnitId()));
            }
            return requests;
    }

}