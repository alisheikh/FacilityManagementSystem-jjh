package Main.BL;

import Main.Entities.maintenance.MaintenanceRequest;
import Main.Entities.maintenance.MaintenanceStaff;

import java.util.Date;
import java.util.List;

public interface IFacilityMaintenanceService {

	public MaintenanceRequest makeFacilityMaintRequest(int facilityID, String request);

	public MaintenanceRequest scheduleMaintenance(int MaintainenceRequestID, MaintenanceStaff staffMember, int estimatedTime);

	public double calcMaintenanceCostForFacility(int facilityID, Date startDate, Date endDate);

	public float calcProblemRateForFacility(int FacilityID, Date startDate, Date endDate);

	public float calcDownTimeForFacility(int FacilityID, Date startDate, Date endDate);

	public List<MaintenanceRequest> listMaintenanceRequests(int facilityID, Date startDate, Date endDate);

	public List<MaintenanceRequest> listFacilityProblems(int facilityID);

}
