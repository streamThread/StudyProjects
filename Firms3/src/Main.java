import company.Company;
import employee.Employee;
import employee.Manager;
import employee.Operator;
import employee.TopManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Employee> employeeArrayList = new ArrayList<>();

    public static void main(String[] args) {

        Company oooHeart = Company.getCompany();

        addAllEmployeeList(180, 80, 10);

        oooHeart.hireAll(employeeArrayList);

        listOfTop(15, oooHeart);

        listOfLowest(30, oooHeart);

        oooHeart.fire(50);

        listOfTop(15, oooHeart);

        listOfLowest(30, oooHeart);

        for (int i = 0; i < 50; i++) {

            oooHeart.fire(findEmployeeAtList(Manager.getManager(), oooHeart));

            System.out.println(oooHeart.getListOfEmployees().size());
        }
    }

    private static void listOfTop(int count, Company company) {
        if (company.getListOfEmployees().size() >= count) {
            System.out.println("Список " + count + " наибольших зарплат по убыванию:");
            for (Employee position : company.getTopSalaryStaff(count)) {
                System.out.println(position.getMonthSalary());
            }
        } else {
            System.out.println("В компании работает " + company.getListOfEmployees().size() + " человек. В списке не может быть больше этого количества.");
        }
    }

    private static void listOfLowest(int count, Company company) {
        if (company.getListOfEmployees().size() >= count) {
            System.out.println("Список " + count + " наименьших зарплат по возрастанию:");
            for (Employee position : company.getLowestSalaryStaff(count)) {
                System.out.println(position.getMonthSalary());
            }
        } else {
            System.out.println("В компании работает " + company.getListOfEmployees().size() + " человек. В списке не может быть больше этого количества.");
        }
    }

    private static void addAllEmployeeList() {

        System.out.print("Введите количество нанимаемых операторов\n");
        hireOperators(getNumber());

        System.out.print("Введите количество нанимаемых менеджеров\n");
        hireManagers(getNumber());

        System.out.print("Введите количество нанимаемых топ менеджеров\n");
        hireTopManagers(getNumber());
    }

    private static void addAllEmployeeList(int operatorsCount, int managersCount, int topManagersCount) {
        hireOperators(operatorsCount);
        hireManagers(managersCount);
        hireTopManagers(topManagersCount);
    }

    private static void hireOperators(int operatorsCount) {
        for (int i = 0; i < operatorsCount; i++) {
            employeeArrayList.add(Operator.getOperator());
        }
    }

    private static void hireManagers(int managersCount) {
        for (int i = 0; i < managersCount; i++) {
            employeeArrayList.add(Manager.getManager());
        }
    }

    private static void hireTopManagers(int topManagersCount) {
        for (int i = 0; i < topManagersCount; i++) {
            employeeArrayList.add(TopManager.getTopManager());
        }
    }

    private static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String inputNumer = scanner.nextLine();
            String numberRegex = "^(\\s+)?\\d+(\\s+)?$";
            if (inputNumer.matches(numberRegex)) {
                return Integer.parseInt(inputNumer);
            }
            System.out.print("\nОшибка ввода. Введите натуральное число.\n");
        }
    }

    private static Employee findEmployeeAtList(Employee employee, Company company) {
        if (company.getListOfEmployees().size() > 0) {
            Iterator<Employee> it = company.getListOfEmployees().iterator();
            while (it.hasNext()) {
                Employee employeeIT = it.next();
                if (employee.getClass().getName().equals(employeeIT.getClass().getName())) {
                    return employeeIT;
                }
            }
        }
        System.out.println("Ошибка. Наймите сотрудников на должность \"" + employee.getPosition() + "\" прежде, чем их увольнять.");
        return employee;
    }
}

