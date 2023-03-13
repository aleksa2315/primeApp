package controller;

import errorHandler.ErrorType;
import gui.MainFrame;
import tree.TreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteEmployeeAction extends AbstractAction{

    public DeleteEmployeeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F7, ActionEvent.ALT_MASK));
        putValue(NAME, "Delete employee");
        putValue(SHORT_DESCRIPTION, "Delete employee");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getjTable().getSelectedRow() == -1){
            MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
        }else {
            int row = MainFrame.getInstance().getjTable().getSelectedRow();

            TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();

            if (!item.getName().equals("employees")){
                MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.NOT_EMPLOYEE);
            }else {
                String table = item.getName();
                String id = MainFrame.getInstance().getjTable().getValueAt(row, 1).toString();
                int result = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Are you sure you want to delete this employee?", "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    MainFrame.getInstance().getAppCore().deleteEmployee(table, Integer.parseInt(id));
                }
            }
        }
    }
}
