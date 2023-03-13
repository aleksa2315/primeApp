package core;

import errorHandler.ErrorHandler;

public abstract class AppFramework {
    protected Gui gui;
    public abstract void run();

    public void init(Gui gui){
        this.gui = gui;
    }
}
