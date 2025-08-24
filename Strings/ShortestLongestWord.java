import java.util.Scanner;

public class ShortestLongestWord {

    // Method to calculate string length without using length()
    static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            //exit loop
        }
        return count;
    }

    // Method to split text into words without using split()
    static String[] splitWords(String text) {
        int len = getLength(text);
        String[] words = new String[len]; // temp array
        int wordCount = 0;
        String temp = "";

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                temp += ch;
            } else {
                if (!temp.equals("")) {
                    words[wordCount++] = temp;
                    temp = "";
                }
            }
        }
        // add last word
        if (!temp.equals("")) {
            words[wordCount++] = temp;
        }

        // shrink array to actual size
        String[] result = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            result[i] = words[i];
        }
        return result;
    }

    // Method to return 2D array of word and its length
    static String[][] wordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    // Method to find shortest and longest word
    static int[] findShortestLongest(String[][] wordLen) {
        int minIndex = 0, maxIndex = 0;
        int min = Integer.parseInt(wordLen[0][1]);
        int max = Integer.parseInt(wordLen[0][1]);

        for (int i = 1; i < wordLen.length; i++) {
            int length = Integer.parseInt(wordLen[i][1]);
            if (length < min) {
                min = length;
                minIndex = i;
            }
            if (length > max) {
                max = length;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Step 1: split words
        String[] words = splitWords(text);

        // Step 2: words with length
        String[][] wordLen = wordsWithLength(words);

        // Step 3: find shortest and longest
        int[] result = findShortestLongest(wordLen);

        System.out.println("Shortest word: " + wordLen[result[0]][0] +
                " (length: " + wordLen[result[0]][1] + ")");
        System.out.println("Longest word: " + wordLen[result[1]][0] +
                " (length: " + wordLen[result[1]][1] + ")");
    }
}
