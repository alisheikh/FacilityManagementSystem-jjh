package Main.Entities.usage;

import java.sql.Date;

/**
 * Created by Jackson on 3/13/14.
 */
public interface UnitUsage {


    int getId();

    void setId(int id);

    Date getStartTime();

    void setStartTime(Date startTime);

    Date getEndTime();

    void setEndTime(Date endTime);
}
