package Main.BL;

import Main.Entities.maintenance.MaintenanceRequest;

public interface IFacilityMaintenanceService {

    public MaintenanceRequest getFacilityMaintenanceRequest();

    public void setFacilityMaintenanceRequest(MaintenanceRequest request);

}
