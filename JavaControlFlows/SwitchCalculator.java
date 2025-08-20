import java.util.*;

class SwitchCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1, num2;
        double result = 0;

        while (true) {
            System.out.print("Operations you can perform: \n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Exit \nEnter your choice(1/2/3/4/5): ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter num1: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter num2: ");
                    num2 = sc.nextDouble();
                    result = num1 + num2;
                    System.out.println("Result: " + result);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter num1: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter num2: ");
                    num2 = sc.nextDouble();
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter num1: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter num2: ");
                    num2 = sc.nextDouble();
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Enter num1: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter num2: ");
                    num2 = sc.nextDouble();

                    if (num2 == 0.0) {
                        System.out.println("Error : Division by zero\n");
                        break;
                    } else {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                        System.out.println();
                    }
                    break;

                case 5:
                    System.out.print("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}