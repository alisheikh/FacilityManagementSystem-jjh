package Main.DAL;


import Main.Entities.Facility.Unit;
import Main.Entities.maintenance.MaintenanceRequest;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MaintenanceRequestDAO implements IMaintenanceRequestDAO {


    @Override
    public MaintenanceRequest create(MaintenanceRequest request)
    {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(request);
        session.getTransaction().commit();

        return request;
    }

	@Override
    public MaintenanceRequest update(MaintenanceRequest request) throws Exception {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(request);
        session.getTransaction().commit();

        return request;
    }

	@Override
    public void delete(MaintenanceRequest request) {

        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.delete(request);
        session.getTransaction().commit();

	}

    /*
    * @return maintenance request
    * null if no records are found
    * */
	@Override
    public MaintenanceRequest get(int id)
    {
        try {
            Session session = DatabaseConnector.connect().getCurrentSession();
            session.beginTransaction();
            Query getCustQuery = session.createQuery("From MaintenanceRequest where id=:id");
            getCustQuery.setString("id", String.valueOf(id));

            List requests = getCustQuery.list();

            session.getTransaction().commit();
            return (MaintenanceRequest)requests.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

	}

    @Override
    public List<MaintenanceRequest> getAll(int unitId) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        Query query = session.createQuery("From MaintenanceRequest where unitId=:unitId");
        query.setString("unitId",String.valueOf(unitId));
        List<MaintenanceRequest> requests = new ArrayList<MaintenanceRequest>();
        session.beginTransaction();
        requests = query.list();
        return requests;
    }


}
