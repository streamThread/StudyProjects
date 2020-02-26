public class Main {
    public static void main(String[] args) {
        double[] temperature = new double[30];
        double tempSum = 0;
        double avarageTemp;
        int healthyPatient = 0;
        double minHealthTemp = (float) 36.2;
        double maxHealthTemp = (float) 36.9;

        for (int i = 0; i < temperature.length; i++) {
            temperature[i] = (32.0 + (8.0 * Math.random()));
        }
        for (double patientTemp : temperature) {
            tempSum = tempSum + patientTemp;
        }
        for (double patientTemp : temperature) {
            if (patientTemp >= minHealthTemp && patientTemp <= maxHealthTemp) {
                healthyPatient += 1;
            }
        }
        avarageTemp = tempSum / temperature.length;

        System.out.printf("Cредняя температура по больнице: %.2fC\nЗдоровых  пациентов: %d\n",avarageTemp, healthyPatient);

        for (double item:temperature){
            System.out.printf("%.4fC, ",item);
        }
    }


}
