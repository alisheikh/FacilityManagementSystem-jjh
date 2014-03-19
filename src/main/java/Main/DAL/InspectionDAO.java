package Main.DAL;


import Main.Entities.maintenance.Inspection;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Connection;
import java.util.List;

public class InspectionDAO implements IInspectionDAO {

    private Connection connection;
    private IFacilityDAO facilityDAO;
    private IMaintenanceStaffDAO maintenanceStaffDAO;

    public InspectionDAO() {

    }

	@Override
    public Inspection add(Inspection inspection) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(inspection);
        session.getTransaction().commit();
        session.close();
        return inspection;
	}

	@Override
    public Inspection update(Inspection inspection)
    {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(inspection);
        session.getTransaction().commit();
        session.close();
        return inspection;

	}

	@Override
    public void delete(Inspection inspection) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.delete(inspection);
        session.getTransaction().commit();
        session.close();

	}

	@Override
    public Inspection get(int id) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();

        //System.out.println("*************** Hibernate session is created ..................\n" + session.toString());

        //Query getCustQuery = session.createQuery("From CustomerImpl ");
        Query getCustQuery = session.createQuery("From InspectionImpl where id=:id");
        getCustQuery.setInteger("id", id);

        System.out.println("*************** Retrieve Query is ....>>\n" + getCustQuery.toString());

        List customers = getCustQuery.list();
        System.out.println("Getting Book Details using HQL. \n" + customers);

        session.getTransaction().commit();
        return (Inspection)customers.get(0);
	}

    @Override
    public List<Inspection> listAllInspections(){
        List<Inspection> inspections;
        Session session = DatabaseConnector.connect();
        Query query = session.createQuery("from InspectionImpl");
        session.beginTransaction();
        inspections = query.list();
            session.close();
        return inspections;
    }

    @Override
    public List<Inspection> listAllInspections(int facilityId){
        List<Inspection> inspections;
        Session session = DatabaseConnector.connect();
        Query query = session.createQuery("from InspectionImpl where facility.facilityId=:facilityID");
        session.beginTransaction();
        inspections = query.list();
              session.close();
        return inspections;
    }

     @Override
     public void setMaintenanceStaffDAO(IMaintenanceStaffDAO maintenanceStaffDAO) {
        this.maintenanceStaffDAO = maintenanceStaffDAO;
    }

    @Override
    public void setFacilityDAO(IFacilityDAO facilityDAO) {
        this.facilityDAO = facilityDAO;
    }
}
