package Main.Entities.maintenance;

import Main.Entities.Facility.Facility;

import java.sql.Date;

/**
 * Created by Jackson on 3/13/14.
 */
public interface Inspection {
    int getId();

    void setId(int id);

    Facility getFacility();

    void setFacility(Facility facility);

    Date getInspectionDate();

    void setInspectionDate(Date inspectionDate);

    MaintenanceStaff getMaintenanceStaff();

    void setMaintenanceStaff(MaintenanceStaff maintenanceStaff);
}
