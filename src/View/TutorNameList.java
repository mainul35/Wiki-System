/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.MiddleWare;
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
public class TutorNameList extends JList<Object> {
    
    static String userRole = null;
//    JList userBlogList;
    static String[] links = null;
    
    public TutorNameList(String userRole) {
        this.userRole = userRole;
        String[] tutorNames = MiddleWare.readUserData.getUserNamesByUserRole("Tutor");
        DefaultListModel dlm = new DefaultListModel();
        this.setModel(dlm);
        for (int x = 0; x < tutorNames.length; x++) {
            dlm.addElement(tutorNames[x]);
        }
        this.addMouseListener(new MouseClickListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                TutorNameList unl = (TutorNameList) me.getSource();
                ArrayList<VersionInformation> vi = MiddleWare.readVersionData.getBlogListOfUser("Tutor", unl.getSelectedValue().toString());
                links = new String[vi.size()];
                DefaultListModel dlm1 = new DefaultListModel();
                for (int x = 0; x < vi.size(); x++) {
                    String title = vi.get(x).getPageTitle();
                    links[x] = vi.get(x).getURI();
                    dlm1.addElement(title);
                }
                TutorWikiPanel.ubl.setModel(dlm1);
                TutorWikiPanel.ubl.addMouseListener(new MouseClickListener() {

                    @Override
                    public void mouseClicked(MouseEvent me) {
                        FileInputStream fis = null;
                        String content = "";
                        try {
                            JList li = (JList) me.getSource();
                            int index = li.getSelectedIndex();
                            fis = new FileInputStream(links[index]);
                            int i = 0;
                            while ((i = fis.read()) != -1) {
                                content += (char) i;
                            }
                            System.out.println(content);

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

                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException | NullPointerException ex) {
                            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                TutorWikiPanel.ubl.repaint();
            }
        });
        this.repaint();
    }

}
