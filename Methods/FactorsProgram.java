import java.util.Scanner;

public class FactorsProgram {
    public static int[] findFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) factors[index++] = i;
        }
        return factors;
    }

    public static int sumFactors(int[] arr) {
        int sum = 0;
        for (int f : arr) sum += f;
        return sum;
    }

    public static int sumSquareFactors(int[] arr) {
        int sum = 0;
        for (int f : arr) sum += Math.pow(f, 2);
        return sum;
    }

    public static long productFactors(int[] arr) {
        long product = 1;
        for (int f : arr) product *= f;
        return product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] factors = findFactors(num);
        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println();

        System.out.println("Sum of factors: " + sumFactors(factors));
        System.out.println("Sum of squares: " + sumSquareFactors(factors));
        System.out.println("Product of factors: " + productFactors(factors));
    }
}
