package Main.BL;

import java.util.List;
import Main.Entities.Facility;
import Main.Entities.Unit;

public interface IFacilityService {


    List<Facility> ListFacilities();

    List<Unit> ListUnitsForFacility(int facilityID);

    Facility GetFacilityInformation(int ID);

    int RequestAvailibleCapacity(int UnitID);

    Facility AddNewFacility(String name, int managerID);

    Unit AddNewUnitToFacility(int facilityID, int newUnitCapacity, double newUnitUsagePricePerHour);

    /*
        * My assumption is that this method is to be interpreted as update Facility
        * */
    void AddFacilityDetail(Facility facility);

    void AddUnitDetail(Unit unit);

    void RemoveFacility(int facilityID);

    void RemoveUnit(int unitID);
}
