
import Controller.MiddleWare;
import java.io.File;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import wiki.DataModel.SetupDatabase;
import wiki.DataModel.StoreData.CreateUserInformation;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mainul35
 */
public class Main {
    
    public static boolean deleteDir(File dir) {
      if (dir.isDirectory()) {
         String[] children = dir.list();
         for (int i = 0; i < children.length; i++) {
            boolean success = deleteDir
            (new File(dir, children[i]));
            if (!success) {
               return false;
            }
         }
      }
      return dir.delete();
//      System.out.println("The directory is deleted.");
  }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        try {
            UIManager.setLookAndFeel ("com.alee.laf.WebLookAndFeel");
            new SetupDatabase();
            deleteDir(new File("Wiki\\"));
            CreateUserInformation.createDirectory("");
        MiddleWare.getMainWindowInstance().setVisible(true);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
