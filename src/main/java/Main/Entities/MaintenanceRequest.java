package Main.Entities;

import java.util.Date;

public class MaintenanceRequest {

    public int ID;

    public int FacilityID;
    public int UnitID;

    public String Request;

    public Date DateRequested;

    public Date DateForCompletion;

    public int StaffMemberAssignedID;

	public MaintenanceRequest() {	}
}
