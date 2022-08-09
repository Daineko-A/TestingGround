package db;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManagerTest {

    @Test
    public void getConnectionTest() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        connection.close();
    }
}