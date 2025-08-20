import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        int greatestFactor = 1, counter = n - 1;

        while (counter >= 1) {
            if (n % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }
        System.out.println("Greatest Factor (besides itself): " + greatestFactor);
    }
}
