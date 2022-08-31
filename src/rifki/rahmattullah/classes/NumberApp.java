package rifki.rahmattullah.classes;

public class NumberApp {
    public static void main(String[] args) {

        Integer intValue = 10;

        Long longValue = intValue.longValue();
        Double doubleValue = longValue.doubleValue();
        Short shortValue = doubleValue.shortValue();

        System.out.println(longValue);
        System.out.println(doubleValue);
        System.out.println(shortValue);

        // Konversi String ke Number
        String number = "10000";

        Integer numberInt = Integer.valueOf(number);
        System.out.println(numberInt);
    }
}
