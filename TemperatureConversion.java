// Program to convert Temperature in Celsius to Temperature in Fahrenheit

import java.util.Scanner;

class TemperatureConversion {
    public static float celsiusToFahrenheit(float celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the temperature in Celsius: ");
        float celsius = sc.nextFloat();

        System.out.print("Fahrenheit temperature: " + celsiusToFahrenheit(celsius));

    }
}