/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiki.DataModel.StoreData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static wiki.DataModel.SetupDatabase.con;

/**
 *
 * @author Mainul35
 */
public class CreateVersionInformation {

    public CreateVersionInformation() {
    }
    
    public CreateVersionInformation(String userRole, String username, String pageTitle, String URI, int version) throws SQLException{
        
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:Wiki.db");
            Statement statement = con.createStatement();
            System.err.println(username+"\t"+pageTitle+"\t"+URI+"\t"+version);
            statement.setQueryTimeout(30);
            statement.executeUpdate("insert into pageDetails values("
                    + "'"+userRole+"',"
                    + "'"+username+"',"
                    + "'"+pageTitle+"',"
                    + "'"+URI+"',"
                    + ""+version+""
                    + ")");
            con.close();
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addPageVersion(String userRole, String username, String pageTitle, String URI, int version){
        try {
            CreateVersionInformation createVersionInformation = new CreateVersionInformation(userRole, username, pageTitle, URI, version);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CreateVersionInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
