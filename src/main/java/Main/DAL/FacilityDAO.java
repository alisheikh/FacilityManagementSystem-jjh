package Main.DAL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class FacilityDAO implements IFacilityDAO {
    UnitDAO unitDAO = new UnitDAO();

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
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(facility);
        session.getTransaction().commit();
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
            Query getFacilityQuery = session.createQuery("From facility where id=:id");
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

        return unitDAO.getAll(facilityId);

    }



    @Override
    public List<Facility> getAll() {
        Session session = DatabaseConnector.connect().getCurrentSession();
        System.out.println(session.toString());
        Query query = session.createQuery("from Facility");
        System.out.println(session.createQuery("from Facility").toString());
        List<Facility> facilities;
        session.beginTransaction();
        facilities = query.list();
        return facilities;
    }

    @Override
    public Unit getUnit(int unitId){
        return unitDAO.get(unitId);
    }

}
