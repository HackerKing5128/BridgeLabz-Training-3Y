import java.util.Scanner;

public class SumNaturalNumbersRecursion {
    public static int recursiveSum(int n) {
        if (n == 0)
            return 0;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a natural number (positive integer).");
            return;
        }

        int sumRec = recursiveSum(n);
        int sumFormula = formulaSum(n);

        System.out.println("Sum using recursion: " + sumRec);
        System.out.println("Sum using formula n*(n+1)/2: " + sumFormula);

        if (sumRec == sumFormula) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("Results do not match.");
        }
    }
}
