import java.util.Scanner;

public class RockPaperScissors {

    // Method to get computer choice using Math.random
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3); // 0,1,2
        if (choice == 0) return "rock";
        else if (choice == 1) return "paper";
        else return "scissors";
    }

    // Method to find the winner
    public static String findWinner(String user, String comp) {
        if (user.equals(comp)) {
            return "draw";
        } else if ((user.equals("rock") && comp.equals("scissors")) ||
                (user.equals("paper") && comp.equals("rock")) ||
                (user.equals("scissors") && comp.equals("paper"))) {
            return "user";
        } else {
            return "computer";
        }
    }

    // Method to calculate average and percentage
    public static String[][] calculateStats(int userWins, int compWins, int draws, int totalGames) {
        double userPercent = (userWins * 100.0) / totalGames;
        double compPercent = (compWins * 100.0) / totalGames;

        String[][] stats = {
                {"Player Wins", String.valueOf(userWins), String.format("%.2f%%", userPercent)},
                {"Computer Wins", String.valueOf(compWins), String.format("%.2f%%", compPercent)},
                {"Draws", String.valueOf(draws), "-"}
        };
        return stats;
    }

    // Method to display results
    public static void displayResults(String[][] stats) {
        System.out.println("\n------ Game Statistics ------");
        System.out.printf("%-15s %-10s %-10s\n", "Result", "Count", "Percentage");
        for (String[] row : stats) {
            System.out.printf("%-15s %-10s %-10s\n", row[0], row[1], row[2]);
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        int userWins = 0, compWins = 0, draws = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("\nGame " + i + " - Enter rock, paper, or scissors: ");
            String userChoice = sc.nextLine().toLowerCase();
            String compChoice = getComputerChoice();

            System.out.println("Computer chose: " + compChoice);

            String winner = findWinner(userChoice, compChoice);

            if (winner.equals("user")) {
                System.out.println("You win!");
                userWins++;
            } else if (winner.equals("computer")) {
                System.out.println("Computer wins!");
                compWins++;
            } else {
                System.out.println("It's a draw!");
                draws++;
            }
        }

        String[][] stats = calculateStats(userWins, compWins, draws, n);
        displayResults(stats);
    }
}
