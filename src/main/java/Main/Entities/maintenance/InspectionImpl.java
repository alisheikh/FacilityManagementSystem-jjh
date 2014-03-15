package Main.Entities.maintenance;


import Main.Entities.Facility.Facility;

import java.sql.Date;

public class InspectionImpl implements Inspection {

	private int id;

	private Facility facility;

	private MaintenanceStaff inspectingStaff;

	private Date inspectionDate;

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public Facility getFacility() {
        return facility;
    }

    @Override
    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public Date getInspectionDate() {
        return inspectionDate;
    }

    @Override
    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    @Override
    public MaintenanceStaff getInspectingStaff() {
        return inspectingStaff;
    }

    @Override
    public void setInspectingStaff(MaintenanceStaff inspectingStaffID) {
        this.inspectingStaff = inspectingStaffID;
    }
}
