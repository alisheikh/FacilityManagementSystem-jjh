package Main.Entities.maintenance;

import Main.Entities.Facility.Facility;
import org.joda.time.DateTime;

public class MaintenanceRequest {

	private int id;

	private Facility facility;

    private String request;

	private DateTime dateRequested;

	private DateTime completionDate;

	private MaintenanceStaff staffMemberAssigned;

	public MaintenanceRequest() {

	}

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public DateTime getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(DateTime dateRequested) {
        this.dateRequested = dateRequested;
    }

    public DateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(DateTime completionDate) {
        this.completionDate = completionDate;
    }

    public MaintenanceStaff getStaffMemberAssigned() {
        return staffMemberAssigned;
    }

    public void setStaffMemberAssigned(MaintenanceStaff staffMemberAssigned) {
        staffMemberAssigned = staffMemberAssigned;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
