public class NumberFormatDemo {
    public static void generateNFE(String text) {
        int num = Integer.parseInt(text); //  not a number
        System.out.println(num);
    }

    public static void handleNFE(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Handled NumberFormatException!");
        }
    }

    public static void main(String[] args) {
        String text = "abc";
        // generateNFE(text);
        handleNFE(text);
    }
}
