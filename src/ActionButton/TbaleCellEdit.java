/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActionButton;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


public class TbaleCellEdit extends DefaultCellEditor{

    private TableAction event;
    public TbaleCellEdit(TableAction event) {
        super(new JCheckBox());
        this.event=event;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        Iconfix ac =new Iconfix();
        ac.event(event, row);
        ac.setBackground(table.getSelectionBackground());
        return ac;
    }
    
}
