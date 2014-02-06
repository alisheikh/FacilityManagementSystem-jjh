package Main.BL;

import java.util.List;
import Main.Entities.Facility;
import Main.Entities.Unit;

public interface IFacilityService {

	public List<Facility> listFacilities();

    public List<List> listUnitsForFacility();

	public  Facility  getFacilityInformation(int facilityID);

	public  int  requestAvailibleCapacity(int facilityID);

	public  Facility  addNewFacility();

    public Unit addNewUnitToFacility(int facilityID, );

    public void addFacilityDetail(int facilityID, String detail);

	public  void RemoveFacility(int facilityID);

}
