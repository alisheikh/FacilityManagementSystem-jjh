package Main.DAL;

/**
 * Created by john on 2/5/14.
 */
public interface IDatabaseConnectionFactory {

    public IDatabaseConnector getConnection();//do we need a parameter?
}
