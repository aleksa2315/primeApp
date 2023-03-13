package controller;

import database.DatabaseImpl;
import errorHandler.ErrorType;
import gui.MainFrame;
import resource.data.Row;
import tree.TreeItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReadTaskAction extends AbstractAction implements MouseListener {

    private int row;

    public ReadTaskAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F13, ActionEvent.ALT_MASK));
        putValue(NAME, "Read task");
        putValue(SHORT_DESCRIPTION, "Read all task data");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getjTable().getSelectedRow() == -1){
            MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
        }else {
            int row = MainFrame.getInstance().getjTable().getSelectedRow();
            TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();
            String id = MainFrame.getInstance().getjTable().getValueAt(row, 2).toString();
            if (!item.getName().equals("tasks")) {
                MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.NOT_TASK);
            } else {
                String query = "select * from " + item.getName() + " where taskID = " + id;
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
