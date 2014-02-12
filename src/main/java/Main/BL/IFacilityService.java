package main.BL;

import main.Entities.Facility.Facility;
import main.Entities.Facility.Unit;

import java.util.List;

public interface IFacilityService {


    List<Facility> listFacilities();

    Facility getFacilityInformation(int id);

    int requestAvailibleCapacity(int facilityId, int unitID);

    Facility addNewFacility(Facility facility);

    Unit addFacilityDetail(int facilityID, Unit unit);

    void removeFacility(Facility facility);

    void RemoveUnit(Unit unit1);
}
