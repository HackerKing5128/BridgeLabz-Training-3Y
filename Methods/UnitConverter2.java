public class UnitConvertor {

    // Convert Yards to Feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;   // 1 yard = 3 feet
        return yards * yards2feet;
    }

    // Convert Feet to Yards
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;  // 1 foot = 0.333333 yards
        return feet * feet2yards;
    }

    // Convert Meters to Inches
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701; // 1 meter = 39.3701 inches
        return meters * meters2inches;
    }

    // Convert Inches to Meters
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;  // 1 inch = 0.0254 meters
        return inches * inches2meters;
    }

    // Convert Inches to Centimeters
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;  // 1 inch = 2.54 cm
        return inches * inches2cm;
    }

    // Test main method
    public static void main(String[] args) {
        System.out.println("10 yards = " + convertYardsToFeet(10) + " feet");
        System.out.println("30 feet = " + convertFeetToYards(30) + " yards");
        System.out.println("2 meters = " + convertMetersToInches(2) + " inches");
        System.out.println("50 inches = " + convertInchesToMeters(50) + " meters");
        System.out.println("25 inches = " + convertInchesToCentimeters(25) + " cm");
    }
}
