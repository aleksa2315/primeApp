package core;

import controller.ExitAction;
import database.Database;
import database.DatabaseImpl;
import database.MYSQLRepository;
import database.settings.Settings;
import database.settings.SettingsImpl;
import gui.App;
import gui.MainFrame;
import gui.table.TableModel;
import resource.data.Row;
import resource.implementation.InformationResource;
import tree.Implementation.TreeImplementation;
import tree.Tree;
import utils.Constants;

import javax.swing.tree.DefaultTreeModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AppCore extends AppFramework{
    private Database database;
    private Settings settings;
    private TableModel tableModel;
    private DefaultTreeModel defaultTreeModel;
    private Tree tree;
    private List<Row> rowList = new ArrayList<>();

    public List<Row> getRowList() {
        return rowList;
    }
    private static AppCore instance;
    public void run() {
        this.gui.start();
    }

    private AppCore(){
        this.settings = initSettings();
        this.database = new DatabaseImpl(new MYSQLRepository(this.settings));
        this.tableModel = new TableModel();
        this.tree = new TreeImplementation();
    }

    public static AppCore getInstance(){
        if (instance == null){
            instance = new AppCore();
        }
        return instance;
    }

    public static void main(String[] args){
        Gui gui = new App();
        AppCore appCore = AppCore.getInstance();
        appCore.init(gui);
        MainFrame.getInstance().setAppCore(appCore);
        appCore.run();
        MainFrame.getInstance().setTable();
        MainFrame.getInstance().addWindowListener(MainFrame.getInstance().getActionManager().getExitAction());
    }
    private Settings initSettings() {
        Settings settingsImplementation = new SettingsImpl();
        settingsImplementation.addParameter("mysql_ip", Constants.MYSQL_IP);
        settingsImplementation.addParameter("mysql_database", Constants.MYSQL_DATABASE);
        settingsImplementation.addParameter("mysql_username", Constants.MYSQL_USERNAME);
        settingsImplementation.addParameter("mysql_password", Constants.MYSQL_PASSWORD);
        settingsImplementation.addParameter("mysql_port", Constants.MYSQL_PORT);
        return settingsImplementation;
    }

    public DefaultTreeModel loadResource(){
        InformationResource ir = (InformationResource) this.database.loadResource();
        return this.tree.generateTree(ir);
    }

    public void readDataFromTable(String fromTable){
        this.rowList = (this.database.readDataFromTable(fromTable));
        tableModel.setRows(this.rowList);
    }

    public void fetchData(String sql){
            this.rowList = (this.database.fetchDataFromDatabase(sql));
            tableModel.setRows(this.rowList);
    }

    public void createEmployee(String name, String email, int phoneNumber, int salary, Date birthday, String table){
        this.database.createEmployee(name,email,phoneNumber,salary,birthday);
        readDataFromTable(table);
    }

    public void createTask(String title, String description, int employeeID, Date dueDate, String table){
        this.database.createTask(title,description,dueDate,employeeID);
        readDataFromTable(table);
    }

    public void deleteEmployee(String table, int employeeID){
        this.database.deleteEmployee(table,employeeID);
        readDataFromTable(table);
    }

    public void deleteTask(String table, int taskID){
        this.database.deleteTask(table,taskID);
        readDataFromTable(table);
    }

    public void updateEmployee(String table, String columnName, String newVal, int employeeID){
        this.database.updateEmployee(table,columnName,newVal,employeeID);
        readDataFromTable(table);
    }

    public void updateTask(String table, String columnName, String newVal, int taskID){
        this.database.updateTask(table,columnName,newVal,taskID);
        readDataFromTable(table);
    }

    public void mostEffEmp(){
        this.database.mostEffEmp();
    }
    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public DefaultTreeModel getDefaultTreeModel() {
        return defaultTreeModel;
    }

    public void setDefaultTreeModel(DefaultTreeModel defaultTreeModel) {
        this.defaultTreeModel = defaultTreeModel;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public void setRowList(List<Row> rowList) {
        this.rowList = rowList;
    }

    public static void setInstance(AppCore instance) {
        AppCore.instance = instance;
    }
}
