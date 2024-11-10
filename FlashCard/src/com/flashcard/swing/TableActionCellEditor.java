
package com.flashcard.swing;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.flashcard.event.TableActionEvent;


public class TableActionCellEditor extends DefaultCellEditor {

    private TableActionEvent event;
    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        CellStatus action = new CellStatus();
        action.initEvent(event, row);
        action.setBackground(table.getSelectionBackground());

        return action;
    } 
    
}
