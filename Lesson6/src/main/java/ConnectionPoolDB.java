import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Stack;

public class ConnectionPoolDB{

    private int initialConnections = 5;
    private Stack<Connection> connectionsAvailable = new Stack<>();
    private Stack<Connection> connectionsUsed =  new Stack<>();
    private Logger log=Logger.getLogger(ConnectionPoolDB.class);

    public ConnectionPoolDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int count = 0; count < initialConnections; count++) {
                connectionsAvailable.push(ConnectorDB.getConnection());
            }
            log.info("Created ConnectionPool");
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
    }

    public synchronized Connection getConnectionFromPool () {
        Connection newConnection;

        if (connectionsAvailable.size() != 0) {
            newConnection = connectionsAvailable.pop();
            connectionsUsed.push(newConnection);
            log.info("Connection got from pool");
        } else {
            newConnection = ConnectorDB.getConnection();
            connectionsUsed.push(newConnection);
            log.info("Pool is empty. New connection created.");
        }
        return newConnection;
    }

    public synchronized void returnConnectionToPool(Connection connection){
        if (connection!=null){
            connectionsAvailable.push(connection);
            connectionsUsed.pop();
            log.info("Connection returned to pool");
        }
    }
}
