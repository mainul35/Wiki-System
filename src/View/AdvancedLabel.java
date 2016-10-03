/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JLabel;

/**
 *
 * @author Mainul35
 */
public class AdvancedLabel extends JLabel{
    private int id = 0;

    public AdvancedLabel() {
    }

    public AdvancedLabel(String text) {
        super(text);
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
