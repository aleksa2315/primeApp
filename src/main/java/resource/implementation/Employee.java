package resource.implementation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeID", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "email", nullable = false, length = 20)
    private String email;

    @Column(name = "phoneNumber")
    private Integer phoneNumber;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToMany(mappedBy = "employeeID")
    private Set<Task> tasks = new LinkedHashSet<>();

}