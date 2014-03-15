package Main.Entities.maintenance;

import Main.Entities.Person;

public class MaintenanceStaffImpl extends Person implements MaintenanceStaff {

    private double payPerHour;

	private boolean isFullTime;

	private double hoursPerWeek;

	public MaintenanceStaffImpl() {

	}

    @Override
    public double getPayPerHour() {
        return payPerHour;
    }

    @Override
    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }

    @Override
    public boolean isFullTime() {
        return isFullTime;
    }

    @Override
    public void setFullTime(boolean isFullTime) {
        this.isFullTime = isFullTime;
    }

    @Override
    public double getHoursPerWeek() {
        return hoursPerWeek;
    }

    @Override
    public void setHoursPerWeek(double hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

}
