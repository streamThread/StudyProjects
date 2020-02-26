package bankClients;

public class LegalEntity extends Client {

    private final float COMISSION = 1;

    public LegalEntity(double currentAccount) {
        super(currentAccount);
    }

    public void takeOffMoney(double money) {
        double moneyWithComission = money + (money / 100 * COMISSION);
        super.takeOffMoney(moneyWithComission);
    }

}
