package resource.implementation;

import java.sql.Date;

public class Employee {
    private String name;
    private String email;
    private int phoneNum;
    private Date birthday;
    private int salary;

    public Employee(String name, String email, int phoneNum, Date birthday, int salary) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.birthday = birthday;
        this.salary = salary;
    }
}
