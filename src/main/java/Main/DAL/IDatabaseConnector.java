package Main.DAL;

import java.sql.Connection;

/**
 * Created by john on 2/5/14.
 */
public interface IDatabaseConnector {
    Connection GetConnection();
}
