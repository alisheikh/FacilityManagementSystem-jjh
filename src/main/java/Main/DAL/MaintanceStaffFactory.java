package Main.DAL;

import Main.Entities.MaintenanceStaff;

public class MaintanceStaffFactory implements IMaintanceStaffFactory {


    private IDatabaseConnector Connector;

    public MaintanceStaffFactory(IDatabaseConnector connector){
        Connector = connector;
    }
	@Override
    public MaintanceStaffFactory Create(MaintenanceStaff staff) {
        return null;
	}

	@Override
    public MaintanceStaffFactory Update(MaintenanceStaff staff) {
        return null;
	}

	@Override
    public void Delete(int ID) {

	}

	@Override
    public MaintenanceStaff Get(int ID) {
		return null;
	}

}
