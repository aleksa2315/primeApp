package controller;

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
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("update"));
        putValue(NAME, "Update task");
        putValue(SHORT_DESCRIPTION, "Update task data");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();
        changes = new ArrayList();

        int row = MainFrame.getInstance().getjTable().getSelectedRow();
        int column = 2;
        int taskID = Integer.parseInt((String) MainFrame.getInstance().getjTable().getValueAt(row,column));
        String columnName = MainFrame.getInstance().getjTable().getColumnName(column);
        list = MainFrame.getInstance().getAppCore().getData(item.getName(), String.valueOf(taskID),columnName);
        setCurrVal(list.get(0));
        UpdateTaskPanel updateTaskPanel = new UpdateTaskPanel((Frame) MainFrame.getInstance().getParent(),"Update task data", currTitle,currDesc,currAssignee,currDueDate);
        updateTaskPanel.setVisible(true);

        loadNewValues(updateTaskPanel);
        checkDiff();

        for (String string : changes){
            switch (string) {
                case "title": MainFrame.getInstance().getAppCore().updateTask(item.getName(),"title", newTitle,taskID);
                    continue;
                case "description": MainFrame.getInstance().getAppCore().updateTask(item.getName(), "descripion", newDesc, taskID);
                    continue;
                case "assignee": MainFrame.getInstance().getAppCore().updateEmployee(item.getName(),"assigneID", newAssignee, taskID);
                    continue;
                case "dueDate": MainFrame.getInstance().getAppCore().updateEmployee(item.getName(),"dueDate", newDesc, taskID);
                    continue;
            }
        }
    }

    private void setCurrVal(Row row){
        Map<String,Object> values = row.getFields();
        currTitle = (String) values.get("title");
        currDesc = (String) values.get("description");
        currAssignee = (String) values.get("assigneeID");
        currDueDate = (String) values.get("dueDate");
    }

    private void checkDiff(){
        if (!currTitle.equals(newTitle)){
            changes.add("title");
        }

        if (!currDesc.equals(newDesc)){
            changes.add("description");
        }

        if (!currAssignee.equals(newAssignee)){
            changes.add("assigneeID");
        }

        if (!currDueDate.equals(newDueDate)){
            changes.add("dueDate");
        }

    }

    private void loadNewValues(UpdateTaskPanel panel){
        newTitle = panel.getTaskTitle();
        newDesc = panel.getDescription();
        newAssignee = String.valueOf(panel.getAssignee());
        newDueDate = String.valueOf(panel.getDueDate());
    }
}
