public class SeriesPrograms {
    // a) Fibonacci series
    public static void fibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    // b) Factorial
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    // c) Sum of digits
    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // d) Product of digits
    public static int productOfDigits(int n) {
        int prod = 1;
        while (n > 0) {
            prod *= n % 10;
            n /= 10;
        }
        return prod;
    }

    // e) Reverse digits
    public static int reverseNumber(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        fibonacci(10);
        System.out.println("Factorial (5): " + factorial(5));
        System.out.println("Sum of digits (1234): " + sumOfDigits(1234));
        System.out.println("Product of digits (1234): " + productOfDigits(1234));
        System.out.println("Reverse (1234): " + reverseNumber(1234));
    }
}
