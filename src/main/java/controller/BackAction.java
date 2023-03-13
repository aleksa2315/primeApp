package controller;

import gui.MainFrame;
import tree.TreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class BackAction extends AbstractAction {

    public BackAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F1, ActionEvent.ALT_MASK));
        putValue(NAME, "Back");
        putValue(SHORT_DESCRIPTION, "Go back to table");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();

        MainFrame.getInstance().getAppCore().readDataFromTable(item.getName());
    }
}
