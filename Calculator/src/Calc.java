
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression: ");
        String expression = scanner.nextLine();

        Pattern p = Pattern.compile("\".{1,10}\"\s\\W\s\".{1,10}\"");
        Matcher m = p.matcher(expression);

        String[] array;
        char action;

        if (expression.contains("+")) {
            array = expression.split(" \\+ ");
            action = '+';
        } else if (expression.contains("-")) {
            array = expression.split(" - ");
            action = '-';
        } else if (expression.contains("*")) {
            array = expression.split(" \\* ");
            action = '*';
        } else if (expression.contains("/")) {
            array = expression.split(" / ");
            action = '/';
        } else {
            try {
                throw new Exception("This action is not found");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        if (action == '*' || action == '/') {
            if (array[1].contains("\"")) try {
                throw new Exception("Should be an integer");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; array.length > i; i++) {
            array[i] = array[i].replace("\"", "");
        }

        if (action == '+') {
            if (!expression.matches("\".{1,10}\"\s\\W\s\".{1,10}\"")){
                throw new IllegalArgumentException("Invalid input format");
            }
            printInQuotes(array[0] + array[1]);
        } else if (action == '*') {
            int parse = Integer.parseInt(array[1]);
            String result = "";
            if (parse < 1 || parse > 10) try {
                throw new Exception("Number must be between 1 and 10");
            } catch (Exception e){
                throw new RuntimeException(e);
            }
            for (int i = 0; parse > i; i++) {
                result += array[0];
            }
            if (result.length()>40){
                printInQuotes(result.substring(0, 40) + "...");
            } else printInQuotes(result);
        } else if (action == '-') {
            if (!expression.matches("\".{1,10}\"\s\\W\s\".{1,10}\"")){
                throw new IllegalArgumentException("Invalid input format");
            }
            int index = array[0].indexOf(array[1]);
            if (index == -1) {
                printInQuotes(array[0]);
            } else {
                String result = array[0].substring(0, index);
                result += array[0].substring(index + array[1].length());
                printInQuotes(result);
            }
        } else {
            int newLen = array[0].length() / Integer.parseInt(array[1]);
            String result = array[0].substring(0, newLen);
            printInQuotes(result);
        }

    }

    static void printInQuotes(String text) {
        System.out.println("\"" + text + "\"");
    }

}


