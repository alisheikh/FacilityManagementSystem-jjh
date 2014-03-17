package Main.Entities.maintenance;

import Main.Entities.PersonImpl;

public class MaintenanceStaffImpl extends PersonImpl implements MaintenanceStaff {

    private double payPerHour;

	private boolean isFullTime;

	private double hoursPerWeek;

    @Override
    public double getPayPerHour() {
        return payPerHour;
    }

    @Override
    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }

    @Override
    public boolean getIsFullTime() {
        return isFullTime;
    }

    @Override
    public void setIsFullTime(boolean isFullTime) {
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

    @Override
    public void setId(int id) {
        super.setId(id);
    }

}
