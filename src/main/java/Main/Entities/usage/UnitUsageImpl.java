package Main.Entities.usage;

import Main.Entities.Facility.Unit;

import java.sql.Date;


public class UnitUsageImpl implements UnitUsage {

    private int id;

	private Date startTime;

	private Date endTime;

    private Unit unit;

   private UnitUser unitUser;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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

    public Unit getUnit(){
        return unit;
    }

    public void setUnit(Unit unit){
        this.unit = unit;
    }

    @Override
    public void setUnitUser(UnitUser unitUser) {
        this.unitUser = unitUser;
    }


    public UnitUser getUnitUser(){
        return unitUser;
    }
}
