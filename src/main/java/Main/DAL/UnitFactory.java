package Main.DAL;
import Main.Entities.Unit;

/**
 * Created by john on 2/6/14.
 */
public class UnitFactory implements IUnitFactory {

    private IDatabaseConnector Connector;

    public UnitFactory(IDatabaseConnector connector){
        Connector = connector;
    }

    @Override
    public void Create(Unit unit)
    {
    }

    @Override
    public void Delete(Unit unit){

    }

    @Override
    public Unit Get()
    {
        return null;
    }
    @Override
    public Unit Update(Unit unit)
    {
        return null;

    }

}
