// Program to calculate perimeter of rectangle

import java.util.Scanner;

class PerimeterOfRectangle {
    public static double perimeter(double length, double width) {
        return  2 * (length + width);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the rectangle: ");
        double length = sc.nextDouble();
        System.out.print("Enter the width of the rectangle: ");
        double width = sc.nextDouble();

        System.out.print("Perimeter of rectangle is " + perimeter(length, width));

    }
}