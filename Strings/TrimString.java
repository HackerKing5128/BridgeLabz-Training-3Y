import java.util.Scanner;

public class TrimString {

    public static int[] trimSpaces(String str) {
        int start = 0;
        int end = str.length() - 1;

        // Remove leading spaces
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        // Remove trailing spaces
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();

        // Step 1: Trim using custom method
        int[] indexes = trimSpaces(input);
        String trimmedCustom = customSubstring(input, indexes[0], indexes[1]);

        // Step 2: Trim using built-in trim()
        String trimmedBuiltIn = input.trim();

        // Step 3: Compare both results
        boolean areEqual = compareStrings(trimmedCustom, trimmedBuiltIn);

        // Display results
        System.out.println("Custom Trimmed String: '" + trimmedCustom + "'");
        System.out.println("Built-in Trimmed String: '" + trimmedBuiltIn + "'");
        System.out.println("Are both equal? " + areEqual);
    }
}
