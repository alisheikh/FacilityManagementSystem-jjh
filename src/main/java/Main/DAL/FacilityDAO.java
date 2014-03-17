package Main.DAL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class FacilityDAO implements IFacilityDAO {
    UnitDAO unit = new UnitDAO();

    @Override
    public Facility create(Facility facility) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(facility);
        session.getTransaction().commit();
        return facility;

    }

    @Override
    public Facility update(Facility facility) {
        /*for(Unit unit:facility.getUnits()){
            Unit check = getUnit(unit.getId());
            if(check.getId()==0){
                try{

                    try {
                        unitDAO.CreateUnit(unit);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }




                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
        try {
            connection.createStatement().executeUpdate("UPDATE facility" +
                    " SET (name,capacity,building_number)"+
                    "= ('"+facility.getName()+"','"+facility.getCapacity()+"','"+facility.getBuildingNumber()+"')" +
                    "WHERE id = "+facility.getId());

            for(Unit unit:facility.getUnits()){
                unit = unitDAO.UpdateUnit(unit);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return facility;
    }

    @Override
    public void delete(Facility facility) {


        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.delete(facility);
        session.getTransaction().commit();


	}

	@Override
    public Facility get(int id) {
        try {
            Session session = DatabaseConnector.connect().getCurrentSession();
            session.beginTransaction();
            Query getFacilityQuery = session.createQuery("From Facility where id=:id");
            getFacilityQuery.setString("id", String.valueOf(id));
            List facilities = getFacilityQuery.list();
            session.getTransaction().commit();
            return (Facility)facilities.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Unit> getUnitsForFacility(int facilityId)
    {
        List<Unit> units = new ArrayList<Unit>();

        return unit.getAll(facilityId);

    }



    @Override
    public List<Facility> getAll() {
        Session session = DatabaseConnector.connect().getCurrentSession();
        Query query = session.createQuery("from Facility");
        List<Facility> facilities = new ArrayList<Facility>();
        session.beginTransaction();
        facilities = query.list();
        return facilities;
    }

    @Override
    public Unit getUnit(int unitId){
        return unit.get(unitId);
    }

}
