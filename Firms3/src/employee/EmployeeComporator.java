package employee;

import java.util.Comparator;

public class EmployeeComporator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return Integer.compare(employee2.getMonthSalary(), employee1.getMonthSalary());
    }
}
