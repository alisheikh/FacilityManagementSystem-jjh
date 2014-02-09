package Main.BL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;

import java.util.List;


public class FacilityService implements IFacilityService {

    private Facility facility;


    @Override
    public List<Facility> ListFacilities() {
        return null;
    }

    @Override
    public Facility GetFacilityInformation(int ID) {
        return null;
    }

    @Override
    public int RequestAvailibleCapacity(int UnitID) {
        return 0;
    }

    @Override
    public Facility AddNewFacility(String name, int managerID) {
        return null;
    }

    @Override
    public Unit AddFacilityDetail(Unit unit) {
        return null;
    }

    @Override
    public void RemoveFacility(int facilityID) {

    }
}