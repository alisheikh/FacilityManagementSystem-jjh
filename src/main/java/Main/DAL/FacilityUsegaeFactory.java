package Main.DAL;

import Main.Entities.UnitUsage;

public class FacilityUsegaeFactory implements IFacilityUsegaeFactory {


    private IDatabaseConnector Connector;

    public FacilityUsegaeFactory(IDatabaseConnector connector){
        Connector = connector;
    }

	@Override
    public FacilityUsegaeFactory Create(UnitUsage unitUsage) {
        return  null;
	}

	@Override
    public FacilityUsegaeFactory Update(UnitUsage unitUsage) {
        return  null;
	}

	@Override
    public void DeleteFacility(int ID) {

	}

	@Override
    public UnitUsage Get(int ID) {
		return null;
	}

}
