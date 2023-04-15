import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression: ");

        String expression = scanner.nextLine();
        expression = expression.replace("\"", "");
        String[] array = new String[0];
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

        if (array[0].length() > 10 || array[1].length() > 10) {
            try {
                throw new Exception("String must contain 1 to 10 symbols");
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
        //char c1 = array[0].charAt(0);
        //char c2 = array[0].charAt(array[0].length() - 1);


    }

    static void printInQuotes(String text) {
        System.out.println("\"" + text + "\"");
    }

}


