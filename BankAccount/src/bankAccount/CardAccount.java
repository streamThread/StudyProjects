package bankAccount;

public class CardAccount extends BankAccount {

    private final float COMISSION = 1;

    public CardAccount(double currentAccount) {
        super(currentAccount);
    }

    public void takeOffMoney(double money) {
        double moneyWithComission = money + ((money / 100 * COMISSION));
        super.takeOffMoney(moneyWithComission);
    }
}

