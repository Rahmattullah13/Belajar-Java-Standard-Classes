package rifki.rahmattullah.classes;

import java.util.StringJoiner;

public class StringJoinerApp {
    public static void main(String[] args) {

        StringJoiner joiner = new StringJoiner(",", "[", "]");

        joiner.add("Rifki");
        joiner.add("Rahmattullah");

        String value = joiner.toString();
        System.out.println(value);
    }
}
