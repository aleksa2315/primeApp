package gui;

import core.Gui;

public class App implements Gui {
    private MainFrame instance;

    public App(){

    }
    public void start() {
        instance = MainFrame.getInstance();
        //instance.initTree();
        instance.initGui();
        instance.setVisible(true);
    }
}
