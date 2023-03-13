package controller;

import gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AverageSalaryAction extends AbstractAction{
    public AverageSalaryAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F6, ActionEvent.ALT_MASK));
        putValue(NAME, "Average salary");
        putValue(SHORT_DESCRIPTION, "Show average salary by department");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String query = "SELECT departments.name, AVG(employees.salary) AS avg_salary FROM employees JOIN departments ON employees.departmentID = departments.departmentID GROUP BY departments.name";
        MainFrame.getInstance().getAppCore().fetchData(query);
    }
}
