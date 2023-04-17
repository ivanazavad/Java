import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String str = "\"hello\"";
        char c1 = str.charAt(0);
        char c2 = str.charAt(str.length() - 1);

        if (c1 != '\"' && c2 != '\"') {
            System.out.println("Error");
        } else {
            System.out.println(str.charAt(0));
            System.out.println(str.charAt(str.length() - 1));
        }


    }

}


