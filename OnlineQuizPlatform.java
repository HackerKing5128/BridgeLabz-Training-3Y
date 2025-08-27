import java.util.*;

class OnlineQuizPlatform {

    public static int calculateScore(String[] correctAns, String[] userAns) {
        int score = 0;
        for (int i = 0; i < correctAns.length; i++) {
            if (userAns[i].equalsIgnoreCase(correctAns[i])) {
                score++;
            }
        }
        return score;
    }

    public static String getGrade(int score, int totalQuestions) {
        double percentage = (score * 100.0) / totalQuestions;
        if (percentage >= 90)
            return "A";
        else if (percentage >= 75)
            return "B";
        else if (percentage >= 50)
            return "C";
        else
            return "D";
    }

    public static void main(String[] args) {
        // Sample Correct answers
        String[] correctAns = {"A", "C", "B", "D", "A"};

        // Sample User submissions
        String[] user1Ans = {"A", "C", "B", "D", "A"}; // all correct
        String[] user2Ans = {"A", "B", "B", "C", "A"}; // some wrong
        String[] user3Ans = {"B", "C", "D", "D", "A"}; // some wrong

        // Store scores of multiple users
        List<Integer> scores = new ArrayList<>();

        // Process results
        int score1 = calculateScore(correctAns, user1Ans);
        scores.add(score1);
        System.out.println("User1 Score: " + score1 + " Grade: " + getGrade(score1, correctAns.length));

        int score2 = calculateScore(correctAns, user2Ans);
        scores.add(score2);
        System.out.println("User2 Score: " + score2 + " Grade: " + getGrade(score2, correctAns.length));

        int score3 = calculateScore(correctAns, user3Ans);
        scores.add(score3);
        System.out.println("User3 Score: " + score3 + " Grade: " + getGrade(score3, correctAns.length));

        // Display scores
        System.out.println("All Users' Scores: " + scores);
    }
}
