package Main.BL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;

import java.util.List;

public interface IFacilityService {


    List<Facility> ListFacilities();

    Facility GetFacilityInformation(int ID);

    int RequestAvailibleCapacity(int UnitID);

    Facility AddNewFacility(String name, int managerID);

    Unit AddFacilityDetail(Unit unit);

    void RemoveFacility(int facilityID);

}
