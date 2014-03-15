package Main.Entities.usage;

import Main.Entities.Facility.Unit;

import java.sql.Date;


public class UnitUsageImpl implements UnitUsage {

    private int id;

	private Date startTime;

	private Date endTime;

    private UnitUser unitUser;

    private Unit unit;

    public UnitUsageImpl()
    {
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
    public UnitUser getUnitUser() {
        return unitUser;
    }

    @Override
    public void setUnitUser(UnitUser unitUser) {
        this.unitUser = unitUser;
    }

    @Override
    public Unit getUnit() {
        return unit;
    }

    @Override
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public Date getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
