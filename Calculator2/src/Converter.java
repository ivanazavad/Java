import java.util.InputMismatchException;

public class Converter {
    static String[] romanNumbers = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static boolean isRoman(String value) {
        for (String romanNumber : romanNumbers) {
            if (value.equals(romanNumber)) {
                return true;
            }
        }
        return false;
    }
    static String convertRoman(int numArabian){
        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
        "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
        "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI",
        "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI",
        "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII",
            "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII",
            "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        //final String s = roman[numArabian];
        return roman[numArabian];
    }
    static int convertArab(String numRoman) {
        try {
            switch (numRoman){
                case "I" -> {return 1;}
                case "II" -> {return 2;}
                case "III" -> {return 3;}
                case "IV" -> {return 4;}
                case "V" -> {return 5;}
                case "VI" -> {return 6;}
                case "VII" -> {return 7;}
                case "VIII" -> {return 8;}
                case "IX" -> {return 9;}
                case "X" -> {return 10;}
            }
        } catch (InputMismatchException e){
            throw new InputMismatchException();
        } return -1;
    }

}
