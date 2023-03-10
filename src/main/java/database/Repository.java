package database;

import resource.DBNode;
import resource.data.Row;

import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.util.List;

public interface Repository {
    DBNode getSchema();
    DatabaseMetaData getMetaData();

    List<Row> get(String from);

    List<Row> fetchDataFromDatabase(String sql);

    void createEmployee(String name, String email, int phoneNumber, int salary, Date birthday);

    void createTask(String title, String description, Date dueDate, int assignee);

    void deleteEmployee(String table, int employeeID);

    void deleteTask(String table, int taskID);

    void updateEmployee(String table, String columnName, String newVal, int employeeID);

    void updateTask(String table, String columnName, String newVal, int taskID);

    void mostEffEmp();

}
