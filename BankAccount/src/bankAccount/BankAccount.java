package bankAccount;

public class BankAccount {

    private double currentAccount;

    public BankAccount(double currentAccount) {
        this.currentAccount = currentAccount;
    }

    public void showBalance() {
        System.out.printf("\nВаш баланс равен %.2f", currentAccount);
    }

    public void putMoney(double money) {
        currentAccount = currentAccount + money;
        showBalance();
    }

    public void takeOffMoney(double money) {
        if (money > currentAccount) {
            System.out.print("\nНедостаточно средств");
        } else {
            currentAccount = currentAccount - money;
            showBalance();
        }
    }

    public double getCurrentAccount(){
        return currentAccount;
    }
}
