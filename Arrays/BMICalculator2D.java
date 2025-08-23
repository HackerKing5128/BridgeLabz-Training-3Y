import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] personData = new double[n][3]; // height, weight, BMI
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter height (m) of person " + (i+1) + ": ");
            personData[i][0] = sc.nextDouble();
            System.out.print("Enter weight (kg) of person " + (i+1) + ": ");
            personData[i][1] = sc.nextDouble();

            if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.out.println("Invalid input. Enter again.");
                i--;
                continue;
            }

            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);

            if (personData[i][2] <= 18.4) weightStatus[i] = "Underweight";
            else if (personData[i][2] <= 24.9) weightStatus[i] = "Normal";
            else if (personData[i][2] <= 39.9) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        System.out.println("\nHeight  Weight  BMI  Status");
        for (int i = 0; i < n; i++) {
            System.out.println(personData[i][0] + "  " + personData[i][1] + "  " + personData[i][2] + "  " + weightStatus[i]);
        }
    }
}
