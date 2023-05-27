 
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;


public class StudentDAO {
    
    public static void insertStudent(int studentID, String firstName, String lastName, String email) throws ClassNotFoundException, SQLException{
        String sql = "insert into student(id, first_Name, last_Name, email) values('"+studentID+"','"+firstName+"', '"+lastName+"', '"+email+"');";
        
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception occur  while Inserting Data" + e);
            e.printStackTrace();
            throw e;
        }
    }
    
    public static void updateStudent(int id, String email) throws ClassNotFoundException, SQLException{
        String sql = "update student set email = '"+email+"' where id = '"+id+"'";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception while Updating the Record.");
            e.printStackTrace();
            throw e;
        }
    }
    
    public static void deleteStudentById(int id) throws SQLException, ClassNotFoundException{
        String sql = "delete from student where id = '"+id+"'";
        try {
            DBUtil.dbExecuteQuery(sql);
        } catch (SQLException e) {
            System.out.println("Exception while deleting the Record " +e);
            e.printStackTrace();
            throw e;
        }
    }
    
    public static ObservableList<Student> getAllRecords() throws SQLException, ClassNotFoundException{
        String sql = "select * from student";
        
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Student> stuList = getStudentObjects(rsSet);
            return stuList;
        } catch (SQLException e) {
            System.out.println("Error Occur while Fetching The Recor from Database "+e);
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Student> getStudentObjects(ResultSet rsSet) throws SQLException {

        try {
          ObservableList<Student> stulist = FXCollections.observableArrayList();
          
          while(rsSet.next()){
              Student stu = new Student();
              stu.setStuId(rsSet.getInt("id"));
              stu.setStuName(rsSet.getString("first_Name"));
              stu.setStuLastName(rsSet.getString("last_Name"));
              stu.setStuEmail(rsSet.getString("email"));
          }
          return stulist;
          
        } catch (SQLException e) {
            System.out.println("Error Occurred while Fetching Data from Database" +e);
            e.printStackTrace();
            throw e;
        }






    }
    
}
