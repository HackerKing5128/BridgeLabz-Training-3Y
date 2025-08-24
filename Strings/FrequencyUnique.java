import java.util.Scanner;

public class FrequencyUnique {
    // Method to get unique characters
    public static char[] uniqueCharacters(String text) {
        int len = text.length();
        char[] unique = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[index++] = c;
            }
        }

        // Trim to actual unique size
        char[] result = new char[index];
        for (int i = 0; i < index; i++) result[i] = unique[i];
        return result;
    }

    // Method to calculate frequency using ASCII array
    public static String[][] frequency(String text) {
        int[] freq = new int[256]; // ASCII range
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] unique = uniqueCharacters(text);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
        }
        return result;
    }

    // Display method
    public static void display(String[][] result) {
        System.out.println("Character | Frequency");
        System.out.println("---------------------");
        for (String[] row : result) {
            System.out.println("    " + row[0] + "     |     " + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] result = frequency(text);
        display(result);

    }
}
