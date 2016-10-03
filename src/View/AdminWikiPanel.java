/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Mainul35
 */
public class AdminWikiPanel extends JPanel{
    static JList ubl;
    static JScrollPane jscpb;
    public AdminWikiPanel(String userRole, String userName) {
        AdminNameList unl = new AdminNameList(userRole);
        ubl = new JList();
        
        JScrollPane jscpn = new JScrollPane(unl);
        this.setLayout(new BorderLayout(5, 0));
        this.add(jscpn, BorderLayout.WEST);
        
        jscpb = new JScrollPane(ubl);
        this.add(jscpb);
    }
}
