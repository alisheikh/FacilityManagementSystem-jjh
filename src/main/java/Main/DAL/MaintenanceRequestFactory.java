package Main.DAL;

import Main.Entities.MaintenanceRequest;

public class MaintenanceRequestFactory implements IMaintenanceRequestFactory {


    private IDatabaseConnector Connector;

    public MaintenanceRequestFactory(IDatabaseConnector connector){
        Connector = connector;
    }
	@Override
    public MaintenanceRequest Create(MaintenanceRequest request) {

        return null;
	}

	@Override
    public MaintenanceRequest Update(MaintenanceRequest request) {
        return null;
	}

	@Override
    public void Delete(int ID) {

	}

	@Override
    public MaintenanceRequest Get(int ID) {
		return null;
	}

}
