package controller;

import gui.CreateNewTaskPanel;
import gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;

public class CreateTaskAction extends AbstractAction {
    private String title;
    private String description;
    private Date dueDate;
    private int assignee;
    public CreateTaskAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("createTask"));
        putValue(NAME, "Create task");
        putValue(SHORT_DESCRIPTION, "Create new task");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        CreateNewTaskPanel createNewTaskPanel = new CreateNewTaskPanel((Frame) MainFrame.getInstance().getParent(),"Create new task");
        createNewTaskPanel.setVisible(true);

    }
}
