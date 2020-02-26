package bankAccount;

import java.util.Calendar;

public class Deposit extends BankAccount {

    private Calendar createDate;
    private Calendar lastPutMoneyDate;

    public Deposit(double currentAccount) {
        super(currentAccount);
        createDate = Calendar.getInstance();
    }

    public void putMoney(double money) {
        lastPutMoneyDate = Calendar.getInstance();
        super.putMoney(money);
    }

    public void takeOffMoney(double money) {
        Calendar takeOffDate = Calendar.getInstance();
        takeOffDate.add(Calendar.MONTH, -1);
        if (!takeOffDate.before(createDate) && !takeOffDate.before(lastPutMoneyDate)) {
            super.takeOffMoney(money);
        } else {
            System.out.print("\nНевозможно снять деньги раньше, чем по просшествии месяца с прошлой операции пополнения или создания счета");
        }
    }
}
