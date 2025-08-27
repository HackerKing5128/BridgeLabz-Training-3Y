import java.util.*;

class SentenceFormatter {
    public static String formatSentence(String paragraph) {
        // check if sentence is empty/null or not
        if (paragraph.isEmpty() || paragraph == null) {
            return "";
        }

        // trim extra spaces & replace multiple spaces with single space
        paragraph = paragraph.trim().replaceAll("\\s+", " ");

        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (first && Character.isLetter(c)) {
                // capitalize first letter
                result.append(Character.toUpperCase(c));
                first = false;
            } else {
                result.append(c);
            }

            // single space after punctuations ( . | ? | ! )
            if (c == '.' || c == '!' || c == '?') {
                first = true;

                // ensure single space
                if (i + 1 < paragraph.length() && paragraph.charAt(i + 1) != ' ') {
                    result.append(' ');
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String paragraph = sc.nextLine();
        System.out.println(formatSentence(paragraph));
            }
}
