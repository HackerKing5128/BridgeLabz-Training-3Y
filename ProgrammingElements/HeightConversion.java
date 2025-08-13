import java.util.Scanner;

class HeightConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the height in centimeters: ");
        double cmHeight = sc.nextDouble();

        double inchHeight = cmHeight * 0.3937008;   // 1 cm = 0.3937008 inches  | 1 inch = 2.54 cm
        double feetHeight = inchHeight * 12;        // 1 foot = 12 inches

        System.out.println("Your Height in cm is " + cmHeight + " while in feet is " + (float)feetHeight + " and inches is " + (float)inchHeight);

    }
}
