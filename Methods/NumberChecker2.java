public class NumberChecker2 {
    public static void main(String[] args) {
        int num = 21;

        System.out.println("Digits count: " + countDigits(num));
        int[] digits = storeDigits(num);
        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println("\nSum of Digits: " + sumDigits(digits));
        System.out.println("Sum of Squares: " + sumSquares(digits));
        System.out.println("Is Harshad? " + isHarshad(num, sumDigits(digits)));
        System.out.println("Digit Frequency:");
        int[][] freq = digitFrequency(digits);
        for (int[] row : freq) {
            if (row[1] > 0) System.out.println("Digit " + row[0] + " -> " + row[1]);
        }
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

    static int sumDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d;
        return sum;
    }

    static int sumSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += Math.pow(d, 2);
        return sum;
    }

    static boolean isHarshad(int num, int sum) {
        return num % sum == 0;
    }

    static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int d : digits) freq[d][1]++;
        return freq;
    }
}
