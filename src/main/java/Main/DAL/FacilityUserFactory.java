package Main.DAL;

import Main.Entities.FacilityUser;

public class FacilityUserFactory implements IFacilityUserFactory {


    private IDatabaseConnector Connector;

    public FacilityUserFactory(IDatabaseConnector connector){
        Connector = connector;
    }

	@Override
    public FacilityUserFactory Create(FacilityUser user) {
        return  null;
	}

	@Override
    public FacilityUserFactory Update(FacilityUser user) {
        return  null;
	}

	@Override
    public void Delete(int ID) {

	}

	@Override
    public FacilityUser Get(int ID) {
		return null;
	}

}
