import java.util.Scanner;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int fact = 1, i = 1;

        if (n >= 0) {
            while (i <= n)
                fact *= i++;

            System.out.println("Factorial = " + fact);
        } else {
            System.out.println("Not a natural number");
        }
    }
}
