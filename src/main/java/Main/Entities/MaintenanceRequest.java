package Main.Entities;

import java.util.Date;

public class MaintenanceRequest {

	private int ID;

	private Facility Facility; // see issues.txt issue #1

    private String Request;

	private Date DateRequested;

	private Date DateForCompletion;

	private MaintenanceStaff StaffMemberAssigned; // see issue.txt issue 1
    //private MaintenanceStaffID StaffMemberAssignedID; //CreateGetSet; // TODO: issue 1



	public MaintenanceRequest() {

	}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Facility getFacility() {
        return Facility;
    }

    public void setFacility(Facility facility) {
        Facility = facility;
    }

    public Date getDateRequested() {
        return DateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        DateRequested = dateRequested;
    }

    public Date getDateForCompletion() {
        return DateForCompletion;
    }

    public void setDateForCompletion(Date dateForCompletion) {
        DateForCompletion = dateForCompletion;
    }

    public MaintenanceStaff getStaffMemberAssigned() {
        return StaffMemberAssigned;
    }

    public void setStaffMemberAssigned(MaintenanceStaff staffMemberAssigned) {
        StaffMemberAssigned = staffMemberAssigned;
    }

    public String getRequest() {
        return Request;
    }

    public void setRequest(String request) {
        Request = request;
    }
}
