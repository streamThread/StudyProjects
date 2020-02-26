import bankClients.IndividualEntrepreneur;
import bankClients.PhysicalEntity;

public class Main {
    public static void main(String[] args) {

        PhysicalEntity vasiliyPetrovich = new PhysicalEntity(200);
        vasiliyPetrovich.showBalance();
        vasiliyPetrovich.takeOffMoney(400);
        vasiliyPetrovich.takeOffMoney(200);

        IndividualEntrepreneur antoninaLvovna = new IndividualEntrepreneur(1000);
        antoninaLvovna.showBalance();
        antoninaLvovna.putMoney(1000);

    }
}
