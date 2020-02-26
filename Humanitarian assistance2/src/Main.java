import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int containersInTheTruck = 12;
        int boxesInContainer = 27;
        int a = 0; //счетчик цикла грузовиков
        int b = 0; //счетчик цикла контейнеров
        int c = 0; //счетчик цикла ящиков


        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество ящиков: ");
        int boxesNumber = in.nextInt();

        int conteinersNumber = boxesNumber % boxesInContainer != 0 ? boxesNumber / boxesInContainer + 1 : boxesNumber / boxesInContainer;
        int truckNumber = conteinersNumber % containersInTheTruck != 0 ? conteinersNumber / containersInTheTruck + 1 : conteinersNumber / containersInTheTruck;
        System.out.println(conteinersNumber);
        System.out.println(truckNumber);

        another:
        while (a < truckNumber) {
            a++;
            System.out.println("Грузовик " + a);
            other:
            while (b < conteinersNumber) {
                b++;
                System.out.println("\tКонтейнер " + b);
                while (c < boxesNumber) {
                    c++;
                    System.out.println("\t\tЯщик " + c);
                    if (c % (boxesInContainer * containersInTheTruck) == 0) {
                        continue another;
                    }
                    if (c % boxesInContainer == 0) {
                        continue other;
                    }

                }

            }
        }
    }
}
















