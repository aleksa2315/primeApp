package database;

import resource.DBNode;
import resource.data.Row;

import java.sql.Date;
import java.util.List;

public class DatabaseImpl implements Database{

    private Repository repository;

    public DatabaseImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public DBNode loadResource() {
        return repository.getSchema();
    }

    @Override
    public List<Row> readDataFromTable(String tableName) {
        return repository.get(tableName);
    }

    @Override
    public List<Row> fetchDataFromDatabase(String sql) {
        return repository.fetchDataFromDatabase(sql);
    }

    public void createEmployee(String name, String email, int phoneNumber, int salary, Date birthday){
        repository.createEmployee(name, email, phoneNumber, salary, birthday);
    }

    public void createTask(String title, String description, Date dueDate, int assignee){
        repository.createTask(title,description,dueDate,assignee);
    }

    public void deleteEmployee(String table, int employeeID){
        repository.deleteEmployee(table,employeeID);
    }

    public void deleteTask(String table, int taskID){
        repository.deleteTask(table,taskID);
    }

    public void updateEmployee(String table, String name, String email, String salary, String phoneNum, String bday, int employeeID){
        repository.updateEmployee(table,name, email, salary,phoneNum,bday,employeeID);
    }

    public void updateTask(String table, String title, String description, String dueDate, String assignee, int taskID){
        repository.updateTask(table,title,description,dueDate,assignee,taskID);
    }

    public void createNewDept(String name, int manager){
        repository.createNewDept(name,manager);
    }
    public void mostEffEmp(){
        repository.mostEffEmp();
    }
    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
