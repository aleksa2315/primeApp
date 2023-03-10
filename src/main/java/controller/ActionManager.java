package controller;

import gui.MainFrame;

import javax.script.ScriptEngine;

public class ActionManager {

    private ExitAction exitAction;
    private CreateAction createAction;
    private DeleteAction deleteAction;
    private ReadAction readAction;
    private UpdateAction updateAction;
    private MostEfficentAction mostEfficentAction;
    public ActionManager(){
        exitAction = new ExitAction(MainFrame.getInstance());
        createAction = new CreateAction();
        updateAction = new UpdateAction();
        deleteAction = new DeleteAction();
        readAction = new ReadAction();
        mostEfficentAction = new MostEfficentAction();
    }

    public MostEfficentAction getMostEfficentAction() {
        return mostEfficentAction;
    }

    public void setMostEfficentAction(MostEfficentAction mostEfficentAction) {
        this.mostEfficentAction = mostEfficentAction;
    }

    public CreateAction getCreateAction() {
        return createAction;
    }

    public void setCreateAction(CreateAction createAction) {
        this.createAction = createAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public void setDeleteAction(DeleteAction deleteAction) {
        this.deleteAction = deleteAction;
    }

    public ReadAction getReadAction() {
        return readAction;
    }

    public void setReadAction(ReadAction readAction) {
        this.readAction = readAction;
    }

    public UpdateAction getUpdateAction() {
        return updateAction;
    }

    public void setUpdateAction(UpdateAction updateAction) {
        this.updateAction = updateAction;
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

}
