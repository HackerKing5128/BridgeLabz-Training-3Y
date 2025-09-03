// PalindromeChecker class
class PalindromeChecker {
    // Attribute
    String text;

    // Constructor
    PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check palindrome
    boolean isPalindrome() {
        String str = text.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Method to display result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }
}

// Main class
public class Palindrome {
    public static void main(String[] args) {
        PalindromeChecker p1 = new PalindromeChecker("A man a plan a canal Panama");
        PalindromeChecker p2 = new PalindromeChecker("Hello");

        p1.displayResult();
        p2.displayResult();
    }
}
