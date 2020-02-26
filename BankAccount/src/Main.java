import bankAccount.BankAccount;
import bankAccount.CardAccount;
import bankAccount.Deposit;

public class Main {
    public static void main(String[] args) {
        BankAccount simple = new BankAccount(1000);
        simple.showBalance();
        simple.putMoney(3450);
        simple.takeOffMoney(5000);
        simple.takeOffMoney(2000);

        Deposit deposit = new Deposit(6000);
        deposit.showBalance();
        simple.showBalance();
        deposit.putMoney(1000);
        deposit.takeOffMoney(5000);
        simple.showBalance();

        CardAccount card = new CardAccount(3000);
        card.putMoney(1000);
        card.takeOffMoney(4000);
        card.takeOffMoney(2000);
    }
}
