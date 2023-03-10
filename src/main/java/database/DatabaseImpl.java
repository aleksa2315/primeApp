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

    public void updateEmployee(String table, String columnName, String newVal, int employeeID){
        repository.updateEmployee(table,columnName,newVal,employeeID);
    }

    public void updateTask(String table, String columnName, String newVal, int taskID){
        repository.updateTask(table,columnName,newVal,taskID);
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
