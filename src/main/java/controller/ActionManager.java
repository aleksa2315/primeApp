package controller;

import gui.MainFrame;

public class ActionManager {

    private ExitAction exitAction;
    private CreateEmployeeAction createEmployeeAction;
    private DeleteEmployeeAction deleteEmployeeAction;
    private ReadAction readAction;
    private UpdateEmployeeAction updateEmployeeAction;
    private MostEfficentAction mostEfficentAction;
    private CreateTaskAction createTaskAction;
    private UpdateTaskAction updateTaskAction;
    private DeleteTaskAction deleteTaskAction;
    private ReadTaskAction readTaskAction;

    public ActionManager(){
        exitAction = new ExitAction(MainFrame.getInstance());
        createEmployeeAction = new CreateEmployeeAction();
        updateEmployeeAction = new UpdateEmployeeAction();
        deleteEmployeeAction = new DeleteEmployeeAction();
        readAction = new ReadAction();
        mostEfficentAction = new MostEfficentAction();
        createTaskAction = new CreateTaskAction();
        updateTaskAction = new UpdateTaskAction();
        deleteTaskAction = new DeleteTaskAction();
        readTaskAction = new ReadTaskAction();
    }

    public ReadTaskAction getReadTaskAction() {
        return readTaskAction;
    }

    public void setReadTaskAction(ReadTaskAction readTaskAction) {
        this.readTaskAction = readTaskAction;
    }

    public DeleteEmployeeAction getDeleteEmployeeAction() {
        return deleteEmployeeAction;
    }

    public void setDeleteEmployeeAction(DeleteEmployeeAction deleteEmployeeAction) {
        this.deleteEmployeeAction = deleteEmployeeAction;
    }

    public DeleteTaskAction getDeleteTaskAction() {
        return deleteTaskAction;
    }

    public void setDeleteTaskAction(DeleteTaskAction deleteTaskAction) {
        this.deleteTaskAction = deleteTaskAction;
    }

    public CreateEmployeeAction getCreateEmployeeAction() {
        return createEmployeeAction;
    }

    public void setCreateEmployeeAction(CreateEmployeeAction createEmployeeAction) {
        this.createEmployeeAction = createEmployeeAction;
    }

    public UpdateEmployeeAction getUpdateEmployeeAction() {
        return updateEmployeeAction;
    }

    public void setUpdateEmployeeAction(UpdateEmployeeAction updateEmployeeAction) {
        this.updateEmployeeAction = updateEmployeeAction;
    }

    public UpdateTaskAction getUpdateTaskAction() {
        return updateTaskAction;
    }

    public void setUpdateTaskAction(UpdateTaskAction updateTaskAction) {
        this.updateTaskAction = updateTaskAction;
    }

    public MostEfficentAction getMostEfficentAction() {
        return mostEfficentAction;
    }

    public void setMostEfficentAction(MostEfficentAction mostEfficentAction) {
        this.mostEfficentAction = mostEfficentAction;
    }

    public CreateEmployeeAction getCreateAction() {
        return createEmployeeAction;
    }

    public void setCreateAction(CreateEmployeeAction createEmployeeAction) {
        this.createEmployeeAction = createEmployeeAction;
    }

    public DeleteEmployeeAction getDeleteAction() {
        return deleteEmployeeAction;
    }

    public void setDeleteAction(DeleteEmployeeAction deleteEmployeeAction) {
        this.deleteEmployeeAction = deleteEmployeeAction;
    }

    public ReadAction getReadAction() {
        return readAction;
    }

    public void setReadAction(ReadAction readAction) {
        this.readAction = readAction;
    }

    public UpdateEmployeeAction getUpdateAction() {
        return updateEmployeeAction;
    }

    public void setUpdateAction(UpdateEmployeeAction updateEmployeeAction) {
        this.updateEmployeeAction = updateEmployeeAction;
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

    public CreateTaskAction getCreateTaskAction() {
        return createTaskAction;
    }

    public void setCreateTaskAction(CreateTaskAction createTaskAction) {
        this.createTaskAction = createTaskAction;
    }
}
