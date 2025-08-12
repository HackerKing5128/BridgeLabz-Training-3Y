// Program to calculate area of Circle

import java.util.Scanner;
import java.lang.Math; // for PI

class AreaOfCircle {
    public static float area(float radius) {
        float area = (float) Math.PI * radius * radius;
        return area;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        float radius = sc.nextFloat();
        System.out.println("Area of the circle with radius " + radius + " is " + area(radius));
    }
}