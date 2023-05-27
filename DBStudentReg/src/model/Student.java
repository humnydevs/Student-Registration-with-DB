
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private IntegerProperty idProperty;
    
    private StringProperty nameProperty;
    
    private StringProperty lastNameProperty;
    
    private StringProperty emailProperty;
    
    public Student(){
        this.idProperty = new SimpleIntegerProperty();
        this.nameProperty = new SimpleStringProperty();
        this.lastNameProperty = new SimpleStringProperty();
        this.emailProperty = new SimpleStringProperty();
    }
    
    public int getStuId(){
        return idProperty.get();
    }
    
    public void setStuId(int id){
        this.idProperty.set(id);
    }
    
    public IntegerProperty getStudentId(){
        return idProperty;
    }
    
    public String getStuName(){
        return nameProperty.get();
    }
    
    public void setStuName(String first_Name){
        this.nameProperty.set(first_Name);
    }
    
    public StringProperty getStudentName(){
        return nameProperty;
    }
    
    public String getStuLastName(){
        return lastNameProperty.get();
    }
    
    public void setStuLastName(String last_Name){
        this.lastNameProperty.set(last_Name);
    }
    
    public StringProperty getStudentLastName(){
        return lastNameProperty;
    }
    
    public String getStuEmail(){
        return emailProperty.get();
    }
    
    public void setStuEmail(String email){
        this.emailProperty.set(email);
    }
    
    public StringProperty getStudentEmail(){
        return emailProperty;
    }
}
