public class SpecialNumbers {
    // a) Prime number
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // b) Neon number
    public static boolean isNeon(int n) {
        int sq = n * n, sum = 0;
        while (sq > 0) {
            sum += sq % 10;
            sq /= 10;
        }
        return sum == n;
    }

    // c) Spy number
    public static boolean isSpy(int n) {
        int sum = 0, prod = 1;
        while (n > 0) {
            int d = n % 10;
            sum += d;
            prod *= d;
            n /= 10;
        }
        return sum == prod;
    }

    // d) Automorphic number
    public static boolean isAutomorphic(int n) {
        int sq = n * n;
        return String.valueOf(sq).endsWith(String.valueOf(n));
    }

    // e) Buzz number
    public static boolean isBuzz(int n) {
        return (n % 7 == 0 || n % 10 == 7);
    }

    public static void main(String[] args) {
        System.out.println("Prime (13): " + isPrime(13));
        System.out.println("Neon (9): " + isNeon(9));
        System.out.println("Spy (1124): " + isSpy(1124));
        System.out.println("Automorphic (25): " + isAutomorphic(25));
        System.out.println("Buzz (107): " + isBuzz(107));
    }
}
