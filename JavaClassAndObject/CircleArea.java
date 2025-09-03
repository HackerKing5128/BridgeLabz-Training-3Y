// Circle class
class Circle {
    // Attribute
    double radius;

    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display details
    void displayCircle() {
        System.out.println("Radius        : " + radius);
        System.out.printf("Area          : %.2f",calculateArea());
        System.out.printf("\nCircumference : %.2f ", calculateCircumference());
    }
}

// Main class
public class CircleArea {
    public static void main(String[] args) {
        // Create Circle object
        Circle c1 = new Circle(7.0);

        // Display details
        c1.displayCircle();
    }
}
