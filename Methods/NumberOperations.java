import java.util.Arrays;

public class NumberOperations {
    // a) Count number of digits
    public static int countDigits(int num) {
        return String.valueOf(Math.abs(num)).length();
    }

    // b) Reverse digits into array
    public static int[] reverseDigits(int num) {
        String s = String.valueOf(num);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(s.length() - 1 - i) - '0';
        }
        return arr;
    }

    // c) Compare two arrays
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    // d) Palindrome check
    public static boolean isPalindrome(int num) {
        String s = String.valueOf(num);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    // e) Duck number check
    public static boolean isDuckNumber(int num) {
        String s = String.valueOf(num);
        return s.indexOf('0') > 0; // zero not allowed at first place
    }

    public static void main(String[] args) {
        int num = 12345;
        System.out.println("a) Count digits: " + countDigits(num));
        System.out.println("b) Reverse digits: " + Arrays.toString(reverseDigits(num)));
        System.out.println("c) Compare arrays: " + compareArrays(new int[]{1,2,3}, new int[]{1,2,3}));
        System.out.println("d) Palindrome check (121): " + isPalindrome(121));
        System.out.println("e) Duck number check (1023): " + isDuckNumber(1023));
    }
}
