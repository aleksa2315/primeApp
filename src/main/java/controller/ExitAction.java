package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ExitAction extends AbstractAction implements WindowListener {

    private JFrame parent = null;

    public ExitAction(JFrame parent) {
        this.parent = parent;
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon(""));
        putValue(NAME, "Exit");
        putValue(SHORT_DESCRIPTION, "Exit");
    }


    public void actionPerformed(ActionEvent e) {
        JFrame frame = parent;
        int code = JOptionPane.showConfirmDialog(frame,"Da li ste sigurni da zelite da zatvorite aplikaciju?","Zatvaranje aplikacije?",JOptionPane.YES_NO_OPTION);
        if (code != JOptionPane.YES_OPTION){
            frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }else{
            System.exit(0);
        }
    }

    public void windowOpened(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) {
        JFrame frame = (JFrame) e.getComponent();
        int code = JOptionPane.showConfirmDialog(frame,"Da li ste sigurni da zelite da zatvorite aplikaciju?","Zatvaranje aplikacije?",JOptionPane.YES_NO_OPTION);
        if (code != JOptionPane.YES_OPTION){
            frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }else{
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }

    public void windowClosed(WindowEvent e) {

    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {

    }

    public void windowActivated(WindowEvent e) {

    }

    public void windowDeactivated(WindowEvent e) {

    }
}
