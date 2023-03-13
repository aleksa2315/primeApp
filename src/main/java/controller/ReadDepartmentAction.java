package controller;

import errorHandler.ErrorType;
import gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ReadDepartmentAction extends AbstractAction{

    public ReadDepartmentAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F12, ActionEvent.ALT_MASK));
        putValue(NAME, "Read department");
        putValue(SHORT_DESCRIPTION, "Read all department data");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getjTable().getSelectedRow() == -1){
            MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
        }else {
            int row = MainFrame.getInstance().getjTable().getSelectedRow();
            String name = (String) MainFrame.getInstance().getjTable().getValueAt(row, 1);

            String query = "SELECT e.* FROM employees e JOIN departments d ON e.departmentID = d.departmentID WHERE d.name = '" + name + "'";
            MainFrame.getInstance().getAppCore().fetchData(query);
        }
    }
}
