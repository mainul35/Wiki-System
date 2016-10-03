/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiki.DataModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 *
 * @author Mainul35
 */
public class SetupDatabase {
    public static Connection con;
    public static Statement stmt;
    public SetupDatabase() throws SQLException{
        
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:Wiki.db");
            stmt = con.createStatement();
            stmt.setQueryTimeout(30);
            stmt.executeUpdate("drop table if exists user");
            stmt.executeUpdate("create table if not exists user("
                    + "role string,"
                    + "username string primary key,"
                    + "password string,"
                    + "readPermission boolean,"
                    + "editPermission BOOLEAN,"
                    + "permissionGiven BOOLEAN"
                    + ")");
            
            stmt.executeUpdate("drop table if exists pageDetails");
            
            stmt.executeUpdate("create table if not exists pageDetails("
                    + "userRole string," 
                    + "username string,"
                    + "pageTitle string,"
                    + "pageURI string,"
                    + "pageVersion integer"
                    + ")");
            con.close();
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }finally{
//            con.close();
//            stmt.close();
        }
    }
}
