import java.util.Random;

public class StudentGrades {
    public static int[][] generateMarks(int n) {
        Random rand = new Random();
        int[][] marks = new int[n][3];
        for (int i = 0; i < n; i++) {
            marks[i][0] = rand.nextInt(100);
            marks[i][1] = rand.nextInt(100);
            marks[i][2] = rand.nextInt(100);
        }
        return marks;
    }

    public static String[][] calculateResults(int[][] marks) {
        String[][] results = new String[marks.length][6];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            results[i][0] = String.valueOf(marks[i][0]);
            results[i][1] = String.valueOf(marks[i][1]);
            results[i][2] = String.valueOf(marks[i][2]);
            results[i][3] = String.valueOf(total);
            results[i][4] = String.format("%.2f", percent);
            results[i][5] = getGrade(percent);
        }
        return results;
    }

    public static String getGrade(double percent) {
        if (percent >= 80) return "A";
        else if (percent >= 70) return "B";
        else if (percent >= 60) return "C";
        else if (percent >= 50) return "D";
        else if (percent >= 40) return "E";
        else return "R";
    }

    public static void main(String[] args) {
        int[][] marks = generateMarks(5); // 5 students
        String[][] results = calculateResults(marks);

        System.out.println("Phy\tChem\tMath\tTotal\t% \tGrade");
        for (String[] row : results) {
            for (String col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }
}
