package main.DAL;

import main.Entities.maintenance.MaintenanceRequest;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IMaintenanceRequestDAO {
    MaintenanceRequest create(MaintenanceRequest request);

    MaintenanceRequest update(MaintenanceRequest request) throws Exception;

    void delete(int ID);

    MaintenanceRequest get(int ID);
}
