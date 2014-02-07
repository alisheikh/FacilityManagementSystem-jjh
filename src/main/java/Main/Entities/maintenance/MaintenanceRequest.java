package Main.Entities.maintenance;

import Main.Entities.Facility.Facility;
import org.joda.time.DateTime;

public class MaintenanceRequest {

	private String id;

	private Facility facility;

    private String request;

	private DateTime dateRequested;

	private DateTime dateForCompletion;

	private MaintenanceStaff staffMemberAssigned;

	public MaintenanceRequest() {

	}

    public String getID() {
        return id;
    }

    public void setID(String id) {
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

    public DateTime getDateForCompletion() {
        return dateForCompletion;
    }

    public void setDateForCompletion(DateTime dateForCompletion) {
        this.dateForCompletion = dateForCompletion;
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
