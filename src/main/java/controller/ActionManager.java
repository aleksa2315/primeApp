package controller;

import gui.MainFrame;

public class ActionManager {

    private ExitAction exitAction;
    private CreateEmployeeAction createEmployeeAction;
    private DeleteEmployeeAction deleteEmployeeAction;
    private ReadEmployeeAction readEmployeeAction;
    private UpdateEmployeeAction updateEmployeeAction;
    private MostEfficentEmployeesAction mostEfficentEmployeesAction;
    private CreateTaskAction createTaskAction;
    private UpdateTaskAction updateTaskAction;
    private DeleteTaskAction deleteTaskAction;
    private ReadTaskAction readTaskAction;
    private BackAction backAction;
    private ReadDepartmentAction readDepartmentAction;
    private CreateDepartmentAction createDepartmentAction;
    private MostEfficientDeptAction mostEfficientDeptAction;
    private AverageSalaryAction averageSalaryAction;
    private TaskLoadAction taskLoadAction;
    private AgeDifferenceAction ageDifferenceAction;

    public ActionManager(){
        exitAction = new ExitAction(MainFrame.getInstance());
        createEmployeeAction = new CreateEmployeeAction();
        updateEmployeeAction = new UpdateEmployeeAction();
        deleteEmployeeAction = new DeleteEmployeeAction();
        readEmployeeAction = new ReadEmployeeAction();
        mostEfficentEmployeesAction = new MostEfficentEmployeesAction();
        createTaskAction = new CreateTaskAction();
        updateTaskAction = new UpdateTaskAction();
        deleteTaskAction = new DeleteTaskAction();
        readTaskAction = new ReadTaskAction();
        backAction = new BackAction();
        readDepartmentAction = new ReadDepartmentAction();
        createDepartmentAction = new CreateDepartmentAction();
        mostEfficientDeptAction = new MostEfficientDeptAction();
        taskLoadAction = new TaskLoadAction();
        ageDifferenceAction = new AgeDifferenceAction();
        averageSalaryAction = new AverageSalaryAction();
    }

    public AverageSalaryAction getAverageSalaryAction() {
        return averageSalaryAction;
    }

    public void setAverageSalaryAction(AverageSalaryAction averageSalaryAction) {
        this.averageSalaryAction = averageSalaryAction;
    }

    public TaskLoadAction getTaskLoadAction() {
        return taskLoadAction;
    }

    public void setTaskLoadAction(TaskLoadAction taskLoadAction) {
        this.taskLoadAction = taskLoadAction;
    }

    public AgeDifferenceAction getAgeDifferenceAction() {
        return ageDifferenceAction;
    }

    public MostEfficentEmployeesAction getMostEfficentEmployeesAction() {
        return mostEfficentEmployeesAction;
    }

    public void setMostEfficentEmployeesAction(MostEfficentEmployeesAction mostEfficentEmployeesAction) {
        this.mostEfficentEmployeesAction = mostEfficentEmployeesAction;
    }

    public MostEfficientDeptAction getMostEfficientDeptAction() {
        return mostEfficientDeptAction;
    }

    public void setMostEfficientDeptAction(MostEfficientDeptAction mostEfficientDeptAction) {
        this.mostEfficientDeptAction = mostEfficientDeptAction;
    }

    public ReadDepartmentAction getReadDepartmentAction() {
        return readDepartmentAction;
    }

    public void setReadDepartmentAction(ReadDepartmentAction readDepartmentAction) {
        this.readDepartmentAction = readDepartmentAction;
    }

    public CreateDepartmentAction getCreateDepartmentAction() {
        return createDepartmentAction;
    }

    public void setCreateDepartmentAction(CreateDepartmentAction createDepartmentAction) {
        this.createDepartmentAction = createDepartmentAction;
    }

    public ReadEmployeeAction getReadEmployeeAction() {
        return readEmployeeAction;
    }

    public void setReadEmployeeAction(ReadEmployeeAction readEmployeeAction) {
        this.readEmployeeAction = readEmployeeAction;
    }

    public BackAction getBackAction() {
        return backAction;
    }

    public void setBackAction(BackAction backAction) {
        this.backAction = backAction;
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

    public MostEfficentEmployeesAction getMostEfficentAction() {
        return mostEfficentEmployeesAction;
    }

    public void setMostEfficentAction(MostEfficentEmployeesAction mostEfficentEmployeesAction) {
        this.mostEfficentEmployeesAction = mostEfficentEmployeesAction;
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

    public ReadEmployeeAction getReadAction() {
        return readEmployeeAction;
    }

    public void setReadAction(ReadEmployeeAction readEmployeeAction) {
        this.readEmployeeAction = readEmployeeAction;
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
