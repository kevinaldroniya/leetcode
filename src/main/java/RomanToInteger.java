import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int solutionV1(String s) {
        int result = 0;
        if (s.isEmpty() || s.length() > 15) {
            return 0;
        }

        Map<Character, Integer> romanInteger = new HashMap<>();
        romanInteger.put('I', 1);
        romanInteger.put('V', 5);
        romanInteger.put('X', 10);
        romanInteger.put('L', 50);
        romanInteger.put('C', 100);
        romanInteger.put('D', 500);
        romanInteger.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            if (!romanInteger.containsKey(s.charAt(i))) {
                result = 0;
                return result;
            }

            result += romanInteger.get(s.charAt(i));

            if (i>0) {
                if ((s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i-1) == 'I') {
                    result-=2;
                } else if ((s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i-1) == 'X') {
                    result-=20;
                } else if ((s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i-1) == 'C') {
                    result-=200;
                }
            }
        }

        return result;
    }


    public static int solutionV2(String s) {
        int result = 0;
        if (s.isEmpty() || s.length() > 15) {
            return 0;
        }

        Map<Character, Integer> romanInteger = new HashMap<>();
        romanInteger.put('I', 1);
        romanInteger.put('V', 5);
        romanInteger.put('X', 10);
        romanInteger.put('L', 50);
        romanInteger.put('C', 100);
        romanInteger.put('D', 500);
        romanInteger.put('M', 1000);

        for (int i = s.length()-1; i >= 0; i--) {
            if (i != s.length()-1 && romanInteger.get(s.charAt(i+1)) > romanInteger.get(s.charAt(i))) {
                result -= romanInteger.get(s.charAt(i));
            } else {
                result += romanInteger.get(s.charAt(i));
            }
        }

        return result;
    }

    public static int solutionV3(String s) {
        int result = 0;
        int previousValue = 0;
        int currentValue = 0;
        if (s.isEmpty() || s.length() > 15) {
            return 0;
        }

        for (int i = s.length()-1; i >= 0; i--) {
            /*
            Pemakaian switch statement untuk mendapatkan nilai dari karakter Romawi itu adalah pilihan
            yang sangat cerdas, karena lebih clean dan bisa dibilang lebih cepat dibandingkan HashMap
            untuk jumlah case yang sedikit seperti ini.
             */
            switch (s.charAt(i)) {
                case 'I':
                    currentValue = 1;
                    break;
                case 'V':
                    currentValue = 5;
                    break;
                case 'X':
                    currentValue = 10;
                    break;
                case 'L':
                    currentValue = 50;
                    break;
                case 'C':
                    currentValue = 100;
                    break;
                case 'D':
                    currentValue = 500;
                    break;
                case 'M':
                    currentValue =1000;
                    break;
                default:
                    return 0;
            }

            if (i != s.length()-1 && previousValue > currentValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            previousValue = currentValue;
        }

        return result;
    }
}
