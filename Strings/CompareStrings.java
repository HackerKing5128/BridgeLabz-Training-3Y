import java.util.Scanner;

public class CompareStrings {
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.next();
        System.out.print("Enter second string: ");
        String str2 = sc.next();

        boolean manual = compareUsingCharAt(str1, str2);
        boolean builtin = str1.equals(str2);

        System.out.println("Manual compare: " + manual);
        System.out.println("Built-in equals(): " + builtin);
    }
}
