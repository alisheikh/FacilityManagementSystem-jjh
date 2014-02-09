package Main.DAL;

import Main.Entities.maintenance.MaintenanceRequest;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IMaintenanceRequestDAO {
    MaintenanceRequest create(MaintenanceRequest request);

    MaintenanceRequest update(MaintenanceRequest request);

    void delete(int ID);

    MaintenanceRequest get(int ID);
}
