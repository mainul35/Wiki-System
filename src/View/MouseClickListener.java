/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Mainul35
 */
public abstract class MouseClickListener extends MouseInputAdapter{
    @Override
    public abstract void mouseClicked(MouseEvent me);
}
