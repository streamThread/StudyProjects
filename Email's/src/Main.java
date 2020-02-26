import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static HashSet<String> email = new HashSet<>();
    private static final String REGEX_ADD = "ADD\\s+(?<deal>.+)";
    private static final String REGEX_LIST = "^LIST$";
    private static final String REGEX_EMAIL = ".+@.+\\..+"; //прочитал эту статью https://habr.com/ru/post/175375/. С автором согласен.
    private static final String REGEX_HELP = "(HELP)|(Help)|(help)";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите комманду: (для получения помощи введите 'HELP')");
            String inputData = scanner.nextLine();

            if (inputData.matches(REGEX_ADD)) {
                add(inputData);
                continue;
            }
            if (inputData.matches(REGEX_LIST)) {
                list();
                continue;
            }
            if (inputData.matches(REGEX_HELP)) {
                help();
                continue;
            }
            System.out.println("Ошибка! Комманда не распознана");
        }
    }

    private static void add(String inputData) {
        Matcher matcher = Pattern.compile(REGEX_ADD).matcher(inputData);
        matcher.find();
        if (matcher.group("deal").matches(REGEX_EMAIL)) {
            email.add(matcher.group("deal"));
        } else {
            System.out.println("Ошибка! Неверный формат e-mail адреса");
        }
        list();
    }

    private static void list() {
        for (String item : email) {
            System.out.println(item);
        }
    }

    private static void help() {
        System.out.println("ADD e-mail - добавление e-mail в список\n" +
                "LIST - вывод списка e-mail\n" +
                "HELP - список комманд");
    }
}













