package company;

import employee.Employee;
import employee.EmployeeComporator;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private static Company company;
    private ArrayList<Employee> listOfEmployees = new ArrayList<>();
    private int companysIncome;

    private Company() {
        companysIncome = 10000000 + (int) (Math.random() * 10000000);
    }

    public static Company getCompany() {
        company = new Company();
        return company;
    }

    public ArrayList<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public int getIncome() {
        return companysIncome;
    }

    public void hire(Employee employee) {
        listOfEmployees.add(employee);
    }

    public void hireAll(ArrayList<Employee> employeeArrayList) {
        listOfEmployees.addAll(employeeArrayList);
        for (Employee employee : listOfEmployees) {
            employee.setCompany(company);
        }
    }

    public void printListOfEmployeesSalary() {
        for (Employee position : listOfEmployees) {
            System.out.println(position.getMonthSalary());
        }

    }

    public List<Employee> getTopSalaryStaff(int count) {

        if (count > 1 & count <= listOfEmployees.size()) {
            listOfEmployees.sort(new EmployeeComporator());
            return listOfEmployees.subList(0, count - 1);
        }
        return listOfEmployees;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (count > 1 & count <= listOfEmployees.size()) {
            listOfEmployees.sort(new EmployeeComporator().reversed());
            return listOfEmployees.subList(0, count - 1);
        }
        return listOfEmployees;
    }

    public void fire(int percentOfEmployees) {
        int size = listOfEmployees.size();
        if (size > 0) {
            if (percentOfEmployees > 0 & percentOfEmployees < 100) {
                for (double i = 0; i < size / 100.00 * percentOfEmployees; i++) {
                    int index = (int) ((listOfEmployees.size() - 1) * Math.random());
                    listOfEmployees.remove(index);
                }
            }
            if (percentOfEmployees == 100) {
                listOfEmployees.clear();
            }
            if (percentOfEmployees == 0) {
                System.out.println("Ни один сотрудник не уволен");
            }
        } else {
            System.out.println("В компании нет ни одного сотрудника для увольнения");
        }
    }

    public boolean fire(Employee employee) {
        return listOfEmployees.remove(employee);
    }
}


