/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JCheckBox;

/**
 *
 * @author Mainul35
 */
public class AdvancedCheckBox extends JCheckBox{
    private int id = 0;

    public AdvancedCheckBox() {
    }

    public AdvancedCheckBox(String text) {
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
