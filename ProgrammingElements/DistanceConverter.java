import java.util.Scanner;

class DistanceConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        double feet = sc.nextDouble();

        // 1 yard = 3 feet
        double yards = feet / 3;
        // 1 mile = 1760 yards
        double miles = yards / 1760;

        System.out.println("The distance of " + feet + " feet is " + (float)yards + " yards and " + (float)miles + " miles.");
    }
}
