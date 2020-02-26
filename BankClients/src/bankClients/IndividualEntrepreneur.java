package bankClients;

public class IndividualEntrepreneur extends Client {

    private final float COMISSION_UNDER_1000 = 1;
    private final float COMISSION_OVER_1000 = (float) 0.5;

    public IndividualEntrepreneur(double currentAccount) {
        super(currentAccount);
    }

    public void putMoney(double money) {
        if (money < 1000) {
            double moneyWithComission = money - (money / 100 * COMISSION_UNDER_1000);
            super.putMoney(moneyWithComission);
        } else {
            double moneyWithComission = money - (money / 100 * COMISSION_OVER_1000);
            super.putMoney(moneyWithComission);
        }
    }
}
