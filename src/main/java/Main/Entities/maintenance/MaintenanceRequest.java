package Main.Entities.maintenance;

import java.sql.Date;
import Main.Entities.Facility.Unit;
/**
 * Created by Jackson on 3/13/14.
 */
public interface MaintenanceRequest {
    int getId();

    void setId(int id);

    Date getDateRequested();

    void setDateRequested(Date dateRequested);

    Date getCompletionDate();

    void setCompletionDate(Date completionDate);

    String getRequest();

    void setRequest(String request);

    Unit getUnit();

    void setUnit(Unit unit);

    MaintenanceStaff getMaintenanceStaff();

    void setMaintenanceStaff(MaintenanceStaff maintenanceStaff);

    double getHoursToComplete();

    void setHoursToComplete(int estimatedTime);
}
