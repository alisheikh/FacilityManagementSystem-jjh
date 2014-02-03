package Main.BL;

import java.util.List;
import Main.Entities.Facility;

public interface IFacilityService {

	public List<Facility> listFacilities();

	public  Facility  getFacilityInformation(int facilityID);

	public  int  requestAvailibleCapacity(int facilityID);

	public  Facility  addNewFacility();

    public void addFacilityDetail(int facilityID, String detail);

	public  void RemoveFacility(int facilityID);

}
