/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiki.DataModel.StoreData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static wiki.DataModel.SetupDatabase.con;
import static wiki.DataModel.SetupDatabase.stmt;

/**
 *
 * @author Mainul35
 */
public class UpdateUserInformation {
    public static final String PASSWORD = "password";
    public static final String READ_PERMISSION = "readPermission";
    public static final String EDIT_PERMISSION = "editPermission";
    public static final String PERMISSION_STATUS = "permissionGiven";
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    
    public void updatePermissionStatus(String username, String colName, String colValue) throws SQLException{
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:wiki.db");
            stmt = con.createStatement();
            stmt.setQueryTimeout(30);            
            stmt.executeUpdate("update user set "+colName+" = '"+colValue+"' where username = '"+username+"'");        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            con.close();
//            stmt.close();
        }
    }
}
