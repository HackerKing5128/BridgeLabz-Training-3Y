// Program to convert distance in Kilometers to distance in miles
// Miles = Kilometer * 0.621371

import java.util.Scanner;

class KiloConvert {
    public static double kiloToMiles(double kilometers) {
        return kilometers * 0.621371;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the distance in kilometers: ");
        double kilometers = sc.nextDouble();

        System.out.println("Distance in Miles: " + kiloToMiles(kilometers));

    }
}