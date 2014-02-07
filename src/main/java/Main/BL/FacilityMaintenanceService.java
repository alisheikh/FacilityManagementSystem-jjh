package Main.BL;

import Main.Entities.Facility.Facility;
import Main.Entities.maintenance.MaintenanceRequest;
import Main.Entities.maintenance.MaintenanceStaff;

import java.util.Date;
import java.util.List;


public class FacilityMaintenanceService implements IFacilityMaintenanceService {

    private MaintenanceRequest request;


    @Override
	public  MaintenanceRequest getFacilityMaintenanceRequest(){
        return request;

    }

    @Override
    public void setFacilityMaintenanceRequest(MaintenanceRequest request) {
           this.request = request;
    }

}