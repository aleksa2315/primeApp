package controller;

import errorHandler.ErrorType;
import gui.MainFrame;
import tree.TreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ReadEmployeeAction extends AbstractAction implements MouseListener {

    private int row;

    public ReadEmployeeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F11, ActionEvent.ALT_MASK));
        putValue(NAME, "Read employee");
        putValue(SHORT_DESCRIPTION, "Read all employees data");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getjTable().getSelectedRow() == -1){
            MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
        }else {
            int row = MainFrame.getInstance().getjTable().getSelectedRow();
            TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();
            String id = MainFrame.getInstance().getjTable().getValueAt(row, 1).toString();
            if (!item.getName().equals("employees")) {
                MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.NOT_EMPLOYEE);
            } else {
                String query = "select * from " + item.getName() + " where employeeID = " + id;
                MainFrame.getInstance().getAppCore().fetchData(query);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
