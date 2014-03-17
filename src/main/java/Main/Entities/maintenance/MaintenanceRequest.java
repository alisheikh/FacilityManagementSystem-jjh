package Main.Entities.maintenance;

import java.sql.Date;

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

   int getUnitId();

    void setUnitId(int unitId);

    MaintenanceStaff getMaintenanceStaff();

    void setMaintenanceStaff(MaintenanceStaff maintenanceStaff);

    double getHoursToComplete();

    void setHoursToComplete(int estimatedTime);
}
