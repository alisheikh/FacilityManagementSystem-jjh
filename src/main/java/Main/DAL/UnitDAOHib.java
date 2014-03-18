package Main.DAL;

/**
 * Created by Jackson on 3/16/14.
 */
public class UnitDAOHib  {
    /*private IDatabaseConnector connector;
    private Connection connection;

    @Override
    public void CreateUnit(List<Unit> units) throws SQLException {
        for(Unit unit:units){
            CreateUnit(unit);
        }

    }

    @Override
    public Unit CreateUnit(Unit unit) throws SQLException {
        Session session = HibernatePGSQLHelper.getSessionFactory();
        session.beginTransaction();
        session.save(unit);
        session.getTransaction().commit();

        return unit;
    }

    @Override
    public Unit GetUnit(int unit_id) throws SQLException {
        try {
            System.out.println("*************** Searcing for unit information with ID ...  " + unit_id);
            Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            //System.out.println("*************** Hibernate session is created ..................\n" + session.toString());

            //Query getCustQuery = session.createQuery("From CustomerImpl ");
            Query getCustQuery = session.createQuery("From CustomerImpl where unitId=:unit_id");
            getCustQuery.setInteger("unit_id", unit_id);

            System.out.println("*************** Retrieve Query is ....>>\n" + getCustQuery.toString());

            List units = getCustQuery.list();
            //System.out.println("Getting Book Details using HQL. \n" + units);

            session.getTransaction().commit();
            return (Unit)units.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Unit UpdateUnit(Unit unit) throws Exception {
        return null;
    }

    @Override
    public List<Unit> GetUnitForFacility(int id) throws SQLException {
        return null;
    }

    @Override
    public void DeleteUnit(int id) {

    }

    public IDatabaseConnector getConnector() {
        return connector;
    }

    public void setConnector(IDatabaseConnector connector) {
        this.connector = connector;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    } */
}
