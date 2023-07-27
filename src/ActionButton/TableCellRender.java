/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActionButton;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;

/**
 *
 * @author THUAT
 */
public class TableCellRender extends DefaultTableCellRenderer{

    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Iconfix ac = new Iconfix();
        if(isSelected==false&&row%2==0){
            ac.setBackground(Color.WHITE);
        }else{
            ac.setBackground(com.getBackground());
        }
        return ac;
    }

    
}
