import java.util.*;

public class CarNumbers {
    private static final String[] LETTER_VARIANTS = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    private static final String[] REGION_VARIANTS = {"102", "113", "116", "121", "123", "124", "125", "134", "136", "138", "142", "150", "152", "154", "159", "161", "163", "164", "169", "173", "174", "177", "178", "186", "190", "196", "197", "199", "725", "750", "777", "790", "797"};
    private static final String REGEX_CAR_NUMBER = "^[АВЕКМНОРСТУХ]{1}\\d{3}[АВЕКМНОРСТУХ]{2}([0-9]{2})?((102|113|116|121|123|124|125|134|136|138|142|150|152|154|159|161|163|164|169|173|174|177|178|186|190|196|197|199|725|750|777|790|797){1})?$";
    private static ArrayList<String> carNumbers = new ArrayList<>();
    private static HashSet<String> carNumbersHash = new HashSet<>();
    private static TreeSet<String> carnumbersTree = new TreeSet<>();

    public static void main(String[] args) {

        createNumbers();
        carNumbersHash.addAll(carNumbers);
        carnumbersTree.addAll(carNumbers);
        System.out.println(carNumbers.size());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите искомый номер авто");
            String inputCarNumber = scanner.nextLine();
            if (inputCarNumber.matches(REGEX_CAR_NUMBER)) {
                getLineSearch(inputCarNumber);
                getBinarySearch(inputCarNumber);
                getHashSetSearch(inputCarNumber);
                getTreeSetSearch(inputCarNumber);
            } else {
                System.out.println("Ошибка!");
            }
        }
    }

    private static void getTreeSetSearch(String inputCarNumber) {
        long start = System.currentTimeMillis();
        boolean haveInputNumberInArray = carnumbersTree.contains(inputCarNumber);
        long duration = System.currentTimeMillis() - start;
        if (haveInputNumberInArray) {
            System.out.printf("Список содержит введенный номер. Метод поиска по списку типа Treeset занял %s ms\n", duration);
        } else {
            System.out.printf("Введенный номер не входит в список блатных номеров. Метод поиска по списку типа Treeset занял %s ms\n", duration);
        }
    }

    private static void getHashSetSearch(String inputCarNumber) {
        long start = System.currentTimeMillis();
        boolean haveInputNumberInArray = carNumbersHash.contains(inputCarNumber);
        long duration = System.currentTimeMillis() - start;
        if (haveInputNumberInArray) {
            System.out.printf("Список содержит введенный номер. Метод поиска по списку типа Hashset занял %s ms\n", duration);
        } else {
            System.out.printf("Введенный номер не входит в список блатных номеров. Метод поиска по списку типа Hashset занял %s ms\n", duration);
        }
    }

    private static void getBinarySearch(String inputCarNumber) {
        Collections.sort(carNumbers);
        long start = System.currentTimeMillis();
        int haveInputNumberInArray = Collections.binarySearch(carNumbers, inputCarNumber);
        long duration = System.currentTimeMillis() - start;
        if (haveInputNumberInArray >= 0) {
            System.out.printf("Список содержит введенный номер. Строка номер: %2$s Метод бинарного поиска занял %1$s ms\n", duration, haveInputNumberInArray);
        } else {
            System.out.printf("Введенный номер не входит в список блатных номеров. Метод бинарного поиска занял %s ms\n", duration);
        }
    }

    private static void getLineSearch(String inputCarNumber) {
        long start = System.currentTimeMillis();
        boolean haveInputNumberInArray = carNumbers.contains(inputCarNumber);
        long duration = System.currentTimeMillis() - start;
        if (haveInputNumberInArray) {
            System.out.printf("Список содержит введенный номер. Метод прямого поиска занял %s ms\n", duration);
        } else {
            System.out.printf("Введенный номер не входит в список блатных номеров. Метод прямого поиска занял %s ms\n", duration);
        }
    }

    private static void createNumbers() {
        for (int a = 0; a < LETTER_VARIANTS.length; a++) {
            createLetters(a);
        }
    }

    private static void createLetters(int a) {
        for (int b = 0; b < 1000; b++) {
            createRegions(a, b);
        }
    }

    private static void createRegions(int a, int b) {
        for (int i = 1; i < 100; i++) {
            if (b < 10 & i < 10) {
                carNumbers.add(LETTER_VARIANTS[a] + "00" + b + LETTER_VARIANTS[a] + LETTER_VARIANTS[a] + "0" + i);
                continue;
            }
            if (b < 100 & i < 10) {
                carNumbers.add(LETTER_VARIANTS[a] + "0" + b + LETTER_VARIANTS[a] + LETTER_VARIANTS[a] + "0" + i);
                continue;
            }
            if (b < 10) {
                carNumbers.add(LETTER_VARIANTS[a] + "00" + b + LETTER_VARIANTS[a] + LETTER_VARIANTS[a] + i);
                continue;
            }
            if (b < 100) {
                carNumbers.add(LETTER_VARIANTS[a] + "0" + b + LETTER_VARIANTS[a] + LETTER_VARIANTS[a] + i);
                continue;
            }
            if (i < 10) {
                carNumbers.add(LETTER_VARIANTS[a] + b + LETTER_VARIANTS[a] + LETTER_VARIANTS[a] + "0" + i);
            } else {
                carNumbers.add(LETTER_VARIANTS[a] + b + LETTER_VARIANTS[a] + LETTER_VARIANTS[a] + i);
            }
        }
        for (String regionVariant : REGION_VARIANTS) {
            if (b < 10) {
                carNumbers.add(LETTER_VARIANTS[a] + "00" + b + LETTER_VARIANTS[a] + LETTER_VARIANTS[a] + regionVariant);
                continue;
            }
            if (b < 100) {
                carNumbers.add(LETTER_VARIANTS[a] + "0" + b + LETTER_VARIANTS[a] + LETTER_VARIANTS[a] + regionVariant);
                continue;
            }
            carNumbers.add(LETTER_VARIANTS[a] + b + LETTER_VARIANTS[a] + LETTER_VARIANTS[a] + regionVariant);
        }
    }
}

