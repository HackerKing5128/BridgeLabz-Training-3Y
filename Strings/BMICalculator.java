import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;   // convert cm to meters
        double bmi = weight / (heightM * heightM);

        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        // Returning as String array
        return new String[]{String.format("%.1f", weight),
                String.format("%.1f", heightCm),
                String.format("%.2f", bmi),
                status};
    }

    // Method to process all persons
    public static String[][] processBMI(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            result[i] = calculateBMI(data[i][0], data[i][1]);
        }
        return result;
    }

    // Method to display results in tabular format
    public static void display(String[][] result) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight", "Height", "BMI", "Status");
        System.out.println("------------------------------------------------------");
        for (String[] row : result) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2]; // 10 persons, weight & height

        System.out.println("Enter Weight (kg) and Height (cm) for 10 persons:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " - Weight (kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Person " + (i + 1) + " - Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        String[][] result = processBMI(data);
        display(result);

    }
}
