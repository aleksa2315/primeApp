package controller;

import gui.MainFrame;
import resource.data.Row;
import tree.Tree;
import tree.TreeItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DeleteAction extends AbstractAction{

    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("delete"));
        putValue(NAME, "Delete employee");
        putValue(SHORT_DESCRIPTION, "Delete employee");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int row = MainFrame.getInstance().getjTable().getSelectedRow();

        TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();

        if (item.getName().equalsIgnoreCase("employees")){
            String table = item.getName();
            String id = MainFrame.getInstance().getjTable().getValueAt(row,1).toString();
            System.out.println(table+id);
            MainFrame.getInstance().getAppCore().deleteEmployee(table, Integer.parseInt(id));
        }else{
            String table = item.getName();
            String id = MainFrame.getInstance().getjTable().getValueAt(row,2).toString();
            System.out.println(table+id);
            MainFrame.getInstance().getAppCore().deleteTask(table, Integer.parseInt(id));
        }
    }

}
