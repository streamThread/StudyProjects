import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Введите полное имя (Фамилия Имя Отчество): ");
            String fullName = scanner.nextLine();
            if (fullName.matches("\\s*\\p{IsCyrillic}+\\s+\\p{IsCyrillic}+\\s+\\p{IsCyrillic}+\\s*")) {

                String[] arrayName = fullName.trim().split("\\s+");
//
                if (!isUpperCase(arrayName)) {
                    System.out.println("Ошибка! Имена собственные пишутся с заглавной буквы");
                    continue;
                }

                System.out.println("Фамилия: " + arrayName[0]);
                System.out.println("Имя: " + arrayName[1]);
                System.out.println("Отчество: " + arrayName[2]);
            }
            System.out.println("Ошибка! ФИО вводится кириллицей, разделяя слова пробелами. Пример: Яков Иван Петрович");
        }
    }

    private static boolean isUpperCase(String[] arrayName) {
        for (String names : arrayName) {
            Character up = names.charAt(0);
            if (!Character.isDigit(up)) {
                if (Character.isUpperCase(up)) {
                    return true;
                }
            }
        }
        return false;
    }
}
















