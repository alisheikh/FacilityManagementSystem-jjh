package Main.BL;

import Main.Entities.Facility;
import Main.DAL.*;

import java.util.List;


public class FacilityService implements IFacilityService {

    private FacilityFactory facilityFactory;

    public FacilityService(IDatabaseConnector connector)
    {
        facilityFactory = new FacilityFactory(connector);
    }

    public List<Facility> listFacilities() {
        return null;
    }

    public  Facility getFacilityInformation(int ID)
    {
        return facilityFactory.Get(ID);
    }


    public int requestAvailibleCapacity(int facilityID) {
        Facility facility = facilityFactory.Get(facilityID);
        return facility
    }


    public Facility addNewFacility() {
        return null;
    }


    public void addFacilityDetail(int facilityID, String detail) {

    }


    public void RemoveFacility(int facilityID) {

    }


}
