public class NullPointerDemo {
    public static void generateNPE() {
        String text = null;
        System.out.println(text.length()); //throws NPE
    }

    public static void handleNPE() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Handled NullPointerException!");
        }
    }

    public static void main(String[] args) {
        //generateNPE();
        handleNPE();
    }
}
