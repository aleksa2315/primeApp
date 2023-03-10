package resource.implementation;

import java.sql.Date;

public class Task {
    private String title;
    private Employee assignee;
    private String description;
    private Date dueDate;

    public Task(String title, Employee assignee, String description, Date dueDate) {
        this.title = title;
        this.assignee = assignee;
        this.description = description;
        this.dueDate = dueDate;
    }
}
