package gui;

import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar() {
        super(HORIZONTAL);
        setFloatable(false);
        add(MainFrame.getInstance().getActionManager().getExitAction());
        addSeparator();
    }
}
