package controller;

import errorHandler.ErrorType;
import gui.MainFrame;
import gui.UpdateEmployeePanel;
import gui.UpdateTaskPanel;
import resource.data.Row;
import tree.TreeItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UpdateTaskAction extends AbstractAction{

    private List<Row> list;
    private String currTitle;
    private String currDesc;
    private String newTitle;
    private String newDesc;
    private String currAssignee;
    private String newAssignee;
    private String currDueDate;
    private String newDueDate;

    private ArrayList<String> changes;

    public UpdateTaskAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F15, ActionEvent.ALT_MASK));
        putValue(NAME, "Update task");
        putValue(SHORT_DESCRIPTION, "Update task data");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getjTable().getSelectedRow() == -1){
            MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
        }else {
            TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();
            changes = new ArrayList();

            int row = MainFrame.getInstance().getjTable().getSelectedRow();
            int column = 2;
            int taskID = Integer.parseInt((String) MainFrame.getInstance().getjTable().getValueAt(row, column));
            String columnName = MainFrame.getInstance().getjTable().getColumnName(column);
            list = MainFrame.getInstance().getAppCore().getData(item.getName(), String.valueOf(taskID), columnName);
            setCurrVal(list.get(0));
            UpdateTaskPanel updateTaskPanel = new UpdateTaskPanel((Frame) MainFrame.getInstance().getParent(), "Update task data", currTitle, currDesc, currAssignee, currDueDate);
            updateTaskPanel.setVisible(true);

            loadNewValues(updateTaskPanel);
            if (checkDiff() != 0) {
                MainFrame.getInstance().getAppCore().updateTask(item.getName(), newTitle, newDesc, newDueDate, newAssignee, taskID);
            }
        }
    }

    private void setCurrVal(Row row){
        Map<String,Object> values = row.getFields();
        currTitle = (String) values.get("title");
        currDesc = (String) values.get("description");
        currAssignee = (String) values.get("employeeID");
        currDueDate = (String) values.get("dueDate");
    }

    private int checkDiff(){
        int a = 0;
        if (!currTitle.equals(newTitle)){
            a++;
        }

        if (!currDesc.equals(newDesc)){
            a++;
        }

        if (!currAssignee.equals(newAssignee)){
            a++;
        }

        if (!currDueDate.equals(newDueDate)){
            a++;
        }

        return a;
    }

    private void loadNewValues(UpdateTaskPanel panel){
        newTitle = panel.getTaskTitle();
        newDesc = panel.getDescription();
        newAssignee = String.valueOf(panel.getAssignee());
        newDueDate = String.valueOf(panel.getDueDate());
    }
}
