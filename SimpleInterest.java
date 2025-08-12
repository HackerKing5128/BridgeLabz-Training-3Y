// Program to calculate Simple Interest

import java.util.Scanner;

class SimpleInterest {
    public static double simpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter principal : ");
        double principal = sc.nextDouble();
        System.out.print("Enter rate : ");
        double rate = sc.nextDouble();
        System.out.print("Enter time : ");
        double time = sc.nextDouble();

        double result = simpleInterest(principal, rate, time);
        System.out.println("Simple Interest: " + result);
    }
}