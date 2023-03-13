package database;

import database.settings.Settings;
import org.apache.commons.dbcp2.BasicDataSource;
import resource.DBNode;
import resource.data.Row;
import resource.enums.AttributeType;
import resource.implementation.Attribute;
import resource.implementation.Entity;
import resource.implementation.InformationResource;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

public class MYSQLRepository implements Repository {
    private Settings settings;
    private Connection connection;
    private DatabaseMetaData metaData;
    private static final BasicDataSource dataSource = new BasicDataSource();

    private ArrayList<String> listaTabela = new ArrayList<>();

    public MYSQLRepository(Settings settings) {
        this.settings = settings;
    }

    private void initConnection() throws SQLException, ClassNotFoundException{
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://db4free.net:3306/primeapp");
        dataSource.setUsername("primeapp");
        dataSource.setPassword("12345678");

        String ip = (String) settings.getParameter("mysql_ip");
        String database = (String) settings.getParameter("mysql_database");
        String username = (String) settings.getParameter("mysql_username");
        String password = (String) settings.getParameter("mysql_password");
        String port = (String) settings.getParameter("mysql_port");

//        connection = DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+database,username,password);
        connection = dataSource.getConnection();
        metaData = connection.getMetaData();
    }

    private void closeConnection(){
        try{
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            connection = null;
        }
    }


    @Override
    public DBNode getSchema() {

        try{
            this.initConnection();

            DatabaseMetaData metaData = connection.getMetaData();
            InformationResource ir = new InformationResource(connection.getCatalog());

            String tableType[] = {"TABLE"};
            ResultSet tables = metaData.getTables(connection.getCatalog(), null, null, tableType);

            while (tables.next()){

                String tableName = tables.getString("TABLE_NAME");
                listaTabela.add(tableName);
                if(tableName.contains("trace"))continue;
                Entity newTable = new Entity(tableName, ir);
                ir.addChild(newTable);
                ResultSet columns = metaData.getColumns(connection.getCatalog(), null, tableName, null);

                while (columns.next()){

                    // COLUMN_NAME TYPE_NAME COLUMN_SIZE ....

                    String columnName = columns.getString("COLUMN_NAME");
                    String columnType = columns.getString("TYPE_NAME");


                    int columnSize = Integer.parseInt(columns.getString("COLUMN_SIZE"));


                    Attribute attribute = new Attribute(columnName, newTable,
                            AttributeType.valueOf(
                                    Arrays.stream(columnType.toUpperCase().split(" "))
                                            .collect(Collectors.joining("_"))),
                            columnSize);
                    newTable.addChild(attribute);
                }

            }

            return ir;

        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
        catch (ClassNotFoundException e2){ e2.printStackTrace();}
        finally {
            this.closeConnection();
        }

        return null;
    }

    @Override
    public List<Row> get(String from) {

        List<Row> rows = new ArrayList<>();


        try{
            this.initConnection();

            String query = "SELECT * FROM " + from;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            populateRowList(from, rows, rs, resultSetMetaData);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection();
        }


        return rows;
    }

    private void populateRowList(String from, List<Row> rows, ResultSet rs, ResultSetMetaData resultSetMetaData) throws SQLException {
        while (rs.next()){

            Row row = new Row();
            row.setName(from);

            for (int i = 1; i<= resultSetMetaData.getColumnCount(); i++){
                String table = row.getName();
                String column = resultSetMetaData.getColumnName(i);

                if (table.equalsIgnoreCase("employees")) {
                    if (column.equalsIgnoreCase("employeeid")||column.equalsIgnoreCase("name")) {
                        row.addField(column, rs.getString(i));
                    }
                }else if(table.equalsIgnoreCase("tasks")){
                    if (column.equalsIgnoreCase("title") || column.equalsIgnoreCase("taskID") || column.equalsIgnoreCase("employeeID")){
                        row.addField(column, rs.getString(i));
                    }
                }else{
                    row.addField(column, rs.getString(i));
                }
            }
            rows.add(row);


        }
    }

    public void createEmployee(String name, String email, int phoneNumber, int salary, Date birthday){
            try {
                this.initConnection();

                String query = "INSERT INTO employees (name,email,phoneNumber,salary,birthday) VALUES (?,?,?,?,?)";

                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,name);
                statement.setString(2,email);
                statement.setInt(3,phoneNumber);
                statement.setInt(4,salary);
                statement.setDate(5,birthday);

                statement.execute();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                this.closeConnection();

            }
    }

