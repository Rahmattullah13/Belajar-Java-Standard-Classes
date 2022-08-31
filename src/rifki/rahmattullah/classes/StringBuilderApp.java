package rifki.rahmattullah.classes;

public class StringBuilderApp {
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        // append digunakan untuk menambah kan string.
        builder.append("Rifki");
        builder.append(" ");
        builder.append("Rahmattullah");

        // Jika kita ingin mengaksesnya
        String name = builder.toString();
        System.out.println(name);
    }
}
