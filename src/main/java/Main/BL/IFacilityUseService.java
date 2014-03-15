package Main.BL;


import Main.Entities.Facility.Unit;
import Main.Entities.maintenance.Inspection;
import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUserImpl;

import java.util.Date;
import java.util.List;

public interface IFacilityUseService {


    boolean IsInUseDuringInterval(int unitID, Date startTime, Date endTime);

    UnitUsage assignFacilityToUse(java.sql.Date sartTime, java.sql.Date entTime, UnitUserImpl unitUser, Unit unit);

    void vacateFacility(int usageID);

    List<Inspection> listInspections(int facilityID);

    List<UnitUsage> listActualUsage(int unitID);

    List<UnitUsage> listUsages();
}