    public void createTask(String title, String description, Date dueDate, int assignee){
        try {
            this.initConnection();

            String query = "INSERT INTO tasks (title,description,dueDate,employeeID) VALUES (?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,title);
            statement.setString(2,description);
            statement.setInt(4,assignee);
            statement.setDate(3,dueDate);

            statement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeConnection();

        }
    }

    public void deleteEmployee(String table, int employeeID){
        try {
            this.initConnection();

            String query = "DELETE FROM employees WHERE employeeID = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,employeeID);

            statement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeConnection();

        }
    }

    public void deleteTask(String table, int taskID){
        try {
            this.initConnection();

            String query = "DELETE FROM tasks WHERE taskID = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,taskID);

            statement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeConnection();

        }
    }

    public void updateEmployee(String table, String name, String email, String salary, String phoneNum, String bday, int employeeID){
        try {
            this.initConnection();

//          UPDATE employees SET name = 'aleksan' WHERE employeeID = 1;
            String query = "UPDATE " + table + " SET " + "name = '" + name + "', email = '"+ email + "', salary = " + Integer.valueOf(salary)+ ", phoneNumber = " + Integer.valueOf(phoneNum)+ ", birthday = '"+ bday  + "' WHERE employeeID = " + employeeID;

            Statement statement = connection.createStatement();
            int cnt = statement.executeUpdate(query);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeConnection();

        }
    }

    public void updateTask(String table, String title, String description, String dueDate, String assignee, int taskID){
        try {
            this.initConnection();

            String query = "UPDATE " + table + " SET title = '" + title + "', description = '" + description + "', dueDate = '" + dueDate + "', employeeID = " + Integer.valueOf(assignee) + " WHERE taskID = " + taskID;

            Statement statement = connection.prepareStatement(query);
            int cnt = statement.executeUpdate(query);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeConnection();

        }
    }

    public void createNewDept(String name, int manager){
        try {
            this.initConnection();

            //INSERT INTO `departments` (`departmentID`, `name`, `managerID`) VALUES (NULL, 'asdasd', '15')
            String query = "INSERT INTO `departments` (`departmentID`, `name`, `managerID`) VALUES (NULL, '" + name+ "', '"+manager+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
    }

    public void mostEffEmp(){
        try {
            this.initConnection();

            String query = "SELECT e.employeeID, e.name, COUNT(t.taskID) AS num_tasks_completed\n" +
                    "FROM employees e\n" +
                    "INNER JOIN tasks t ON e.employeeID = t.employeeID\n" +
                    "WHERE t.dueDate >= DATE_SUB(NOW(), INTERVAL 1 MONTH)\n" +
                    "GROUP BY e.employeeID\n" +
                    "ORDER BY num_tasks_completed DESC\n" +
                    "LIMIT 5;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
    }
    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    public List<Row> fetchDataFromDatabase(String sql) {
        List<Row> rows = new ArrayList<>();


        try{
            this.initConnection();

            String query = sql;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();

            populateRowList("export", rows, rs, resultSetMetaData);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection();
        }

        return rows;
    }

    public ArrayList<String> getListaTabela(){
        return listaTabela;
    }

    public void setListaTabela(ArrayList<String> listaTabela) {
        this.listaTabela = listaTabela;
    }

    public DatabaseMetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(DatabaseMetaData metaData) {
        this.metaData = metaData;
    }
    public static class UniqueConstraint {
        public String table;
        public String name;
        public List<String> columns = new ArrayList<>();
        public String toString() {
            return String.format("[%s] %s: %s", table, name, columns);
        }
    }

    public List<UniqueConstraint> getUniqueConstraints(String table) throws SQLException {
        Map<String, UniqueConstraint> constraints = new HashMap<>();
        try {
            this.initConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        DatabaseMetaData dm = this.connection.getMetaData();
        ResultSet rs = dm.getIndexInfo(null, null, table, true, true);
        while(rs.next()) {
            String indexName = rs.getString("index_name");
            String columnName = rs.getString("column_name");

            UniqueConstraint constraint = new UniqueConstraint();
            constraint.table = table;
            constraint.name = indexName;
            constraint.columns.add(columnName);

            constraints.compute(indexName, (key, value) -> {
                if (value == null) { return constraint; }
                value.columns.add(columnName);
                return value;
            });
        }

        return new ArrayList<>(constraints.values());
    }
}
