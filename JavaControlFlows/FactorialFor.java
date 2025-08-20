import java.util.Scanner;

public class FactorialFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        int fact = 1;
        if (n >= 0) {
            for (int i = 1; i <= n; i++)
                fact *= i;

            System.out.println("Factorial = " + fact);
        } else {
            System.out.println("Not a natural number");
        }
    }
}

