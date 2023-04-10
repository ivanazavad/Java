import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression: ");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }

    public static String parse(String expression) throws Exception {
        int number1;
        int number2;
        String action;
        String result;
        boolean isRoman;
        String[] numbers = expression.split("[+\\-*/]");
        if (numbers.length != 2) throw new Exception("Should be two numbers");
        action = determineAction(expression);
        //if (action == null) throw new Exception("This action not found");
        if (Converter.isRoman(numbers[0]) && Converter.isRoman(numbers[1])) {
            number1 = Converter.convertArab(numbers[0]);
            number2 = Converter.convertArab(numbers[1]);
            isRoman = true;
        } else if (!Converter.isRoman(numbers[0]) && !Converter.isRoman(numbers[1])) {
            number1 = Integer.parseInt(numbers[0]);
            number2 = Integer.parseInt(numbers[1]);
            isRoman = false;
        } else {
            throw new Exception("Numbers must be in the same form");
        }
        if (number1 > 10 || number2 > 10) {
            throw new Exception("Numbers must be between 1 and 10");
        }
        int arabian = calc(number1, number2, action);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Roman number mast be greater then null");
            }
            result = Converter.convertRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }
    static String determineAction(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else return "/";
    }
    static int calc(int a, int b, String action) {
        return switch (action) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}

