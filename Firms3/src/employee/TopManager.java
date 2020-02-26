package employee;

import company.Company;

public class TopManager implements Employee {

    private static TopManager topManager;
    private final int PERCENTAGE_OF_SALARY = 150;
    private final int DEFAULT_COMPANYS_INCOME = 10000000;
    private final String POSITION = "топ менеджер";
    private Company company;
    private int topManagerSalary;

    private TopManager() {
        topManagerSalary = 100000 + (int) (Math.random() * 100000);
    }

    public static TopManager getTopManager() {
        topManager = new TopManager();
        return topManager;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String getPosition() {
        return POSITION;
    }

    @Override
    public int getMonthSalary() {
        if (company != null) {
            int monthSalary;
            if (company.getIncome() > DEFAULT_COMPANYS_INCOME) {
                monthSalary = topManagerSalary + (topManagerSalary / 100 * PERCENTAGE_OF_SALARY);
            } else {
                monthSalary = topManagerSalary;
            }
            return monthSalary;
        }
        return 0;
    }
}

