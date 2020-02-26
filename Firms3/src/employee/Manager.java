package employee;

import company.Company;

public class Manager implements Employee {

    private static Manager manager;
    private final int PERCENTAGE_OF_SALES = 5;
    private final String POSITION = "менеджер";
    private int monthSalary;
    private int managerSalary;
    private Company company;

    private Manager() {
        managerSalary = 50000 + (int) (Math.random() * 50000);
        int salesVolume = 1000000 + (int) (Math.random() * 1000000);
        monthSalary = managerSalary + (salesVolume / 100 * PERCENTAGE_OF_SALES);
    }

    public static Manager getManager() {
        manager = new Manager();
        return manager;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String getPosition() {
        return POSITION;
    }

    @Override
    public int getMonthSalary() {
        return monthSalary;
    }
}
