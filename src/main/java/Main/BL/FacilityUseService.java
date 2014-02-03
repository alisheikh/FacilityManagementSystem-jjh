package Main.BL;

import Main.Entities.FacilityUsage;
import Main.Entities.Facility;
import Main.Entities.Inspection;
import org.joda.time.DateTime;

import java.util.List;

public class FacilityUseService implements IFacilityUseService {

	public boolean UserDuringIntervale(DateTime startTime, DateTime endTime);

	public FacilityUsage assignFacilityToUse(DateTime sartTime, DateTime entTime, int facilityUserID, int facilityID);

	public void vacateFacility(DateTime startTime, int facilityUser, Facility facility);

	public List<Inspection> listInspections(int facilityID);

	public List<FacilityUsage> listActualUsage(int facilityID);

	public double calcUsageRate(int facilityID);

}
