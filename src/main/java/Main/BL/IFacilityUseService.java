package Main.BL;

import Main.Entities.UnitUsage;
import Main.Entities.Facility;
import Main.Entities.Inspection;
import org.joda.time.DateTime;

import java.util.List;

public interface IFacilityUseService {

	public  boolean isInUseDuringInterval(int facilityID, DateTime startTime, DateTime endTime);

	public UnitUsage assignFacilityToUse(DateTime sartTime, DateTime entTime, int facilityUserID, int facilityID);

	public void vacateFacility(DateTime startTime, int facilityUser, Facility facility);

	public List<Inspection> listInspections(int facilityID);

	public List<UnitUsage> listActualUsage(int facilityID);

	public double calcUsageRate(int facilityID);

}
