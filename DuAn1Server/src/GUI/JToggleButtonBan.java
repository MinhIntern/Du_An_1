/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JToggleButton;

/**
 *
 * @author lethi
 */
public class JToggleButtonBan extends JToggleButton {

    private Color colorSelected;
    private Color colorNotSelected = null;

    public JToggleButtonBan() {
        this.addItemListener(lis);
        this.setFont(new Font("Aria", Font.BOLD, 16));
    }

    public void setColorSelected(Color colorSelected) {
        this.colorSelected = colorSelected;
    }

    public void setColorNotSelected(Color colorNotSelected) {
        this.colorNotSelected = colorNotSelected;
    }

    ItemListener lis = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            JToggleButton source = (JToggleButton) e.getSource();
            if (source.isSelected()) {
                source.setBackground(colorSelected);
            } else {
                source.setBackground(colorNotSelected);
            }
        }
    };
}
