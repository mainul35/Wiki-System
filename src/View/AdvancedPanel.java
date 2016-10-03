/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Mainul35
 */
public class AdvancedPanel extends JPanel{
    private int id = 0;

    public AdvancedPanel() {
    }

    public AdvancedPanel(LayoutManager layout) {
        super(layout);
    }

    public AdvancedPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public AdvancedPanel(int id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
}
