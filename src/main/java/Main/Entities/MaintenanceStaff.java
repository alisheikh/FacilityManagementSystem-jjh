package Main.Entities;

public class MaintenanceStaff extends Person {

	private double PayPerHour;

	private boolean isFullTime;

	private double HoursPerWeek;

	public MaintenanceStaff() {

	}

    public double getPayPerHour() {
        return PayPerHour;
    }

    public void setPayPerHour(double payPerHour) {
        PayPerHour = payPerHour;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public void setFullTime(boolean isFullTime) {
        this.isFullTime = isFullTime;
    }

    public double getHoursPerWeek() {
        return HoursPerWeek;
    }

    public void setHoursPerWeek(double hoursPerWeek) {
        HoursPerWeek = hoursPerWeek;
    }
}
