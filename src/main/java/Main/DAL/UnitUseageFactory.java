package Main.DAL;

import Main.Entities.UnitUsage;
import org.joda.time.DateTime;

import java.util.List;

public class UnitUseageFactory implements IUnitUseageFactory {


    private IDatabaseConnector Connector;
    private DateTime startTime;

    public UnitUseageFactory(IDatabaseConnector connector){
        Connector = connector;
    }


    @Override
    public UnitUsage Create(UnitUsage unitUsage) {
        return null;
    }

    @Override
    public UnitUsage Update(UnitUsage unitUsage) {
        return null;
    }

    @Override
    public void DeleteFacility(int ID) {

    }

    @Override
    public UnitUsage Get(int ID) {
        return null;
    }

    @Override
    public List<UnitUsage> GetByUnitID(int unitID) {
        return null;
    }

    /*
        * Gets all UnitUsages after a given start time
        *
        * todo: this method should maybe be overloaded to do start and end times lets keep it simple for now
        *
        * */
    public  List<UnitUsage> GetByStartTime(DateTime startTime)
    {
        this.startTime = startTime;
        return null;
    }
}
