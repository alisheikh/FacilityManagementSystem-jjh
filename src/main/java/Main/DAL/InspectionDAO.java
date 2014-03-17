package Main.DAL;


import Main.Entities.Facility.Facility;
import Main.Entities.maintenance.Inspection;
import Main.Entities.maintenance.InspectionImpl;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InspectionDAO implements IInspectionDAO {

    private Connection connection;
    private IFacilityDAO facilityDAO;
    private IMaintenanceStaffDAO maintenanceStaffDAO;

    public InspectionDAO() {

    }

	@Override
    public Inspection add(Inspection inspection) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(inspection);
        session.getTransaction().commit();
        return inspection;
	}

	@Override
    public Inspection update(Inspection inspection)
    {
        /*try{
                connection.createStatement().executeUpdate("UPDATE inspection" +
                    " SET (id,facility_id,inspection_staff_id,inspection_date)"+
                    "= ('"+inspection.getId()+"','"+inspection.getFacility().getId()+"','"+inspection.getInspectingStaff().getId()+
                        "','"+inspection.getInspectionDate()+"')" +
                    "WHERE id = "+inspection.getId());
            return inspection;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;*/
        return inspection;

	}

	@Override
    public void delete(Inspection inspection) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.delete(inspection);
        session.getTransaction().commit();

	}

	@Override
    public Inspection get(int id) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();

        //System.out.println("*************** Hibernate session is created ..................\n" + session.toString());

        //Query getCustQuery = session.createQuery("From CustomerImpl ");
        Query getCustQuery = session.createQuery("From inspection where id=:id");
        getCustQuery.setString("id", String.valueOf(id));

        System.out.println("*************** Retrieve Query is ....>>\n" + getCustQuery.toString());

        List customers = getCustQuery.list();
        System.out.println("Getting Book Details using HQL. \n" + customers);

        session.getTransaction().commit();
        return (Inspection)customers.get(0);
	}

    @Override
    public List<Inspection> listAllInspections(){
        List<Inspection> inspections = new ArrayList<Inspection>();
        Session session = DatabaseConnector.connect().getCurrentSession();
        Query query = session.createQuery("from inspection");
        session.beginTransaction();
        inspections = query.list();

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
