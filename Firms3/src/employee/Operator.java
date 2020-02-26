package employee;

import company.Company;

public class Operator implements Employee {


    private static Operator operator;
    private final String POSITION = "оператор";
    private int operatorSalary;
    private Company company;

    private Operator() {
        operatorSalary = 30000 + (int) (Math.random() * 30000);
    }

    public static Operator getOperator() {
        operator = new Operator();
        return operator;
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
        return operatorSalary;
    }
}
