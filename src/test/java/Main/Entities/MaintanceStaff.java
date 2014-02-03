package Main.Entities;

public class MaintanceStaff extends Person {

	private double PayPerHour;

	private boolean isFullTime;

	private double HoursPerWeek;

	public void MaintaniceStaff() {

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
