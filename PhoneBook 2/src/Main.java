import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    private static final String REGEX_PHONE_NUMBER = "^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){1,11}(\\s*)?$";
    private static final String REGEX_NAME = "^(.*)?$";
    private static TreeMap<String, String> phoneBook = new TreeMap<>();

    public static void main(String[] args) {


        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер телефона или имя контакта");
            String inputData = scanner.nextLine();

            if (inputData.equals("LIST")) {
                list(phoneBook);
                continue;
            }

            if (inputData.matches(REGEX_PHONE_NUMBER)) {
                if (!phoneBook.containsValue(inputData)) {
                    addNameByPhone(inputData);
                } else {
                    printPersonByName(inputData);
                }
                continue;
            }

            if (inputData.matches(REGEX_NAME)) {
                if (!phoneBook.containsKey(inputData)) {
                    addPhoneByName(inputData);
                } else {
                    printPersonByPhone(inputData);
                }
            }
        }
    }

    private static void printPersonByPhone(String phoneNumber) {
        Map.Entry phone = phoneBook.ceilingEntry(phoneNumber);
        System.out.println("Имя контакта: " + phone.getKey() + "\n" + "Номер телефона: " + phone.getValue());
    }

    private static void addPhoneByName(String name) {
        String newPhone = getInput(REGEX_PHONE_NUMBER, "Введите номер");
        if (!phoneBook.containsValue(newPhone)) {
            phoneBook.put(name, newPhone);
            System.out.println("Контакт сохранен");
        }
    }

    private static void printPersonByName(String phone) {
        for (String name : phoneBook.keySet()) {
            if (phoneBook.get(name).equals(phone)) {
                System.out.println("Имя контакта: " + name + "\n" + "Номер телефона: " + phoneBook.get(name));
                break;
            }
        }
    }

    private static void addNameByPhone(String phone) {
        String newName = getInput(REGEX_NAME, "Введите имя");
        if (!phoneBook.containsKey(newName)) {
            phoneBook.put(newName, phone);
            System.out.println("Контакт сохранен");
        }
    }

    private static String getInput(String regex, String title) {
        String input;
        do {
            System.out.println(title);
            input = new Scanner(System.in).nextLine();
        } while (!input.matches(regex));
        return input;
    }

    public static void list(Map<String, String> map) {
        for (String key : map.keySet())
            System.out.print(key + " номер телефона: " + map.get(key) + "\n");
    }
}














