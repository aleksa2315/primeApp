package gui;

import errorHandler.ErrorType;
import resource.data.Row;
import utils.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class CreateNewTaskPanel extends JDialog {
    private String taskTitle;
    private String description;
    private int assignee;
    private Date dueDate;

    private HashMap<String,String> employees;
    private List<Row> rows;
    private JTextField titleField;
    private JTextArea descriptionField;
    private JTextField assigneeField;
    private HintTextField dateField;
    private JComboBox comboBox;
    public CreateNewTaskPanel(Frame parent, String title) {
        super(parent,title);
        this.titleField = new JTextField();
        this.descriptionField = new JTextArea();
        this.assigneeField = new JTextField();
        this.dateField = new HintTextField("Enter in yyyy-mm-dd format");
        this.comboBox = new JComboBox();

        setSize(400,300);
        setLocationRelativeTo(parent);
        setModal(true);

        JPanel mainPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(5,5);
        gridLayout.setHgap(15);
        gridLayout.setVgap(10);
        mainPanel.setLayout(gridLayout);

        JButton createBtn = new JButton("Create task");
        createBtn.addActionListener(e -> {
            if (titleField.getText().isEmpty() || descriptionField.getText().isEmpty() || comboBox.getSelectedItem() == null || dateField.getText().isEmpty()){
                MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.EMPTY);
            }else {
                taskTitle = titleField.getText();
                description = descriptionField.getText();
                assignee = Integer.parseInt(employees.get(comboBox.getSelectedItem()));
                dueDate = java.sql.Date.valueOf(dateField.getText());

                MainFrame.getInstance().getAppCore().createTask(taskTitle, description, assignee, dueDate, "tasks");
                dispose();
            }
        });

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> {
            dispose();});

        mainPanel.add(new JLabel("Enter task title"));
        mainPanel.add(titleField);

        mainPanel.add(new JLabel("Enter task description"));
        mainPanel.add(descriptionField);

        mainPanel.add(new JLabel("Select assignee"));
        mainPanel.add(comboBox);
        getEmployees(comboBox);

        mainPanel.add(new JLabel("Enter task due date"));
        mainPanel.add(dateField);

        mainPanel.add(createBtn);
        mainPanel.add(cancelBtn);

        this.add(mainPanel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void getEmployees(JComboBox comboBox){
        rows = MainFrame.getInstance().getAppCore().getTable("employees");
        employees = new HashMap<>();

        for (Row row : rows){
            employees.put(row.getFields().get("name").toString(),row.getFields().get("employeeID").toString());
            comboBox.addItem(row.getFields().get("name").toString());
        }
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public int getAssignee() {
        return assignee;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
