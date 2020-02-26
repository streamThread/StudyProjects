import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("Введите полное имя (Фамилия Имя Отчество): ");
            String fullName = scanner.nextLine();

            char[] charArray = fullName.trim().toCharArray();
            String[] arrayName = fullName.trim().split("\\s+");
            boolean isError = false;
            String errorText = "";

            if ("".equals(fullName.trim())) {
                System.out.println("Ошибка! Вы ничего не ввели");
                continue;
            }

            if (!isDefinedUnicode(charArray)) {
                errorText += "Ошибка! Неподдерживаемый символ кодировки\n";
                isError = true;
            }

            if (isDigit(charArray)) {
                errorText += "Ошибка! Имя не может содержать цифр\n";
                isError = true;
            }

            if (numberOfWords(charArray, arrayName)) {
                errorText += "Ошибка! ФИО содержит некорректное количество слов\n";
                isError = true;
            }

            if (arrayName.length == 1) {
                errorText += "Ошибка! ФИО не может состоять из 1 слова\n";
                isError = true;
            }

            if (!isUpperCase(arrayName)) {
                errorText += "Ошибка! Имена собственные пишутся с заглавной буквы";
                isError = true;
            }

            if (isError) {
                System.out.println(errorText);
                continue;
            }

            System.out.println("Фамилия: " + arrayName[0]);
            System.out.println("Имя: " + arrayName[1]);
            System.out.println("Отчество: " + arrayName[2]);
            continue;
        }
    }

    private static boolean isDefinedUnicode(char[] charArray) {
        for (Character item : charArray) {
            if (Character.isDefined(item)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDigit(char[] charArray) {
        for (Character item : charArray) {
            if (Character.isDigit(item)) {
                return true;
            }
        }
        return false;
    }

    private static boolean numberOfWords(char[] charArray, String[] arrayName) {
        for (Character item : charArray) {
            if (Character.isSpaceChar(item)) {
                if (arrayName.length != 3) {
                    return true;
                }
            }
        }
        return false;
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
















