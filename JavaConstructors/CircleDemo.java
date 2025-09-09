
class Circle {
    double radius;

    Circle() {
        this(1.0); // Calls parameterized constructor
    }

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

public class CircleDemo {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(5.0);

        System.out.println("Default Circle Area: " + c1.area());
        System.out.println("Circle with radius 5 Area: " + c2.area());
    }
}
