package gui;

import utils.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class UpdateEmployeePanel extends JDialog {
    private String name;
    private String email;
    private int phoneNumber;
    private int salary;
    private Date birthDay;

    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField salaryField;
    private JTextField dateField;

    public UpdateEmployeePanel(Frame parent, String title, String name, String email, String phoneNum, String bday, String salary) {
        super(parent,title);
        this.nameField = new JTextField(name);
        this.emailField = new JTextField(email);
        this.phoneField = new JTextField(phoneNum);
        this.salaryField= new JTextField(salary);
        this.dateField = new JTextField(bday);

        setSize(400,300);
        setLocationRelativeTo(parent);
        setModal(true);

        JPanel mainPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(6,6);
        gridLayout.setHgap(15);
        gridLayout.setVgap(10);
        mainPanel.setLayout(gridLayout);

        JButton createBtn = new JButton("Update employee");
        createBtn.addActionListener(e -> {
            setFields();
            dispose();
        });

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> {dispose();});

        mainPanel.add(new JLabel("Enter employee name"));
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Enter employee email"));
        mainPanel.add(emailField);

        mainPanel.add(new JLabel("Enter employee phone number"));
        mainPanel.add(phoneField);

        mainPanel.add(new JLabel("Enter employee salary"));
        mainPanel.add(salaryField);

        mainPanel.add(new JLabel("Enter employee date of birth"));
        mainPanel.add(dateField);

        mainPanel.add(createBtn);
        mainPanel.add(cancelBtn);

        this.add(mainPanel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void setFields(){
        name = nameField.getText();
        email = emailField.getText();
        salary = Integer.parseInt(salaryField.getText());
        phoneNumber = Integer.parseInt(phoneField.getText());
        birthDay = java.sql.Date.valueOf(dateField.getText());
    }

    @Override
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public Date getBirthDay() {
        return birthDay;
    }
}
