package controller;

import gui.CreateNewEmployeePanel;
import gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;

public class CreateEmployeeAction extends AbstractAction{
    private String name;
    private String email;
    private int phoneNumber;
    private Date date;
    private int salary;
    private String description;
    private int assignee;

    public CreateEmployeeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F5, ActionEvent.ALT_MASK));
        putValue(NAME, "Create employee");
        putValue(SHORT_DESCRIPTION, "Create new employee");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        CreateNewEmployeePanel createNewEmployeePanel = new CreateNewEmployeePanel((Frame) MainFrame.getInstance().getParent(),"Create new employee");
        createNewEmployeePanel.setVisible(true);

    }




}
