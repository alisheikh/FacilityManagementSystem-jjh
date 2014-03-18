package Main.DAL;


import Main.Entities.maintenance.MaintenanceRequest;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


public class MaintenanceRequestDAO implements IMaintenanceRequestDAO {


    @Override
    public MaintenanceRequest create(MaintenanceRequest request)
    {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(request);
        session.getTransaction().commit();
        session.close();
        return request;
    }

	@Override
    public MaintenanceRequest update(MaintenanceRequest request) throws Exception {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(request);
        session.getTransaction().commit();
        session.close();
        return request;
    }

	@Override
    public void delete(MaintenanceRequest request) {

        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.delete(request);
        session.getTransaction().commit();
        session.close();

	}

    /*
    * @return maintenance request
    * null if no records are found
    * */
	@Override
    public MaintenanceRequest get(int id)
    {
        try {
            Session session = DatabaseConnector.connect();
            session.beginTransaction();
            Query getCustQuery = session.createQuery("From MaintenanceRequestImpl where id=:id");
            getCustQuery.setInteger("id", id);

            List requests = getCustQuery.list();

            session.getTransaction().commit();
            session.close();
            return (MaintenanceRequest)requests.get(0);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;

	}

    @Override
    public List<MaintenanceRequest> getAll(int unitId) {
        Session session = DatabaseConnector.connect();
        Query query = session.createQuery("From MaintenanceRequestImpl where unit.id=:unitId");
        query.setString("unitId",String.valueOf(unitId));
        List<MaintenanceRequest> requests;
        session.beginTransaction();
        requests = query.list();
        session.close();
        return requests;
    }


}
