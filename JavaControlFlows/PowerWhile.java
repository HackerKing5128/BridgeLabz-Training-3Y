import java.util.Scanner;

public class PowerWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.print("Enter power: ");
        int pow = sc.nextInt();

        int result = 1, counter = 0;
        if (num >= 0 && pow >= 0) {
            while (counter < pow) {
                result *= num;
                counter++;
            }
            System.out.println(num + "^" + pow + " = " + result);
        } else {
            System.out.println("Enter positive integers");
        }
    }
}
