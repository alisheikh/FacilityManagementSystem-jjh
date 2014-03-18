package Main.BL;

import Main.DAL.*;
import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;
import org.hibernate.Session;

import java.util.List;


public class FacilityService implements IFacilityService {

    private Facility facility;

    private IFacilityDAO facilityDAO;
    private IUnitDAO unitDAO;

    public FacilityService(){
        facilityDAO = new FacilityDAO();
        unitDAO = new UnitDAO();
    }


    @Override
    public List<Facility> listFacilities() {
        Session session = DatabaseConnector.connect();
        System.out.println(session.toString());
        List<Facility> res = facilityDAO.getAll();
        return res;
    }

    @Override
    public Facility getFacilityInformation(int id) {
        Facility res = facilityDAO.get(id);
        return res;
    }

    @Override
    public int requestAvailibleCapacity(int facilityId,int unitID) {

        Facility res = facilityDAO.get(facilityId);
        List<Unit> units = res.getUnits();
        for(Unit unit:units){
            if(unit.getId() == unitID) return unit.getCapacity();
        }
        return 0;
    }

    @Override
    public Facility addNewFacility(Facility facility) {
        List<Unit> units = facility.getUnits();
        for(Unit unit:units){
            System.out.println(unit.getUnitNumber());

        }
        return facilityDAO.create(facility);
    }

    @Override
    public Unit addFacilityDetail(int facilityid,Unit unit) {
        unitDAO.create(unit);
        Facility facility = facilityDAO.get(facilityid);
        List<Unit> units = facility.getUnits();
        units.add(unit);
        facility.setUnits(units);
        facilityDAO.update(facility);
        return unit;

    }

    @Override
    public void removeFacility(Facility facility) {
        facilityDAO.delete(facility);
    }

    @Override
    public void removeUnit(Unit unit1) {
        unitDAO.delete(unit1);
    }

}