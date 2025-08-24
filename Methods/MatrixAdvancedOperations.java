import java.util.Random;
import java.util.Scanner;

public class MatrixAdvancedOperations {

    // Method to create a random matrix
    public static int[][] createMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // random 0-9
            }
        }
        return matrix;
    }

    // Method to find transpose
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    // Method to find determinant (recursive)
    public static int determinant(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];

        int det = 0;
        for (int col = 0; col < n; col++) {
            det += Math.pow(-1, col) * matrix[0][col] * determinant(minor(matrix, 0, col));
        }
        return det;
    }

    // Helper method to find minor matrix
    private static int[][] minor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n-1][n-1];
        int r = 0, c;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                minor[r][c++] = matrix[i][j];
            }
            r++;
        }
        return minor;
    }

    // Method to find inverse (using adjoint / determinant)
    public static double[][] inverse(int[][] matrix) {
        int n = matrix.length;
        int det = determinant(matrix);
        if (det == 0) throw new IllegalArgumentException("Matrix is singular, no inverse.");

        double[][] inverse = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[j][i] = Math.pow(-1, i+j) * determinant(minor(matrix, i, j)) / (double)det;
            }
        }
        return inverse;
    }

    // Print int matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Print double matrix
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%.2f ", val);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of square matrix: ");
        int n = sc.nextInt();

        int[][] A = createMatrix(n, n);
        System.out.println("Matrix A:");
        printMatrix(A);

        System.out.println("Transpose:");
        printMatrix(transpose(A));

        System.out.println("Determinant: " + determinant(A));

        try {
            System.out.println("Inverse:");
            printMatrix(inverse(A));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
