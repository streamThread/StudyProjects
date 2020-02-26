import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        while (true) {
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EE", Locale.ENGLISH);
            DateFormat inputDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            System.out.println("Введите дату своего рождения в формате dd.mm.yyyy. Пример: 23.12.1987");
            Scanner scanner = new Scanner(System.in);
            String date = scanner.nextLine();

            if (date.matches("^([0-9]{2}\\.[0-9]{2}\\.[0-9]{4})$")) {


                String[] inputNumbers = date.split("\\.");

                if (!numbers(inputNumbers)) {
                    System.out.println("Ошибка! Вы ввели неверную дату");
                    continue;
                }

                Date birthDay = inputDateFormat.parse(date);
                Calendar birthDayCal = new GregorianCalendar();
                birthDayCal.setTimeInMillis(birthDay.getTime());
                Calendar toDayCal = Calendar.getInstance();

                for (int i = 0; birthDayCal.before(toDayCal); i++) {
                    System.out.println(i + " - " + dateFormat.format((birthDayCal.getTime())));
                    birthDayCal.add(Calendar.YEAR, 1);
                }
            }
        }
    }

    private static boolean numbers(String[] inputNumbers) { //Проверка на правильность введенной даты
        int day = Integer.parseInt(inputNumbers[0]);
        int month = Integer.parseInt(inputNumbers[1]);
        int year = Integer.parseInt(inputNumbers[2]);

        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);

        if (year > 1900 && year <= nowYear) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day <= 31 && day >= 1) return true;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day <= 30 && day >= 1) return true;
            } else if (month == 2 && year % 4 != 0) {
                if (day >= 1 && day <= 28) return true;
            } else if (day >= 1 && day <= 29) return true;
        }
        return false;
    }
}
