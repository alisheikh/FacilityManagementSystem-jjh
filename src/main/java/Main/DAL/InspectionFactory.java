package Main.DAL;

import Main.Entities.Inspection;

public class InspectionFactory implements IInspectionFactory {


    private IDatabaseConnector Connector;

    public InspectionFactory(IDatabaseConnector connector){
        Connector = connector;
    }
	@Override
    public Inspection Create(Inspection inspection) {
        return null;
	}

	@Override
    public Inspection Update(Inspection inspection)
    {
        return null;
	}

	@Override
    public void Delete(int ID) {

	}

	@Override
    public Inspection Get(int ID) {
		return null;
	}

}
