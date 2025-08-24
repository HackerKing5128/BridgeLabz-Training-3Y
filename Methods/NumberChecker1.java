public class NumberChecker1 {
    public static void main(String[] args) {
        int num = 153;

        System.out.println("Digits count: " + countDigits(num));
        int[] digits = storeDigits(num);
        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println("\nIs Duck Number? " + isDuckNumber(digits));
        System.out.println("Is Armstrong? " + isArmstrong(digits));
        System.out.println("Largest and 2nd Largest: " + largestTwo(digits));
        System.out.println("Smallest and 2nd Smallest: " + smallestTwo(digits));
    }

    static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    static int[] storeDigits(int n) {
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i) - '0';
        return arr;
    }

    static boolean isDuckNumber(int[] digits) {
        for (int d : digits) if (d == 0) return true;
        return false;
    }

    static boolean isArmstrong(int[] digits) {
        int n = digits.length, sum = 0;
        for (int d : digits) sum += Math.pow(d, n);
        int num = 0;
        for (int d : digits) num = num * 10 + d;
        return sum == num;
    }

    static String largestTwo(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n > first) {
                second = first;
                first = n;
            } else if (n > second && n != first) second = n;
        }
        return first + ", " + second;
    }

    static String smallestTwo(int[] arr) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int n : arr) {
            if (n < first) {
                second = first;
                first = n;
            } else if (n < second && n != first) second = n;
        }
        return first + ", " + second;
    }
}
