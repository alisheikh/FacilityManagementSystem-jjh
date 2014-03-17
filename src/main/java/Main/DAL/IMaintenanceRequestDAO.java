package Main.DAL;

import Main.Entities.maintenance.MaintenanceRequest;

import java.util.Collection;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IMaintenanceRequestDAO {
    MaintenanceRequest create(MaintenanceRequest request);

    MaintenanceRequest update(MaintenanceRequest request) throws Exception;

    void delete(MaintenanceRequest maintenanceRequest);

    MaintenanceRequest get(int id);

    Collection<? extends MaintenanceRequest> getAll(int maintenanceId);
}
