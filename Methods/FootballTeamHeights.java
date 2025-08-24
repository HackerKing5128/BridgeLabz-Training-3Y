import java.util.Random;

public class FootballTeamHeights {
    public static void main(String[] args) {
        int[] heights = new int[11];
        Random rand = new Random();

        for (int i = 0; i < heights.length; i++) {
            heights[i] = rand.nextInt(101) + 150; // 150 to 250
        }

        int sum = 0, min = heights[0], max = heights[0];
        for (int h : heights) {
            sum += h;
            if (h < min) min = h;
            if (h > max) max = h;
        }

        double mean = (double) sum / heights.length;

        System.out.println("Heights of players:");
        for (int h : heights) System.out.print(h + " ");
        System.out.println("\nShortest: " + min);
        System.out.println("Tallest: " + max);
        System.out.println("Mean Height: " + mean);
    }
}
