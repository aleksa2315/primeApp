package database;

import resource.DBNode;
import resource.data.Row;

import java.sql.Date;
import java.util.List;

public interface Database {
    DBNode loadResource();

    List<Row> readDataFromTable(String tableName);

    List<Row> fetchDataFromDatabase(String tableName);

    void createEmployee(String name, String email, int phoneNumber, int salary, Date birthday);

    void createTask(String title, String description, Date dueDate, int assignee);

    void deleteEmployee(String table, int employeeID);

    void deleteTask(String task, int taskID);

    void updateEmployee(String table, String name, String email, String salary, String phoneNum, String bday, int employeeID);

    void updateTask(String table, String title, String description, String dueDate, String assignee, int taskID);
     void createNewDept(String name, int manager);

    void mostEffEmp();
}
