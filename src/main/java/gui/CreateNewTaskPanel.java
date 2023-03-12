package gui;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class CreateNewTaskPanel extends JDialog {
    private String taskTitle;
    private String description;
    private int assignee;
    private Date dueDate;

    private JTextField titleField;
    private JTextArea descriptionField;
    private JTextField assigneeField;
    private JTextField dateField;
    public CreateNewTaskPanel(Frame parent, String title) {
        super(parent,title);
        this.titleField = new JTextField();
        this.descriptionField = new JTextArea();
        this.assigneeField = new JTextField();
        this.dateField = new JTextField("Enter in yyyy-mm-dd format");

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
            taskTitle = titleField.getText();
            description = descriptionField.getText();
            assignee = Integer.parseInt(assigneeField.getText());
            dueDate = java.sql.Date.valueOf(dateField.getText());

            MainFrame.getInstance().getAppCore().createTask(title,description,assignee,dueDate,"tasks");
            dispose();
        });

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> {dispose();});

        mainPanel.add(new JLabel("Enter task title"));
        mainPanel.add(titleField);

        mainPanel.add(new JLabel("Enter task description"));
        mainPanel.add(descriptionField);

        mainPanel.add(new JLabel("Enter assigne ID"));
        mainPanel.add(assigneeField);

        mainPanel.add(new JLabel("Enter taks due date"));
        mainPanel.add(dateField);

        mainPanel.add(createBtn);
        mainPanel.add(cancelBtn);

        this.add(mainPanel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
