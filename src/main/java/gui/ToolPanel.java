package gui;

import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JPanel {

    private JPanel toolPanel;
    private JPanel employeePanel;
    private JPanel taskPanel;
    private JPanel departmentPanel;
    private JPanel statisticsPanel;
    public ToolPanel(){
        setBoxLayout();
        this.employeePanel = new JPanel();
        this.taskPanel = new JPanel();
        this.departmentPanel = new JPanel();
        this.statisticsPanel = new JPanel();

        this.add(employeePanel());
        this.add(new JSeparator());
        this.add(taskPanel());
        this.add(new JSeparator());
        this.add(departmentPanel());
        this.add(new JSeparator());
        this.add(statisticsPanel());
    }

    private void setBoxLayout(){
        BoxLayout boxLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
    }

    private JPanel employeePanel(){
        BoxLayout layout = new BoxLayout(employeePanel,BoxLayout.Y_AXIS);
        employeePanel.setLayout(layout);
        JLabel label = new JLabel("Employee tools");

        JButton create = new JButton("Create new employee");
        create.setAction(MainFrame.getInstance().getActionManager().getCreateAction());

        JButton delete = new JButton("Delete employee");
        delete.setAction(MainFrame.getInstance().getActionManager().getDeleteAction());

        JButton read = new JButton("Read employee data");
        read.setAction(MainFrame.getInstance().getActionManager().getReadAction());

        JButton update = new JButton("Update employee data");
        update.setAction(MainFrame.getInstance().getActionManager().getUpdateAction());

        employeePanel.add(label);
        employeePanel.add(create);
        employeePanel.add(delete);
        employeePanel.add(read);
        employeePanel.add(update);

        return employeePanel;
    }

    private JPanel taskPanel(){
        BoxLayout layout = new BoxLayout(this.taskPanel,BoxLayout.Y_AXIS);
        this.taskPanel.setLayout(layout);
        JLabel label = new JLabel("Task tools");

        JButton create = new JButton("Create new Task");
        create.setAction(MainFrame.getInstance().getActionManager().getCreateTaskAction());

        JButton delete = new JButton("Delete Task");
        delete.setAction(MainFrame.getInstance().getActionManager().getDeleteTaskAction());

        JButton read = new JButton("Read Task data");
        read.setAction(MainFrame.getInstance().getActionManager().getReadTaskAction());

        JButton update = new JButton("Update Task data");
        update.setAction(MainFrame.getInstance().getActionManager().getUpdateTaskAction());

        this.taskPanel.add(label);
        this.taskPanel.add(create);
        this.taskPanel.add(delete);
        this.taskPanel.add(read);
        this.taskPanel.add(update);

        return taskPanel;
    }

    private JPanel departmentPanel(){
        BoxLayout layout = new BoxLayout(this.departmentPanel,BoxLayout.Y_AXIS);
        this.departmentPanel.setLayout(layout);
        JLabel label = new JLabel("Department tools");

        JButton create = new JButton("Create new department");
        create.setAction(MainFrame.getInstance().getActionManager().getCreateDepartmentAction());

        JButton read = new JButton("Read department");
        read.setAction(MainFrame.getInstance().getActionManager().getReadDepartmentAction());

        this.departmentPanel.add(label);
        this.departmentPanel.add(create);
        this.departmentPanel.add(read);

        return departmentPanel;
    }

    private JPanel statisticsPanel(){
        BoxLayout layout = new BoxLayout(this.statisticsPanel,BoxLayout.Y_AXIS);
        this.statisticsPanel.setLayout(layout);
        JLabel label = new JLabel("Statistics tools");

        JButton efficientEmployees = new JButton("Most efficient employees");
        efficientEmployees.setAction(MainFrame.getInstance().getActionManager().getMostEfficentAction());

        JButton efficientDepartments = new JButton("Most efficient departments");
        efficientDepartments.setAction(MainFrame.getInstance().getActionManager().getMostEfficientDeptAction());

        JButton averageAge = new JButton("Average age difference");
        averageAge.setAction(MainFrame.getInstance().getActionManager().getAgeDifferenceAction());

        JButton averageSalary = new JButton("Most efficient departments");
        averageSalary.setAction(MainFrame.getInstance().getActionManager().getAverageSalaryAction());

        JButton taskLoad = new JButton("Most efficient departments");
        taskLoad.setAction(MainFrame.getInstance().getActionManager().getTaskLoadAction());

        this.statisticsPanel.add(label);
        this.statisticsPanel.add(efficientEmployees);
        this.statisticsPanel.add(efficientDepartments);
        this.statisticsPanel.add(averageAge);
        this.statisticsPanel.add(averageSalary);
        this.statisticsPanel.add(taskLoad);


        return statisticsPanel;
    }

}
