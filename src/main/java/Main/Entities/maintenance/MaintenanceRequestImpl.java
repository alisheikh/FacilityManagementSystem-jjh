package Main.Entities.maintenance;

import java.sql.Date;

public class MaintenanceRequestImpl implements MaintenanceRequest {

	private int id;

	private int unitId;

    private MaintenanceStaff maintenanceStaff;

    private String request;

	private Date dateRequested;

	private Date completionDate;


    private int hoursToComplete;

	public MaintenanceRequestImpl() {

	}

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public Date getDateRequested() {
        return dateRequested;
    }

    @Override
    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    @Override
    public Date getCompletionDate() {
        return completionDate;
    }

    @Override
    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }


    @Override
    public String getRequest() {
        return request;
    }

    @Override
    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public int getUnitId() {
        return unitId;
    }

    @Override
    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Override
    public MaintenanceStaff getMaintenanceStaff() {
        return maintenanceStaff;
    }

    @Override
    public void setMaintenanceStaff(MaintenanceStaff maintenanceStaff) {
        this.maintenanceStaff = maintenanceStaff;
    }

    public double getHoursToComplete() {
        return hoursToComplete;
    }

    public void setHoursToComplete(int hoursToComplete) {
        this.hoursToComplete = hoursToComplete;
    }
}
