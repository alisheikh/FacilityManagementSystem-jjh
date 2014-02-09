package Main.Entities.usage;

import Main.Entities.Facility.Unit;

import java.sql.Date;


public class UnitUsage {

    private int id;

    private UnitUser user;

	private Date startTime;

	private Date endTime;

	private Unit unit;

    public UnitUsage()
    {
    }

    public UnitUser getUser() {
        return user;
    }

    public void setUser(UnitUser user) {
        this.user = user;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
