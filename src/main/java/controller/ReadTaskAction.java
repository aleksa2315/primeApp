package controller;

import database.DatabaseImpl;
import gui.MainFrame;
import resource.data.Row;
import tree.TreeItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ReadTaskAction extends AbstractAction implements MouseListener {

    private int row;

    public ReadTaskAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("read"));
        putValue(NAME, "Read task");
        putValue(SHORT_DESCRIPTION, "Read all task data");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int row = MainFrame.getInstance().getjTable().getSelectedRow();
        TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();
        String id = MainFrame.getInstance().getjTable().getValueAt(row,2).toString();
        String query = "select * from " + item.getName() + " where taskID = " + id;
        MainFrame.getInstance().getAppCore().fetchData(query);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        JTable jTable = (JTable) e.getSource();
//        Point point = e.getPoint();
//        int row = jTable.rowAtPoint(point);
//        TreeItem item = (TreeItem) MainFrame.getInstance().getjTree().getLastSelectedPathComponent();
//        String id = MainFrame.getInstance().getjTable().getValueAt(row,2).toString();
//        String query = "select * from " + item.getName() + " where taskID = " + id;
//        MainFrame.getInstance().getAppCore().fetchData(query);
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
