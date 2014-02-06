package Main.BL;

import Main.DAL.IFacilityUsegaeFactory;
import Main.Entities.UnitUsage;
import Main.Entities.Facility;
import Main.Entities.Inspection;
import org.joda.time.DateTime;

import java.util.List;

public class FacilityUseService implements IFacilityUseService {


    @Override
    public boolean isInUseDuringInterval(int facilityID, DateTime startTime, DateTime endTime) {


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
