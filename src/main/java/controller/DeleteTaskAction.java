package controller;

import errorHandler.ErrorType;
import gui.MainFrame;
import tree.TreeItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteTaskAction extends AbstractAction{

    public DeleteTaskAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F8, ActionEvent.ALT_MASK));
        putValue(NAME, "Delete task");
        putValue(SHORT_DESCRIPTION, "Delete task");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getjTable().getSelectedRow() == -1){
            MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.NOTHING_SELECTED);
        }else {
            int row = MainFrame.getInstance().getjTable().getSelectedRow();

            TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();

            if (!item.getName().equals("tasks")){
                MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.NOT_TASK);
            }else {
                String table = item.getName();
                String id = MainFrame.getInstance().getjTable().getValueAt(row, 2).toString();
                int result = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Are you sure you want to delete this task?", "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    MainFrame.getInstance().getAppCore().deleteTask(table, Integer.parseInt(id));
                }
            }
        }
    }
}