package rifki.rahmattullah.classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexApp {
    public static void main(String[] args) {

        String text = "Nama saya Rifki Rahmattullah saya ingin menjadi seorang Software Engineer";

        Pattern pattern = Pattern.compile("[a-zA-Z]*[a][a-zA-Z]*");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            String result = matcher.group();
            System.out.println(result);
        }
    }
}
