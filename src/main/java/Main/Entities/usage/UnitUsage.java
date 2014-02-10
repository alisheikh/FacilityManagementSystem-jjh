package Main.Entities.usage;

import org.joda.time.DateTime;


public class UnitUsage {

    private int id;

    private int userId;

	private DateTime startTime;

	private DateTime endTime;

	private int unitId;

    public UnitUsage()
    {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int iserId) {
        this.userId = userId;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }
}
