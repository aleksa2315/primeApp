package controller;

import gui.MainFrame;
import tree.TreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UpdateAction extends AbstractAction{

    public UpdateAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("update"));
        putValue(NAME, "Update employee");
        putValue(SHORT_DESCRIPTION, "Update employee data");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int row = MainFrame.getInstance().getjTable().getSelectedRow();
        int column = MainFrame.getInstance().getjTable().getSelectedColumn();
        String columnName = MainFrame.getInstance().getjTable().getColumnName(column);
        String currentVal = (String) MainFrame.getInstance().getjTable().getValueAt(row,column);
        String newVal = JOptionPane.showInputDialog(MainFrame.getInstance(),"Current value for " +columnName+ " is " + currentVal,"Change value of " + columnName,JOptionPane.PLAIN_MESSAGE);

        TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();

        if (item.getName().equalsIgnoreCase("employees")){
            int employeeID = Integer.parseInt((String) MainFrame.getInstance().getjTable().getValueAt(0,3));
            MainFrame.getInstance().getAppCore().updateEmployee(item.getName(), columnName, newVal, employeeID);
        }else{
            int taskID = Integer.parseInt((String)MainFrame.getInstance().getjTable().getValueAt(0,4));
            MainFrame.getInstance().getAppCore().updateTask(item.getName(), columnName, newVal, taskID);
        }
    }
}
