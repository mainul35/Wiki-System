/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.AdminLoginWindow;
import View.AdminPanel;
import View.AdminSignupWindow;
import View.MainWindow;
import View.StudentLoginWindow;
import View.StudentPanel;
import View.TutorLoginWindow;
import View.TutorPanel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import wiki.DataModel.StoreData.CreateUserInformation;
import wiki.DataModel.StoreData.CreateVersionInformation;
import wiki.DataModel.StoreData.ReadUserInformation;
import wiki.DataModel.StoreData.ReadVersionInformation;
import wiki.DataModel.StoreData.UpdateUserInformation;

/**
 *
 * @author Mainul35
 */
public class MiddleWare {
//    private static String nameOfUserLoggIn;
    private static AdminLoginWindow adminLoginWindow = new AdminLoginWindow();
    private static TutorLoginWindow tutorLoginWindow = new TutorLoginWindow();
    private static StudentLoginWindow studentLoginWindow = new StudentLoginWindow();
    public static final CreateUserInformation insertUserData = new CreateUserInformation();
    public static final ReadUserInformation readUserData = new ReadUserInformation();
    public static final UpdateUserInformation updateUserData = new UpdateUserInformation();
    public static final CreateVersionInformation createVersionData = new CreateVersionInformation();
    public static final ReadVersionInformation readVersionData = new ReadVersionInformation();
//    public static AdminPanel adminPanel = new AdminPanel();
//    public static StudentPanel studentPanel = new StudentPanel();
//    public static TutorPanel tutorPanel = new TutorPanel();
    
    
    private static MainWindow mainWindow = new MainWindow();
//    private static AdminSignupWindow asw = new AdminSignupWindow();
    
    public static String uname;
    
//    public static void setNameOfCurrentUser(String name){
//        nameOfUserLoggIn = name;
//    }
//    
//    public static String getNameOfCurrentUser(){
//        return nameOfUserLoggIn;
//    }
    
    public static JFrame getAdminLoginWindowInstance(){
        return adminLoginWindow;
    }
    
    public static JFrame getTutorLoginWindowInstance(){
        return tutorLoginWindow;
    }
    
    public static JFrame getStudentLoginWindowInstance(){
        return studentLoginWindow;
    }
    
    public static JFrame getMainWindowInstance(){
        return mainWindow;
    }
    
    public static void createAdmin(String uname, String password) throws SQLException {
        CreateUserInformation privilege = new CreateUserInformation();
        if(privilege.createUserInformation("Admin", uname, password, true, true, true)==true){
            JOptionPane.showMessageDialog(new AdminSignupWindow(), "Congratulation, your ID has been created.\n"
                        + "Please note down your username and password.\n"
                        + "<html><h3>Remember:</h3> Username is case sensitive.<br>"
                        + "Please go back to log in.</html>");
        }else{
            JOptionPane.showMessageDialog(null, "Sorry, this username already exists in the database.\n"
                    + "Please try another one.");
        }
    }
    
    public static void createStudent(String uname, String password) throws SQLException {
        CreateUserInformation privilege = new CreateUserInformation();
        if(privilege.createUserInformation("Student", uname, password, true, false, false)==true){
            JOptionPane.showMessageDialog(new AdminSignupWindow(), "Congratulation, your ID has been created.\n"
                        + "Please note down your username and password.\n"
                        + "<html><h3>Remember:</h3> Username is case sensitive.<br>"
                        + "Please go back to log in.</html>");
        }else{
            JOptionPane.showMessageDialog(null, "Sorry, this username already exists in the database.\n"
                    + "Please try another one.");
        }
    }
    
    public static void createTutor(String uname, String password) throws SQLException {
        CreateUserInformation privilege = new CreateUserInformation();
        if(privilege.createUserInformation("Tutor", uname, password, true, true, true)==true){
            JOptionPane.showMessageDialog(new AdminSignupWindow(), "Congratulation, your ID has been created.\n"
                        + "Please note down your username and password.\n"
                        + "<html><h3>Remember:</h3> Username is case sensitive.<br>"
                        + "Please go back to log in.</html>");
        }else{
            JOptionPane.showMessageDialog(null, "Sorry, this username already exists in the database.\n"
                    + "Please try another one.");
        }
    }
    
    public static void createNewPage(String userRole, String username, String pageTitle, String URI, int version){
        try {
            CreateVersionInformation createVersionInformation = new CreateVersionInformation(userRole, username, pageTitle, URI, version);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MiddleWare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
