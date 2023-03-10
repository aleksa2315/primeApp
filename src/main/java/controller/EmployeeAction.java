package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EmployeeAction extends AbstractAction{
    public EmployeeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("ss"));
        putValue(NAME, "EmployeeTool");
        putValue(SHORT_DESCRIPTION, "EmployeeTool");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
