package controller;

import gui.MainFrame;

public class ActionManager {

    private ExitAction exitAction;
    public ActionManager(){
        exitAction = new ExitAction(MainFrame.getInstance());
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }
}
