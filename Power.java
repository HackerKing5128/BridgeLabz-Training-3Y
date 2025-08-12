// Program to calculate power, base raised to the exponent

import java.util.Scanner;

class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base: ");
        int base = sc.nextInt();
        System.out.print("Enter exponent: ");
        int exponent = sc.nextInt();

        System.out.println("Power : " + (int)Math.pow(base, exponent));

    }
}