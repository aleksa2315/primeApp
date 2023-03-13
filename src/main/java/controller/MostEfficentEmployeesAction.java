package controller;

import gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MostEfficentEmployeesAction extends AbstractAction{
    public MostEfficentEmployeesAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F9, ActionEvent.ALT_MASK));
        putValue(NAME, "Most efficient employees");
        putValue(SHORT_DESCRIPTION, "Show table of 5 most efficient employees in the last month");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String query = "SELECT e.employeeID, e.name, COUNT(t.taskID) AS num_tasks_completed\n" +
                "FROM employees e\n" +
                "INNER JOIN tasks t ON e.employeeID = t.employeeID\n" +
                "WHERE t.dueDate >= DATE_SUB(NOW(), INTERVAL 1 MONTH)\n" +
                "GROUP BY e.employeeID\n" +
                "ORDER BY num_tasks_completed DESC\n" +
                "LIMIT 5;";

        MainFrame.getInstance().getAppCore().fetchData(query);
    }
}
