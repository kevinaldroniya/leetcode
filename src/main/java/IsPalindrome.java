public class IsPalindrome {

    public static boolean solution7ms(int x) {
        String stringX = String.valueOf(x);
        StringBuilder reverseStringBuilder = new StringBuilder();
        for (int i = 0; i < stringX.length(); i++) {
            reverseStringBuilder.append(stringX.charAt(stringX.length()-1-i));
        }
        String reverseString = reverseStringBuilder.toString();
        return stringX.equals(reverseString);
    }

    public static boolean solutionV2(int x) {
        if (x < 0) {
            return false;
        }
        int originalNumber = x;
        int reverseNumber = 0;

        while (x != 0) {
            int lastDigit = x % 10;
            reverseNumber = reverseNumber * 10 + lastDigit;
            x /= 10;
        }

        return originalNumber == reverseNumber;
    }

    public static boolean solutionV3(String x) {
        String reverseX = new StringBuilder(x).reverse().toString();
        return x.equals(reverseX);
    }

    public static boolean solutionV4(String x) {
        int left = 0;
        int right = x.length()-1;

        while (left < right) {
            if (x.charAt(left) != x.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
