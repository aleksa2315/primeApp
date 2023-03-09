package core;

import gui.App;
import gui.MainFrame;

public class AppCore extends AppFramework{
    private static AppCore instance;
    public void run() {
        this.gui.start();
    }

    public static AppCore getInstance(){
        if (instance == null){
            instance = new AppCore();
        }
        return instance;
    }

    public static void main(String[] args){
        Gui gui = new App();
        AppCore appCore = AppCore.getInstance();
        appCore.init(gui);
        MainFrame.getInstance().setAppCore(appCore);
        appCore.run();
    }
}
