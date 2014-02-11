package Main.BL;

import Main.DAL.FacilityDAO;
import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;

import java.util.List;


public class FacilityService implements IFacilityService {

    private Facility facility;


    @Override
    public List<Facility> listFacilities() {
        List<Facility> res = new FacilityDAO().getAll();
        return res;
    }

    @Override
    public Facility getFacilityInformation(int id) {
        Facility res = new FacilityDAO().get(id);
        return res;
    }

    @Override
    public int requestAvailibleCapacity(int facilityId,int unitID) {
        FacilityDAO dao = new FacilityDAO();
        Facility res = dao.get(facilityId);
        List<Unit> units =res.getUnits();
        for(Unit unit:units){
            if(unit.getId() == unitID) return unit.getCapacity();
        }
        return 0;
    }

    @Override
    public Facility addNewFacility(Facility facility) {
        return new FacilityDAO().create(facility);
    }

    @Override
    public Unit addFacilityDetail(int facilityid,Unit unit) {
        FacilityDAO dao = new FacilityDAO();
        Facility res = dao.get(facilityid);
        List<Unit> units =res.getUnits();
        units.add(unit);
        res.setUnits(units);
        dao.update(res);
        return unit;

    }

    @Override
    public void removeFacility(Facility facility) {
        new FacilityDAO().delete(facility);
    }

}