import java.util.Scanner;

class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base of triangle (in inches): ");
        double base = sc.nextDouble();
        System.out.print("Enter height of triangle (in inches): ");
        double height = sc.nextDouble();

        double areaInches = 0.5 * base * height;

        double areaCm = areaInches * 6.4516;    // 1 inch = 2.54 cm => 1 sq inch = 6.4516 sq cm

        System.out.println("Area of triangle with base " + base + " and height " + height + " is " + areaInches + " sq. inches and " + areaCm + " sq. cm");

    }
}
