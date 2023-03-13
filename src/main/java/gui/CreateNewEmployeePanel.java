package gui;

import errorHandler.ErrorType;
import utils.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class CreateNewEmployeePanel extends JDialog {
    private String name;
    private String email;
    private int phoneNumber;
    private int salary;
    private Date birthDay;

    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField salaryField;
    private HintTextField dateField;

    public CreateNewEmployeePanel(Frame parent, String title) {
        super(parent,title);
        this.nameField = new JTextField();
        this.emailField = new JTextField();
        this.phoneField = new JTextField();
        this.salaryField= new JTextField();
        this.dateField = new HintTextField("Enter in yyyy-mm-dd format");

        setSize(400,300);
        setLocationRelativeTo(parent);
        setModal(true);

        JPanel mainPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(6,6);
        gridLayout.setHgap(15);
        gridLayout.setVgap(10);
        mainPanel.setLayout(gridLayout);

        JButton createBtn = new JButton("Create employee");
        createBtn.addActionListener(e -> {
            if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty() || salaryField.getText().isEmpty() || dateField.getText().isEmpty()){
                MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.EMPTY);
            }else if ((Integer.parseInt(salaryField.getText()) ) < 1) {
                MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.MINUS);
            }else{
                name = nameField.getText();
                email = emailField.getText();
                phoneNumber = Integer.parseInt(phoneField.getText());
                salary = Integer.parseInt(salaryField.getText());
                birthDay = java.sql.Date.valueOf(dateField.getText());
                MainFrame.getInstance().getAppCore().createEmployee(name, email, phoneNumber, salary, birthDay, "employees");
                dispose();
            }
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
