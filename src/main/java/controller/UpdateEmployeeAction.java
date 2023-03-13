package controller;

import errorHandler.ErrorType;
import gui.MainFrame;
import gui.UpdateEmployeePanel;
import resource.data.Row;
import tree.TreeItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UpdateEmployeeAction extends AbstractAction{

    private List<Row> list;
    private String currName;
    private String currEmail;
    private String newName;
    private String newEmail;
    private String currPhone;
    private String newPhone;
    private String currBday;
    private String newBday;
    private String currSalary;
    private String newSalary;

    private ArrayList<String> changes;

    public UpdateEmployeeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F14, ActionEvent.ALT_MASK));
        putValue(NAME, "Update employee");
        putValue(SHORT_DESCRIPTION, "Update employee data");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getjTable().getSelectedRow() == -1){
            MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
        }else {
            TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();
            changes = new ArrayList();

            int row = MainFrame.getInstance().getjTable().getSelectedRow();
            int column = 1;
            int employeeID = Integer.parseInt((String) MainFrame.getInstance().getjTable().getValueAt(row, column));
            String columnName = MainFrame.getInstance().getjTable().getColumnName(column);
            list = MainFrame.getInstance().getAppCore().getData(item.getName(), String.valueOf(employeeID), columnName);
            setCurrVal(list.get(0));
            UpdateEmployeePanel updateEmployeePanel = new UpdateEmployeePanel((Frame) MainFrame.getInstance().getParent(), "Update employee data", currName, currEmail, currPhone, currBday, currSalary);
            updateEmployeePanel.setVisible(true);

            loadNewValues(updateEmployeePanel);
            if (checkDiff() != 0) {
                MainFrame.getInstance().getAppCore().updateEmployee(item.getName(), newName, newEmail, newSalary, newPhone, newBday, employeeID);
            }
        }
    }

    private void setCurrVal(Row row){
        Map<String,Object> values = row.getFields();
        currName = (String) values.get("name");
        currBday = (String) values.get("birthday");
        currEmail = (String) values.get("email");
        currSalary = (String) values.get("salary");
        currPhone = (String) values.get("phoneNumber");
    }

    private int checkDiff(){
        int a = 0;
        if (!currName.equals(newName)){
            a++;
        }

        if (!currEmail.equals(newEmail)){
            a++;
        }

        if (!currPhone.equals(newPhone)){
            a++;
        }

        if (!currSalary.equals(newSalary)){
            a++;
        }

        if (!currBday.equals(newBday)){
            a++;
        }
        return a;
    }

    private void loadNewValues(UpdateEmployeePanel panel){
        newName = panel.getName();
        newEmail = panel.getEmail();
        newPhone = String.valueOf(panel.getPhoneNumber());
        newSalary = String.valueOf(panel.getSalary());
        newBday = String.valueOf(panel.getBirthDay());
    }
}
