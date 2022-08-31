package rifki.rahmattullah.classes;

import java.util.StringTokenizer;

public class StringTokenizerApp {
    public static void main(String[] args) {

        String value = "I love You";

        // Pastikan ada delimiter nya
        StringTokenizer tokenizer = new StringTokenizer(" ");

        while (tokenizer.hasMoreTokens()){
            String result = tokenizer.nextToken();
            System.out.println(result);
        }
    }
}
