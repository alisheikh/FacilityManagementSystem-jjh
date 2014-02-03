package Main.BL;

import Main.DAL.FacilityFactory;
import Main.Entities.MaintenanceRequest;
import Main.Entities.MaintanceStaff;
import java.util.Date;
import java.util.List;
import Main.DAL.MaintenanceRequestFactory;


public class FacilityMaintenanceService implements IFacilityMaintenanceService {

    private FacilityFactory facilityFactory;

    public FacilityMaintenanceService(){

       facilityFactory = new FacilityFactory();
    }

	public  MaintenanceRequest makeFacilityMaintRequest(int facilityID, String request){
        MaintenanceRequestFactory requestFactory = new MaintenanceRequestFactory();

        MaintenanceRequest Request = new MaintenanceRequest();
        Request.setFacility(facilityFactory.Get(facilityID));
        Request.setRequest(request);

        return requestFactory.Create(Request);

    }

    @Override
    public MaintenanceRequest scheduleMaintenance(int MaintainenceRequestID, MaintanceStaff staffMember, int estimatedTime) {
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