package controller;

import gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class TaskLoadAction extends AbstractAction{
    public TaskLoadAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F16, ActionEvent.ALT_MASK));
        putValue(NAME, "Task load");
        putValue(SHORT_DESCRIPTION, "Show task load");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String string = "SELECT employees.name, COUNT(tasks.taskID) AS task_count FROM employees LEFT JOIN tasks ON employees.employeeID = tasks.employeeID GROUP BY employees.name";
        MainFrame.getInstance().getAppCore().fetchData(string);
    }
}
