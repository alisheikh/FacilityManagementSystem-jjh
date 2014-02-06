package Main.DAL;

import Main.Entities.MaintenanceRequest;

/**
 * Created by john on 2/5/14.
 */
public interface IMaintenanceRequestFactory {
    MaintenanceRequest Create(MaintenanceRequest request);

    MaintenanceRequest Update(MaintenanceRequest request);

    void Delete(int ID);

    MaintenanceRequest Get(int ID);
}
