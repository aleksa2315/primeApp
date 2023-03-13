package controller;

import gui.CreateNewDepartmentPanel;
import gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CreateDepartmentAction extends AbstractAction{

    public CreateDepartmentAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F3, ActionEvent.ALT_MASK));
        putValue(NAME, "Create department");
        putValue(SHORT_DESCRIPTION, "Create new department");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        CreateNewDepartmentPanel createNewDepartmentPanel = new CreateNewDepartmentPanel(MainFrame.getInstance(),"Create new department");
        createNewDepartmentPanel.setVisible(true);
    }
}
