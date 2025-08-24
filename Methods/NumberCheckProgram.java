import java.util.Scanner;

public class NumberCheckProgram {

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // Method to compare two numbers
    // Returns 1 if number1 > number2, 0 if equal, -1 if number1 < number2
    public static int compare(int number1, int number2) {
        if (number1 > number2) return 1;
        else if (number1 == number2) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        // Input 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        // Check each number
        System.out.println("\nChecking numbers:");
        for (int num : numbers) {
            if (isPositive(num)) {
                if (isEven(num))
                    System.out.println(num + " is Positive and Even");
                else
                    System.out.println(num + " is Positive and Odd");
            } else {
                System.out.println(num + " is Negative");
            }
        }

        // Compare first and last elements
        int result = compare(numbers[0], numbers[numbers.length - 1]);
        System.out.print("\nComparison of first and last elements: ");
        if (result == 1)
            System.out.println(numbers[0] + " is greater than " + numbers[numbers.length - 1]);
        else if (result == 0)
            System.out.println(numbers[0] + " is equal to " + numbers[numbers.length - 1]);
        else
            System.out.println(numbers[0] + " is less than " + numbers[numbers.length - 1]);
    }
}
