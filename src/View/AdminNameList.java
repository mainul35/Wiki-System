/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.MiddleWare;
import static View.AdminPanel.revertButtonClicked;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import wiki.DataModel.StoreData.VersionInformation;

/**
 *
 * @author Mainul35
 */
public class AdminNameList extends JList<Object> {

    static String userRole = null;
//    JList userBlogList;
    static String userName = null;
    static String title = null;
    static String[] links = null;
    
    public AdminNameList(String userRole) {
        this.userRole = userRole;
        String[] adminNames = MiddleWare.readUserData.getUserNamesByUserRole("Admin");
        DefaultListModel dlm = new DefaultListModel();
        this.setModel(dlm);
        for (int x = 0; x < adminNames.length; x++) {
            dlm.addElement(adminNames[x]);
        }
        this.addMouseListener(new MouseClickListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                AdminNameList unl = (AdminNameList) me.getSource();
                userName = unl.getSelectedValue().toString();
//                AdminPanel.pageTitle = 
                ArrayList<VersionInformation> vi = MiddleWare.readVersionData.getBlogListOfUser("Admin", unl.getSelectedValue().toString());
                links = new String[vi.size()];
                DefaultListModel dlm1 = new DefaultListModel();
                for (int x = 0; x < vi.size(); x++) {
                    title = vi.get(x).getPageTitle();
                    links[x] = vi.get(x).getURI();
                    dlm1.addElement(title);
                }
                AdminWikiPanel.ubl.setModel(dlm1);
                AdminWikiPanel.ubl.addMouseListener(new MouseClickListener() {

                    @Override
                    public void mouseClicked(MouseEvent me) {
                        FileInputStream fis = null;
                        String content = "";
                        try {
                            JList li = (JList) me.getSource();
                            int index = li.getSelectedIndex();
                            fis = new FileInputStream(links[index]);
                            AdminPanel.currentPageURI = links[index];
                            int i = 0;
                            while ((i = fis.read()) != -1) {
                                content += (char) i;
                            }
                            System.out.println(content);
                            revertButtonClicked = 1;
                            if (userRole.equals("Admin")) {
                                AdminPanel.editorPane.setText(content);
                                AdminPanel.tabbedPane.setSelectedIndex(5);
                            } else if (userRole.equals("Tutor")) {
                                TutorPanel.editorPane.setText(content);
                                TutorPanel.tabbedPane.setSelectedIndex(4);
                            } else if (userRole.equals("Student")) {
                                StudentPanel.editorPane.setText(content);
                                StudentPanel.tabbedPane.setSelectedIndex(4);
                            }
                            fis.close();

                        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException ex) {
                            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                AdminWikiPanel.ubl.repaint();
            }
        });
        this.repaint();
    }

}
