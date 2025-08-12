// Program to calculate volume of Cylinder

import java.util.Scanner;
import java.lang.Math;

class VolumeOfCylinder {
    public static float volume(float radius, float height) {
        float volume = (float) Math.PI * (radius * radius) * height ;
        return volume;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the radius of the cylinder: ");
        float radius = sc.nextFloat();
        System.out.print("Enter the height of the cylinder: ");
        float height = sc.nextFloat();

        float volume = volume(radius, height);
        System.out.println("The volume of the cylinder is " + volume);
    }
}