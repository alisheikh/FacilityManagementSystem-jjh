package Main.Entities.usage;

import Main.Entities.Facility.Unit;

import java.sql.Date;

/**
 * Created by Jackson on 3/13/14.
 */
public interface UnitUsage {
    int getId();

    void setId(int id);

    UnitUser getUnitUser();

    void setUnitUser(UnitUser unitUser);

    Unit getUnit();

    void setUnit(Unit unit);

    Date getStartTime();

    void setStartTime(Date startTime);

    Date getEndTime();

    void setEndTime(Date endTime);
}
