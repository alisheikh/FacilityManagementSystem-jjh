package Main.Entities.maintenance;

import Main.Entities.Facility.Unit;

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

    Unit getUnit();

    void setUnit(Unit unit);

    MaintenanceStaff getStaffMemberAssigned();

    void setStaffMemberAssigned(MaintenanceStaff staffMemberAssigned);

    double getHoursToComplete();

    void setHoursToComplete(int estimatedTime);
}
