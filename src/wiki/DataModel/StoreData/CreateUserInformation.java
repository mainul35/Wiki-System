/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiki.DataModel.StoreData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static wiki.DataModel.SetupDatabase.con;

/**
 *
 * @author Mainul35
 */
public class CreateUserInformation {
    private boolean create = false;
    private boolean edit = false;
    private boolean delete = false;
    private String userName = null;
    private String password = null;
    private String roleOfUser = null;
    
    public boolean createUserInformation(String roleOfUser, String username, String password, boolean createPermission, boolean editPermission, boolean deletePermission) throws SQLException{
        this.userName = username;
        this.password = password;
        this.roleOfUser = roleOfUser;
        this.create = createPermission;
        this.edit = editPermission;
        this.delete = deletePermission;
        
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:Wiki.db");
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("insert into user values("
                    + "'"+this.roleOfUser+"',"
                    + "'"+this.userName+"',"
                    + "'"+this.password+"',"
                    + "'"+this.create+"',"
                    + "'"+this.edit+"',"
                    + "'"+this.delete+"'"
                    + ")");
            con.close();
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public CreateUserInformation() {
    }
    
    protected void setCreatePermissionStatus(boolean status){
        this.create = status;
    }
    
    protected void setEditPermissionStatus(boolean status){
        this.edit = status;
    }
    
    protected void setDeletePermissionStatus(boolean status){
        this.delete = status;
    }
    
    public boolean getCreatePermissionStatus(){
        return this.create;
    }
    
    public boolean getEditPermissionStatus(){
        return this.edit;
    }
    
    public boolean getDeletePermissionStatus(){
        return this.delete;
    }
    
    public String getUSerRole(){
        return this.roleOfUser;
    }
    
    protected void setUserRole(String userRole){
        this.roleOfUser = userRole;
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    protected void setUserName(String username){
        this.userName = username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    protected void setPassword(String password){
        this.password = password;
    }
    
    public static void createDirectory(String dirName){
        File dir = new File("Wiki\\"+dirName);
        boolean isDirAvailable = dir.exists();
        if(!isDirAvailable){
            dir.mkdir();
        }
    }
    
//    public static void createFile(String URI, JTextArea textArea){
//        
//        
//    } 
}
