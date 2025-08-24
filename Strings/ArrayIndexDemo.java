public class ArrayIndexDemo {
    public static void generateAIOOBE() {
        String[] names = {"A", "B", "C"};
        System.out.println(names[5]); // invalid index
    }

    public static void handleAIOOBE() {
        try {
            String[] names = {"A", "B", "C"};
            System.out.println(names[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled ArrayIndexOutOfBoundsException!");
        }
    }

    public static void main(String[] args) {
        //generateAIOOBE();
        handleAIOOBE();
    }
}
