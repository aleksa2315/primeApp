package gui;

import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JPanel {

    private JPanel toolPanel;
    private JPanel employeePanel;
    private JPanel taskPanel;
    public ToolPanel(){
        setBoxLayout();
        this.employeePanel = new JPanel();
        this.taskPanel = new JPanel();

        this.add(employeePanel());
        this.add(new JSeparator());
        this.add(taskPanel());
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

}
