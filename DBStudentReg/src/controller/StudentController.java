
package controller;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Student;
import model.StudentDAO;


public class StudentController {
    
    
    
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLasttName;
    @FXML
    private TextField txtEmail;
    
    
    @FXML
    private TextArea resultConsole;
    @FXML
    private TextField searchStuID;
    @FXML
    private TextField searchStuEmail;
    @FXML
    private TableColumn<Student, Integer> colStuId;
    @FXML
    private TableColumn<Student, String> colStuName;
    @FXML
    private TableColumn<Student, String> colLastName;
    @FXML
    private TableColumn<Student, String> colStuEmail;
    
    @FXML
    private TableView studentTable;
    
    @FXML
    private void insertStudent(ActionEvent event) throws ClassNotFoundException, SQLException{
        StudentDAO.insertStudent(Integer.parseInt(txtID.getText()), txtFirstName.getText(), txtLasttName.getText(), txtEmail.getText());
         resultConsole.setText("Success! Value Has been added to Database.");
    }
    
    
            public void clearLabel(ActionEvent event) throws ClassNotFoundException, SQLException{
                txtID.setText("");
                txtFirstName.setText(null);
                txtLasttName.setText(null);
                txtEmail.setText(null);
                
            }
            
    @FXML
    private void updateStudent(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {
            StudentDAO.updateStudent(Integer.parseInt(searchStuID.getText()), searchStuEmail.getText());
             resultConsole.setText("Success! The Record Has been updated Scuccessfully.");
        } catch (SQLException e) {
            System.out.println("Error Occur while Updating " + e);
            e.printStackTrace();
            throw e;
        }
    }
    
    @FXML
    private void deleteStudent(ActionEvent event)throws SQLException, ClassNotFoundException{
        try {
            StudentDAO.deleteStudentById(Integer.parseInt(searchStuID.getText()));
            resultConsole.setText("Oow!!!, Record has been Deleted");
        } catch (SQLException e) {
            System.out.println("Error occur while Deleting the Record" +e);
            e.printStackTrace();
            throw e;
        }
    }
    
    @FXML
    private void initialize() throws Exception{
        colStuId.setCellValueFactory(cellData -> cellData.getValue().getStudentId().asObject());
        colStuName.setCellValueFactory(cellData -> cellData.getValue().getStudentName());
        colLastName.setCellValueFactory(cellData -> cellData.getValue().getStudentLastName());
        colStuEmail.setCellValueFactory(cellData -> cellData.getValue().getStudentEmail());
        ObservableList<Student> stuList = StudentDAO.getAllRecords();
        populateTable(stuList);
    }

    private void populateTable(ObservableList<Student> stuList) {
        
        studentTable.setItems(stuList);
        
        
        
        
    }
    
}
