/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;

/**
 *
 * @author Domi
 */
public class SqlConnection {
     private static final String SERVER_NAME = "DESKTOP-15PJMQP";
    private static final String DATABASE_NAME = "JW_DB";
    private static final String USER = "AdminJavaWeb"; 
    private static final String PASSWORD = "admin"; 

    private SqlConnection() {}

    private static DataSource instance;
    
    public static DataSource getInstance() {
        if (instance == null)  {
            instance = createInstance();
        }
        return instance;
    }
    
    private static DataSource createInstance() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName(SERVER_NAME);
        dataSource.setDatabaseName(DATABASE_NAME);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }    
}
