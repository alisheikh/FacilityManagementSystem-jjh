package Main.DAL;

import Main.Entities.Facility;

import java.util.List;

public class FacilityFactory implements IFacilityFactory {

    private IDatabaseConnector Connector;

    public FacilityFactory(IDatabaseConnector connector){
        Connector = connector;
    }

	@Override
    public FacilityFactory Create(Facility facilty) {
        return null;
    }

	@Override
    public FacilityFactory Update(Facility facility) {
        return null;
    }

	@Override
    public void Delete(int ID) {

	}

	@Override
    public Facility Get(int ID) {
		return null;
	}

    @Override
    public List<Facility> GetAll() {
        return null;
    }
}
