import java.util.Scanner;

public class VowelConstFinder {

    // Method to check if a char is a vowel/consonant/not a letter
    public static String checkCharType(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char)(c + 32); // convert to lowercase using ASCII
        }

        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to build 2D array with characters and their types
    public static String[][] findVowelsAndConsonants(String str) {
        String[][] result = new String[str.length()][2];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }
        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayResult(String[][] arr) {
        System.out.println("\nCharacter\tType");
        System.out.println("------------------------");
        for (String[] row : arr) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] result = findVowelsAndConsonants(input);
        displayResult(result);
    }
}
