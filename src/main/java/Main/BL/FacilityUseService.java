package Main.BL;

import Main.DAL.FacilityFactory;
import Main.DAL.UnitFactory;
import Main.DAL.UnitUseageFactory;
import Main.Entities.Unit;
import Main.Entities.UnitUsage;
import Main.Entities.Facility;
import Main.Entities.Inspection;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.List;

public class FacilityUseService implements IFacilityUseService {

    private FacilityFactory facilityFactory;
    private UnitFactory unitFactory;
    private UnitUseageFactory unitUsageFactory;

    public FacilityUseService(FacilityFactory facilityFactory, UnitFactory unitFactory){
        this.facilityFactory = facilityFactory;
        this.unitFactory = unitFactory;
    }

    @Override
    public boolean IsInUseDuringInterval(int unitID, DateTime startTime, DateTime endTime)
    {

        Unit unit = unitFactory.Get(unitID);

        List<UnitUsage> usages = unitUsageFactory.GetByStartTime(startTime);


        Interval proposedReservationInterval = new Interval(startTime, endTime);

        Interval testInterval;

        for(UnitUsage usage: usages)
        {
            testInterval = new Interval(usage.startTime, usage.endTime);
            if(proposedReservationInterval.overlaps(testInterval))
            {
                return true;
            }
        }
            return false;
    }

    @Override
    public UnitUsage assignFacilityToUse(DateTime sartTime, DateTime entTime, int facilityUserID, int facilityID) {
        return null;
    }

    @Override
    public void vacateFacility(DateTime startTime, int facilityUser, Facility facility) {

    }

    @Override
    public List<Inspection> listInspections(int facilityID) {
        return null;
    }

    @Override
    public List<UnitUsage> listActualUsage(int facilityID) {
        return null;
    }

    @Override
    public double calcUsageRate(int facilityID) {
        return 0;
    }
}
