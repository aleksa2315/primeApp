package gui;

import utils.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class UpdateTaskPanel extends JDialog {
    private String taskTitle;
    private String description;
    private int assignee;
    private Date dueDate;

    private JTextField titleField;
    private JTextArea descriptionField;
    private JTextField assigneField;
    private JTextField dateField;

    public UpdateTaskPanel(Frame parent, String title, String taskTitle, String description, String assigneID, String dueDate) {
        super(parent,title);
        this.titleField = new JTextField(taskTitle);
        this.descriptionField = new JTextArea(description);
        this.assigneField = new JTextField(assigneID);
        this.dateField = new JTextField(dueDate);

        setSize(400,300);
        setLocationRelativeTo(parent);
        setModal(true);

        JPanel mainPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(6,6);
        gridLayout.setHgap(15);
        gridLayout.setVgap(10);
        mainPanel.setLayout(gridLayout);

        JButton createBtn = new JButton("Update task");
        createBtn.addActionListener(e -> {
            setFields();
            dispose();
        });

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> {dispose();});

        mainPanel.add(new JLabel("Enter task title"));
        mainPanel.add(titleField);

        mainPanel.add(new JLabel("Enter task description"));
        mainPanel.add(descriptionField);

        mainPanel.add(new JLabel("Enter assigneID"));
        mainPanel.add(assigneField);


        mainPanel.add(new JLabel("Enter task due date"));
        mainPanel.add(dateField);

        mainPanel.add(createBtn);
        mainPanel.add(cancelBtn);

        this.add(mainPanel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void setFields(){
        taskTitle = titleField.getText();
        description = descriptionField.getText();
        assignee = Integer.parseInt(assigneField.getText());
        dueDate = java.sql.Date.valueOf(dateField.getText());
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
