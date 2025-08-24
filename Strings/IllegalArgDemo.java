public class IllegalArgDemo {
    public static void generateIAE(String text) {
        System.out.println(text.substring(5, 2)); // start > end
    }

    public static void handleIAE(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Handled IllegalArgumentException!");
        }
    }

    public static void main(String[] args) {
        String str = "abcdef";
        //generateIAE(str);
        handleIAE(str);
    }
}
