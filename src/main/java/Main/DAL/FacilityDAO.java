package Main.DAL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.FacilityImpl;
import Main.Entities.Facility.Unit;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class FacilityDAO implements IFacilityDAO {
    private IUnitDAO unitDAO;
    private DatabaseConnector databaseConnector;

    @Override
    public Facility create(Facility facility) {
        Session session = databaseConnector.connect();
        session.beginTransaction();


          int facilityId = (Integer) session.save(facility);
          facility.setFacilityId(facilityId);

        for(Unit unit:facility.getUnits()){

            unit.setFacility(facility);
           session.save(unit);

        }


        session.getTransaction().commit();

        return facility;

    }

    @Override
    public Facility update(Facility facility) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(facility);
        session.getTransaction().commit();
        session.close();
        return facility;
    }

    @Override
    public void delete(Facility facility) {


        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.delete(facility);
        session.getTransaction().commit();
        session.close();


	}

	@Override
    public Facility get(int id) {
        try {
            Session session = DatabaseConnector.connect();
            session.beginTransaction();
            Query getFacilityQuery = session.createQuery("From FacilityImpl where facilityId=:id");
            getFacilityQuery.setInteger("id",id);
            List facilities = getFacilityQuery.list();
            session.getTransaction().commit();
            session.close();
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
        Session session = DatabaseConnector.connect();
        System.out.println(session.toString());
        Query query = session.createQuery("from FacilityImpl");
        System.out.println(session.createQuery("from FacilityImpl").toString());
        List<Facility> facilities;
        session.beginTransaction();
        facilities = query.list();
        session.close();

        return facilities;
    }

    @Override
    public IUnitDAO getUnitDAO(){
        return unitDAO;
    }

    @Override
    public void setUnitDAO(IUnitDAO unitDAO){
        this.unitDAO = unitDAO;
    }

    @Override
    public DatabaseConnector getDatabaseConnector() {
        return databaseConnector;
    }

    @Override
    public void setDatabaseConnector(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }
}
