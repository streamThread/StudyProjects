import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tooDo = new ArrayList<>();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите команду. Для отображения возможных комманд введите HELP");
            String command = scanner.nextLine();
            if (command.matches("^[A-Za-z]{3,}.*")) {

                if (command.matches("HELP")||command.matches("help")) {
                    help();
                    continue;
                }
                if (command.matches("LIST")) {
                    list(tooDo);
                    continue;
                }

                if (command.matches("ADD.*")) {
                    add(command, tooDo);
                    continue;
                }

                if (command.matches("EDIT.*")) {
                    edit(command, tooDo);
                    continue;

                }
                if (command.matches("DELETE.*")) {
                    delete(command, tooDo);
                    continue;
                }
            } else System.out.println("Введена неверная команда. Для вызова помощи введите HELP");
            list(tooDo);
        }
    }

    private static void list(ArrayList tooDo) {
        System.out.println("Список дел:");
        for (int i = 1; i <= tooDo.size(); i++) {
            System.out.println("\tДело №" + (i) + ": " + tooDo.get(i - 1));
        }
    }

    private static void add(String command, ArrayList tooDo) {
        while (true) {
            if (command.matches("ADD")) {
                System.out.println("Ошибка! Если хотите добавить дело в список, то следуйте инструкции по запросу HELP");
                list(tooDo);
                break;
            }
            if (command.matches("ADD \\d+")) {
                System.out.println("Ошибка! Введите название дела для добавления его в список");
                list(tooDo);
                break;
            }
            if (command.charAt(3) == 32) { //проверка на пробел после команды
                String[] commandlines = command.split("\\s+");
                if (commandlines[1].matches("[-]?\\d+")) {
                    int stringIndex = (Integer.parseInt(commandlines[1]) - 1);
                    if (stringIndex <= tooDo.size() && stringIndex >= 0) {
                        tooDo.add(stringIndex, command.replaceAll("ADD\\s+\\d+\\s+", ""));
                        list(tooDo);
                        break;
                    } else {
                        System.out.println("Невозможно добавить новое дело! Добавляйте дела с номерами в промежутке от 1 до " + (tooDo.size() + 1));
                        list(tooDo);
                        break;
                    }
                } else {
                    tooDo.add(0, command.replaceAll("ADD\\s+", ""));
                    list(tooDo);
                    break;
                }
            } else {
                System.out.println("Ошибка! Разделяйте команды и текст пробелом");
                break;
            }
        }
    }

    private static void edit(String command, ArrayList tooDo) {
        while (true) {
            if (command.matches("\\s*EDIT\\s*")) {
                System.out.println("Ошибка! Если хотите изменить какое то дело, то укажите его номер в списке");
                list(tooDo);
                break;
            }
            if (command.matches("EDIT \\d+")) {
                System.out.println("Ошибка! Введите название дела для его изменения в списке");
                list(tooDo);
                break;
            }
            if (command.charAt(4) == 32) { //проверка на пробел после команды
                String[] commandlines = command.split("\\s+");
                if (commandlines[1].matches("[-]?\\d+")) {
                    int stringIndex = (Integer.parseInt(commandlines[1]) - 1);
                    if (stringIndex < tooDo.size() && stringIndex >= 0) {
                        tooDo.set(stringIndex, command.replaceAll("EDIT\\s+\\d+\\s+", ""));
                        list(tooDo);
                        break;
                    } else {
                        System.out.println("Невозможно изменить! Изменяйте дела с номерами в промежутке от 1 до " + (tooDo.size()));
                        list(tooDo);
                        break;
                    }
                } else {
                    System.out.println("Ошибка! Укажите номер строки для редактирования.");
                    list(tooDo);
                    break;
                }
            } else {
                System.out.println("Ошибка! Разделяйте команды и текст пробелом");
                list(tooDo);
                break;
            }
        }
    }

    private static void delete(String command, ArrayList tooDo) {
        while (true) {
            if (command.matches("\\s*DELETE\\s*")) {
                System.out.println("Ошибка! Если хотите удалить какое то дело, то укажите его номер в списке");
                list(tooDo);
                break;
            }
            if (command.charAt(6) == 32) {
                String[] commandlines = command.split("\\s+");
                if (commandlines[1].matches("[-]?\\d+")) {
                    int stringNumber = (Integer.parseInt(commandlines[1]) - 1);
                    if (stringNumber < tooDo.size() && stringNumber >= 0) {
                        tooDo.remove(stringNumber);
                        list(tooDo);
                        break;
                    } else {
                        System.out.println("Невозможно удалить! Удаляйте дела с номерами в промежутке от 1 до " + (tooDo.size()));
                        list(tooDo);
                        break;
                    }
                } else {
                    System.out.println("Ошибка! Укажите номер строки для удаления");
                }
            } else {
                System.out.println("Ошибка! Разделяйте команды и текст пробелом");
                break;
            }
        }
    }

    private static void help() {
        System.out.println("Список примеров возможных комманд:\n" +
                "LIST - выводит список дел;\n" +
                "ADD Какое-то дело - добавляет какое то дело в начало списка;\n" +
                "ADD 4 Какое-то дело - добавляет какое то дело на 4 позицию списка;\n" +
                "EDIT 3 Новое название дела - изменяет название какого то дела на 3 позиции списка;\n" +
                "DELETE 7 - удаляет 7 позицию списка дел.");
    }
}


