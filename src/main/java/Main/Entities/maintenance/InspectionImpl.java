package Main.Entities.maintenance;


import Main.Entities.Facility.Facility;

import java.sql.Date;

public class InspectionImpl implements Inspection {

	private int id;

	private Facility facility;

	private MaintenanceStaff maintenanceStaff;

	private Date inspectionDate;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
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
    public MaintenanceStaff getMaintenanceStaff() {
        return maintenanceStaff;
    }

    @Override
    public void setMaintenanceStaff(MaintenanceStaff maintenanceStaff) {
        this.maintenanceStaff = maintenanceStaff;
    }
}
