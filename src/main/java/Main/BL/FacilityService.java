package Main.BL;

import Main.Entities.Facility;
import Main.DAL.*;
import Main.Entities.Unit;
import com.sun.media.sound.FFT;

import java.util.List;


public class FacilityService implements IFacilityService {



    private IFacilityFactory FacilityFactory;
    private IUnitFactory UnitFactory;

    public FacilityService(IFacilityFactory facilityFactory, UnitFactory unitFactory)
    {
        FacilityFactory = facilityFactory;
        UnitFactory = unitFactory;
    }

    @Override
    public List<Facility> ListFacilities() {
        return FacilityFactory.GetAll();
    }

    @Override
    public List<Unit> ListUnitsForFacility(int facilityID) {
       return UnitFactory.GetByFacilityID(facilityID);
    }

    @Override
    public Facility GetFacilityInformation(int ID)
    {
        return FacilityFactory.Get(ID);
    }


    @Override
    public int RequestAvailibleCapacity(int UnitID) {
        Unit unit = UnitFactory.Get(UnitID);
        return unit.Capacity;
    }


    @Override
    public Facility AddNewFacility(String name, int managerID)
    {
        Facility facility = new Facility();
        facility.MaintinanceManagerID = managerID;
        facility.Name = name;
        return FacilityFactory.Create(facility);
    }

    @Override
    public Unit AddNewUnitToFacility(int facilityID, int newUnitCapacity, double newUnitUsagePricePerHour)
    {
        Unit newUnit = new Unit();
        newUnit.Capacity = newUnitCapacity;
        newUnit.FacilityID = facilityID;
        newUnit.PricePerHour = newUnitUsagePricePerHour;
        return UnitFactory.Create(newUnit);
    }

    /*
    * My assumption is that this method is to be interpreted as update Facility
    * */
    @Override
    public void AddFacilityDetail(Facility facility) {
        FacilityFactory.Update(facility);
    }

    @Override
    public void AddUnitDetail(Unit unit){
        UnitFactory.Update(unit);
    }


    @Override
    public void RemoveFacility(int facilityID) {
        FacilityFactory.Delete(facilityID);
    }

    @Override
    public void RemoveUnit(int unitID)
    {
        UnitFactory.Delete(unitID);
    }


}
