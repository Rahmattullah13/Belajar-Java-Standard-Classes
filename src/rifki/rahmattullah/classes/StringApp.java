package rifki.rahmattullah.classes;

public class StringApp {
    public static void main(String[] args) {

        String name = "Rifki Rahmattullah";
        String nameLowercase = name.toLowerCase();
        String nameUppercase = name.toUpperCase();

        System.out.println(name);
        System.out.println(nameLowercase);
        System.out.println(nameUppercase);
        System.out.println(name.length());
        System.out.println(name.startsWith("Rifki"));
        System.out.println(name.endsWith("Rahmattullah"));

        String[] names = name.split(" ");
        for (var value : names) {
            System.out.println(value);
        }
    }
}
