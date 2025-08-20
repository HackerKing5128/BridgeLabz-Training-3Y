import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        System.out.println("Start Entering Numbers: ");
        Scanner sc = new Scanner(System.in);
        double total = 0, val;
        while ((val = sc.nextDouble()) != 0) {
            total += val;
        }
        System.out.println("Total = " + total);
    }
}
