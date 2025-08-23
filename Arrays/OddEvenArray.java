import java.util.Scanner;

public class OddEvenArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int num = sc.nextInt();

        if (num <= 0) {
            System.out.println("Error: not a natural number.");
            return;
        }

        int[] evens = new int[num/2+1];
        int[] odds = new int[num/2+1];
        int eIndex = 0, oIndex = 0;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0)
                evens[eIndex++] = i;
            else
                odds[oIndex++] = i;
        }

        System.out.print("Odd numbers: ");
        for (int i = 0; i < oIndex; i++)
            System.out.print(odds[i] + " ");
        System.out.println();

        System.out.print("Even numbers: ");
        for (int i = 0; i < eIndex; i++)
            System.out.print(evens[i] + " ");
    }
}
