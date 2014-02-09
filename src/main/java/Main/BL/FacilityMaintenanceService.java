package Main.BL;

import Main.Entities.Facility.Facility;
import Main.Entities.maintenance.MaintenanceRequest;
import Main.Entities.maintenance.MaintenanceStaff;

import java.util.Date;
import java.util.List;


public class FacilityMaintenanceService implements IFacilityMaintenanceService {

    private MaintenanceRequest request;

    @Override
    public MaintenanceRequest makeFacilityMaintRequest(int facilityID, String request) {
        return null;
    }

    @Override
    public MaintenanceRequest scheduleMaintenance(int MaintainenceRequestID, MaintenanceStaff staffMember, int estimatedTime) {
        return null;
    }

    @Override
    public double calcMaintenanceCostForFacility(int facilityID, Date startDate, Date endDate) {
        return 0;
    }

    @Override
    public float calcProblemRateForFacility(int FacilityID, Date startDate, Date endDate) {
        return 0;
    }

    @Override
    public float calcDownTimeForFacility(int FacilityID, Date startDate, Date endDate) {
        return 0;
    }

    @Override
    public List<MaintenanceRequest> listMaintenanceRequests(int facilityID, Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<MaintenanceRequest> listFacilityProblems(int facilityID) {
        return null;
    }
}