// Program to convert distance in Kilometers to distance in miles
// Miles = Kilometer * 0.621371
// 1 mile = 1.6 km

import java.util.Scanner;

class KiloConvert {
    public static double kiloToMiles(double kilometers) {
        return kilometers * 0.621371;
    }

    public static void main(String[] args) {
        double km;
        Scanner sc = new Scanner(System.in);
        km = sc.nextDouble();
        System.out.println("The total miles is " + kiloToMiles(km) +  " mile for the given " + km + " km");

    }
}
