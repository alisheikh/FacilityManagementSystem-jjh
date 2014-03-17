package Main.DAL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;
import Main.Entities.Facility.UnitImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import java.sql.SQLException;
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
    public Facility get(String name) {
        try {
            Session session = DatabaseConnector.connect().getCurrentSession();
            session.beginTransaction();
            Query getFacilityQuery = session.createQuery("From facility where name=:name");
            getFacilityQuery.setString("name", name);
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


        try {
            return unit.GetUnitForFacility(facilityId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return units;


    }



    @Override
    public List<Facility> getAll() {
        Session session = DatabaseConnector.connect().getCurrentSession();
        Query query = session.createQuery("from facility");
        List<Facility> facilities = new ArrayList<Facility>();
        session.beginTransaction();
        facilities = query.list();
        return facilities;
    }

    @Override
    public Unit getUnit(int unitId){
        try {
            return unit.GetUnit(unitId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new UnitImpl();
    }

}
