/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiki.DataModel.StoreData;

import Controller.MiddleWare;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wiki.DataModel.SetupDatabase;
import static wiki.DataModel.SetupDatabase.con;

/**
 *
 * @author Mainul35
 */
public class ReadUserInformation {

    static String psw = null;

    public static String getPasswordByUserName(String uname) throws SQLException {

        try {
            Class.forName("org.sqlite.JDBC");
            SetupDatabase.con = DriverManager.getConnection("jdbc:sqlite:wiki.db");
            SetupDatabase.stmt = SetupDatabase.con.createStatement();
            SetupDatabase.stmt.setQueryTimeout(2);
            System.err.println(uname);
            ResultSet rs = SetupDatabase.stmt.executeQuery("Select * from user where username = '" + uname + "'");
            while (rs.next()) {
                psw = "" + rs.getObject("password");
                System.err.println(psw);
                return psw;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(MiddleWare.getAdminLoginWindowInstance(), "No such username.");
        } finally {
            con.close();
//            stmt.close();
        }

        return null;
    }

    public String getGivenPermissionStatus(String uname) throws SQLException {

        String readPermission = null;
        String editPermission = null;
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:wiki.db");
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(30);
            ResultSet rs = stmt.executeQuery("Select * from user where permissionGiven = 'false' and username = '" + uname + "'");
            while (rs.next()) {
                readPermission = "" + rs.getObject("readPermission");
                editPermission = "" + rs.getObject("editPermission");
                if (readPermission.equalsIgnoreCase("false")) {
                    return "Read";
                } else if (editPermission.equals("false")) {
                    return "Edit";
                } else {
                    return "All permission";
                }
            }
//            return editPermission;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
//            stmt.close();
        }
        return null;
    }

    public static ArrayList<String> getGivenPermissionStatus() throws SQLException {
        String username = null;
        String readPermission = null;
        String editPermission = null;
        String userRole = null;
        ArrayList<String> al = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:wiki.db");
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(30);
            ResultSet rs = stmt.executeQuery("Select * from user where permissionGiven = 'false'");
            while (rs.next()) {
                userRole = "" + rs.getObject("role");
                username = "" + rs.getObject("username");
                readPermission = "" + rs.getObject("readPermission");
                editPermission = "" + rs.getObject("editPermission");
                if (readPermission.equalsIgnoreCase("false") && editPermission.equals("false")) {
                    al.add(username + " " + userRole + " All");
                } else if (readPermission.equalsIgnoreCase("false")) {
                    al.add(username + " " + userRole + " Read");
                } else if (editPermission.equals("false")) {
                    al.add(username + " " + userRole + " Edit");
                }
            }
            con.close();
            return al;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return al;
    }

    public CreateUserInformation retriveInformationByUserName(String uname) throws SQLException {
        CreateUserInformation p = new CreateUserInformation();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:wiki.db");
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(30);
            ResultSet rs = stmt.executeQuery("Select * from user where username = '" + uname + "'");
            while (rs.next()) {
                p.setUserRole("" + rs.getObject("role"));
                p.setUserName("" + rs.getObject("username"));
                p.setPassword("" + rs.getObject("password"));
                p.setCreatePermissionStatus(Boolean.getBoolean("" + rs.getObject("createPermission")));
                p.setEditPermissionStatus(Boolean.getBoolean("" + rs.getObject("editPermission")));
                p.setDeletePermissionStatus(Boolean.getBoolean("" + rs.getObject("deletePermission")));
            }
            con.close();
//            stmt.close();
            return p;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
//            stmt.close();
        }
//        return editPermission;
        return null;
    }

    public static String hasWritePermission(String userName) throws SQLException {
        String writePermissionStatus = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:wiki.db");
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(30);
            ResultSet rs = stmt.executeQuery("select editPermission from user where username = '" + userName + "'");
            while (rs.next()) {
                writePermissionStatus = rs.getString(UpdateUserInformation.EDIT_PERMISSION);
            }
            con.close();
            return writePermissionStatus;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return writePermissionStatus;
    }

    public static String hasReadPermission(String userName) throws SQLException {
        String readPermissionStatus = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:wiki.db");
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(30);
            ResultSet rs = stmt.executeQuery("select readPermission from user where username = '" + userName + "'");
            while (rs.next()) {
                readPermissionStatus = rs.getString(UpdateUserInformation.EDIT_PERMISSION);
            }
            con.close();
            return readPermissionStatus;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readPermissionStatus;
    }

//    public static void main(String[] args) {
//
//    }
    public boolean checkLogInData(String userName, String password) throws SQLException {
//        ReadUserInformation uinf = new ReadUserInformation();
        try {
//            System.out.println(ReadUserInformation.getPasswordByUserName(userName));
            if (ReadUserInformation.getPasswordByUserName(userName).equals(password)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Password missmatched!");
                return false;
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
//            npe.printStackTrace();
            JOptionPane.showMessageDialog(null, "No such Username.");
        }

        return false;
    }
    
    public String[] getUserNamesByUserRole(String userRole) {

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:wiki.db");
//             stmt = con.createStatement();

            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(30);
            ResultSet rs = stmt.executeQuery("select username from user where role = '" + userRole + "'");
            int size = 0;

            while (rs.next()) {
                System.err.println(size);
//                System.out.println(rs.getString("username"));
                size++;
            }
            rs = stmt.executeQuery("select username from user where role = '" + userRole + "'");
            String[] uNames = new String[size];
            int x = 0;
            while (rs.next()) {
                uNames[x] = rs.getString("username");
//                System.out.println(uNames[x]);
                x++;
            }
//            System.out.println(Arrays.toString(uNames)+"\tLine 235");
//            con.close();
            return uNames;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(ReadUserInformation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ReadUserInformation.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReadUserInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
