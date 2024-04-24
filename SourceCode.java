
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Munna
 */
import java.util.*;
import java.util.stream.Collectors;

public class SourceCode {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Emp1", "CS", 10000),
                new Employee("Emp2", "CS", 20000),
                new Employee("Emp3", "CS", 15000),
                new Employee("Emp4", "IT", 30000),
                new Employee("Emp5", "IT", 18000),
                new Employee("Emp6", "IT", 40000)
        );

        System.out.println("All employees:");
        System.out.printf("%-5s%-10s%-15s%-5s%n", "S.no", "Employee", "Department", "Salary");
        int count = 1;
        for (Employee emp : employees) {
            System.out.printf("%-7s%-12s%-11s%-15s%n", count++, emp.getName(), emp.getDepartment(), emp.getSalary());
        }
        System.out.println();

        Map<String, List<Employee>> bySalary = employees.stream().filter(e -> e.getSalary() > 15000).collect(Collectors.groupingBy(Employee::getDepartment));
        
        System.out.println("Salary greater than 15,000 are");
        System.out.printf("%-5s%-10s%-15s%-5s%n", "S.no", "Employee", "Department", "Salary");
        count = 1;
        for (Map.Entry<String, List<Employee>> entry : bySalary.entrySet()) {
            for (Employee emp : entry.getValue()) {
                System.out.printf("%-7s%-12s%-11s%-15s%n", count++, emp.getName(), emp.getDepartment(), emp.getSalary());
            }
        }
    }
}

class Employee {
    private String name;
    private String department;
    private int salary;

    public Employee(String name, String department, int salary) {
        super();
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
}

