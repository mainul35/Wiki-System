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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mainul35
 */
public class ReadVersionInformation {
        public int getLatestVersion(String username, String pageTitle) {
            Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:Wiki.db");
            Statement statement = con.createStatement();
//        System.err.println(username+"\t"+pageTitle+"\t"+URI+"\t"+version);
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("select pageVersion "
                + "from pageDetails pd "
                + "where pageVersion = (select max(p.pageVersion) from pageDetails p where p.pageTitle= pd.pageTitle and p.userRole = pd.userRole)"
                + " and username = '"+username+"'"
                + " and pageTitle = '"+pageTitle+"'"
            );
            int pageVersion = Integer.parseInt(rs.getString("pageVersion"));
            return pageVersion;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(CreateVersionInformation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CreateVersionInformation.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReadVersionInformation.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return 0;
    }
    
    public String getPageTitleByURI(String URI){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:Wiki.db");
//            Statement statement = ;
//        System.err.println(username+"\t"+pageTitle+"\t"+URI+"\t"+version);
//            statement.setQueryTimeout(30);
            ResultSet rs= con.createStatement().executeQuery("select * from pageDetails where pageURI = '"+URI+"'");
            String pageTitle = rs.getString("pageTitle");
            con.close();
            return pageTitle;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(CreateVersionInformation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CreateVersionInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getLatestVersionURI(int latestVersion, String pageTitle, String username){
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:Wiki.db");
            Statement statement = con.createStatement();
//        System.err.println(username+"\t"+pageTitle+"\t"+URI+"\t"+version);
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("select pageURI from pageDetails where pageVersion = '"+latestVersion+"' and pageTitle = '"+pageTitle+"' and username = '"+username+"'");
            String URI = rs.getString("pageURI");
            return URI;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
                Logger.getLogger(ReadVersionInformation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
                Logger.getLogger(ReadVersionInformation.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReadVersionInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList<VersionInformation> getBlogListOfUser(String userRole, String userName){
        ArrayList<VersionInformation> versionInformation = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:Wiki.db");
            Statement statement = con.createStatement();
//        System.err.println(username+"\t"+pageTitle+"\t"+URI+"\t"+version);
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("select *" 
                    +" from pageDetails pd" 
                    +" where pageVersion = (select max(p.pageVersion)"
                        + " from pageDetails p "
                        + "where p.pageTitle= pd.pageTitle "
                        + "and p.userRole = pd.userRole)"
                    +" and userRole = '"+userRole+"'"
                    + "and userName = '"+userName+"'");
            
            while (rs.next()) {                
                VersionInformation vi = new VersionInformation();
                vi.setUsername(rs.getString("username"));
                vi.setUserRole(rs.getString("userRole"));
                vi.setPageTitle(rs.getString("pageTitle"));
                vi.setURI(rs.getString("pageURI"));
                vi.setVersionNumber(Integer.parseInt(rs.getString("pageVersion")));
                versionInformation.add(vi);
            }
            con.close();
            return versionInformation;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
                Logger.getLogger(ReadVersionInformation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
                Logger.getLogger(ReadVersionInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
