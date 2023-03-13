package controller;

import gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AgeDifferenceAction extends AbstractAction{
    public AgeDifferenceAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F17, ActionEvent.ALT_MASK));
        putValue(NAME, "Age difference");
        putValue(SHORT_DESCRIPTION, "Show age difference among employees");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String query = "SELECT CASE WHEN (DATEDIFF(CURDATE(), employees.birthday) / 365) BETWEEN 20 AND 30 THEN '20-30' WHEN (DATEDIFF(CURDATE(), employees.birthday) / 365) BETWEEN 31 AND 40 THEN '31-40' WHEN (DATEDIFF(CURDATE(), employees.birthday) / 365) BETWEEN 41 AND 50 THEN '41-50' ELSE '51+' END AS age_range, COUNT(*) AS count FROM employees GROUP BY age_range";
        MainFrame.getInstance().getAppCore().fetchData(query);
    }
}
