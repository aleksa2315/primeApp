package gui;

import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar() {
        super(HORIZONTAL);
        setFloatable(false);
        add(MainFrame.getInstance().getActionManager().getExitAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getCreateAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getUpdateAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getDeleteAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getMostEfficentAction());
    }
}
