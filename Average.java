// Program to calculate average of  3 numbers

import java.util.Scanner;

class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter number 2: ");
        double num2 = sc.nextDouble();
        System.out.print("Enter number 3: ");
        double num3 = sc.nextDouble();

        double avg = (num1 + num2 + num3) / 3;

        System.out.println("Average: " + avg);

    }
}