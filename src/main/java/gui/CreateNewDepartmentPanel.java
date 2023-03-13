package gui;

import errorHandler.ErrorType;
import resource.data.Row;
import utils.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class CreateNewDepartmentPanel extends JDialog {
    private String name;
    private JTextField nameField;
    private JComboBox comboBox;
    private HashMap<String,String> employees;
    private List<Row> rows;
    private int manager;

    public CreateNewDepartmentPanel(Frame parent, String title) {
        super(parent,title);
        this.nameField = new JTextField();
        this.comboBox = new JComboBox();

        setSize(400,300);
        setLocationRelativeTo(parent);
        setModal(true);

        JPanel mainPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(3,3);
        gridLayout.setHgap(50);
        gridLayout.setVgap(80);
        mainPanel.setLayout(gridLayout);

        JButton createBtn = new JButton("Create department");
        createBtn.addActionListener(e -> {
            if (nameField.getText().isEmpty() || comboBox.getSelectedItem() == null){
                MainFrame.getInstance().getAppCore().getErrorHandler().generateError(ErrorType.EMPTY);
            }else {
                name = nameField.getText();
                manager = Integer.parseInt(employees.get(comboBox.getSelectedItem()));
                MainFrame.getInstance().getAppCore().createNewDept(name,manager);
                dispose();
            }
        });

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> {dispose();});

        mainPanel.add(new JLabel("Enter department name"));
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Select department manager"));
        mainPanel.add(comboBox);
        getEmployees(comboBox);

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

}
