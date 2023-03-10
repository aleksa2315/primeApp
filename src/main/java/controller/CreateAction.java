package controller;

import gui.MainFrame;
import resource.DBNode;
import tree.TreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class CreateAction extends AbstractAction{
    private String name;
    private String email;
    private int phoneNumber;
    private Date date;
    private int salary;
    private String description;
    private int assignee;

    public CreateAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("create"));
        putValue(NAME, "Create employee");
        putValue(SHORT_DESCRIPTION, "Create new employee");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();
        if (item.getName().equalsIgnoreCase("employees")){
            name = (String) JOptionPane.showInputDialog(MainFrame.getInstance(),"Enter name of the employee","Enter name",JOptionPane.PLAIN_MESSAGE);
            email = (String) JOptionPane.showInputDialog(MainFrame.getInstance(),"Enter email of the employee","Enter email",JOptionPane.PLAIN_MESSAGE);
            phoneNumber = Integer.parseInt(JOptionPane.showInputDialog(MainFrame.getInstance(),"Enter phone number of the employee","Enter phone number",JOptionPane.PLAIN_MESSAGE));
            salary = Integer.parseInt(JOptionPane.showInputDialog(MainFrame.getInstance(),"Enter monthly salary of the employee","Enter monthly salar",JOptionPane.PLAIN_MESSAGE));
            date = java.sql.Date.valueOf(JOptionPane.showInputDialog(MainFrame.getInstance(),"Enter date of birth of the employee in yyyy-mm-dd format","Enter date of birth",JOptionPane.PLAIN_MESSAGE));
            MainFrame.getInstance().getAppCore().createEmployee(name, email, phoneNumber, salary, date,item.getName());

        }else if (item.getName().equalsIgnoreCase("tasks")){
            name = JOptionPane.showInputDialog(MainFrame.getInstance(),"Enter title of task","Enter title",JOptionPane.PLAIN_MESSAGE);
            description = JOptionPane.showInputDialog(MainFrame.getInstance(),"Enter description of the task","Enter description",JOptionPane.PLAIN_MESSAGE);
            date = java.sql.Date.valueOf(JOptionPane.showInputDialog(MainFrame.getInstance(),"Enter due date of the task in yyyy-mm-dd format","Enter due date",JOptionPane.PLAIN_MESSAGE));
            assignee = Integer.parseInt(JOptionPane.showInputDialog(MainFrame.getInstance(),"Enter ID number of assignee","Enter assigne ID",JOptionPane.PLAIN_MESSAGE));
            MainFrame.getInstance().getAppCore().createTask(name,description,assignee,date,item.getName());
        }
    }




}
