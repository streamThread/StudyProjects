package employee;

import company.Company;

public interface Employee {
      int getMonthSalary();
      String getPosition();
      void setCompany(Company company);
}
