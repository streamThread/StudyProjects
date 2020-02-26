package bankClients;

class Client {

    private double currentAccount;

    Client(double currentAccount) {
        this.currentAccount = currentAccount;
    }

    public void showBalance() {
        System.out.printf("\nВаш баланс: %.2f", currentAccount);
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
}

