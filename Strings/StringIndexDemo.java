public class StringIndexDemo {
    public static void generateSIOOBE(String text) {
        System.out.println(text.charAt(text.length())); // beyond index
    }

    public static void handleSIOOBE(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled StringIndexOutOfBoundsException!");
        }
    }

    public static void main(String[] args) {
        String str = "hello";
        // generateSIOOBE(str);
        handleSIOOBE(str);
    }
}
