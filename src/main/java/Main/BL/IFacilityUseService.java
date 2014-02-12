package main.BL;


import main.Entities.Facility.Unit;
import main.Entities.maintenance.Inspection;
import main.Entities.usage.UnitUsage;
import main.Entities.usage.UnitUser;

import java.util.Date;
import java.util.List;

public interface IFacilityUseService {


    boolean IsInUseDuringInterval(int unitID, Date startTime, Date endTime);

    UnitUsage assignFacilityToUse(java.sql.Date sartTime, java.sql.Date entTime, UnitUser unitUser, Unit unit);

    void vacateFacility(int usageID);

    List<Inspection> listInspections(int facilityID);

    List<UnitUsage> listActualUsage(int unitID);

    List<UnitUsage> listUsages();
}
