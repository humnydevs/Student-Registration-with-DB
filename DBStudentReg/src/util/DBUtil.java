
package util;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    private static Connection connection = null;
    private static final String connStr = "jdbc:mysql://localhost/fxdemo";
    
    public static void dbConnect() throws SQLException, ClassNotFoundException {
        
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MYSQL Driver");
            e.printStackTrace();
            throw e;
        }
        System.out.println("JDBC Driver has been Registered");
        
        try {
            connection = DriverManager.getConnection(connStr, "root", "ov6W7P(@");
        } catch (SQLException e) {
            System.out.println("Connection Failed Check output console");
            throw e;
        }
    }
    
    public static void dbDisconnect() throws SQLException {
        
        try {
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    //this method is for insert, update and delete query
    public static void dbExecuteQuery(String sqlStmt) throws SQLException, ClassNotFoundException{
        Statement stmt = null;
        try {
            dbConnect();
            stmt = connection.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch (Exception e) {
            System.out.println("problem occurred at dbExecuteQuery operation" + e);
            throw e;
        }
        finally{
            if(stmt != null){
                stmt.close();
            }
            dbDisconnect();
        }
        
    }
    
    
    //this for retrieving result from database
    public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException, SQLException{
        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSetImpl crs = null;
        
        try {
            dbConnect();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            crs = new CachedRowSetImpl();
            crs.populate(rs);
        } catch (Exception e) {
            System.out.println("Error Ocurred in dbExecute Operation" + e);
            throw e;
        }
        finally{
            if(rs != null){
                rs.close();
        }
            if(stmt != null){
                stmt.close();
            }
            dbDisconnect();
    }
    return crs;
    
    }
    
    
    
}
