package controller;

import gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MostEfficientDeptAction extends AbstractAction{
    public MostEfficientDeptAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F10, ActionEvent.ALT_MASK));
        putValue(NAME, "Most efficient department");
        putValue(SHORT_DESCRIPTION, "Display 5 most efficient departments");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String query = "SELECT d.name, COUNT(t.taskID) AS tasks_completed FROM departments d INNER JOIN employees e ON d.departmentID = e.departmentID INNER JOIN tasks t ON e.employeeID = t.employeeID WHERE t.dueDate < NOW() GROUP BY d.name ORDER BY tasks_completed DESC LIMIT 2";
        MainFrame.getInstance().getAppCore().fetchData(query);
    }
}
