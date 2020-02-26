import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВведите число от 1 до 10");
            String input = scanner.nextLine();
            if (input.matches("^(10|[1-9])$")) {
                int inputNumber = Integer.parseInt(input);

                String[][] xxx = new String[inputNumber][inputNumber];
                for (int a = 0; a < inputNumber; a++) {
                    for (int b = 0; b < inputNumber; b++) {
                        xxx[a][b] = " ";
                    }
                }
                for (int i = 0; i < inputNumber; i++) {
                    xxx[i][i] = "x";
                }
                int k = 0;
                for (int j = inputNumber - 1; j >= 0; j--) {
                    if (k < inputNumber) {
                        xxx[j][k] = "x";
                        k++;
                    }
                }

                for (int i = 0; i < xxx.length; i++) {
                    if(i!=0) {
                        System.out.print("\n");
                    }
                    for (int j = 0; j < xxx.length; j++) {
                        System.out.print(xxx[i][j]);
                    }
                }
            } else {
                System.out.println("Ошибка!");
            }
        }
    }
}
