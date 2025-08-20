import java.util.Scanner;

public class MultiplesWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();
        int counter = 100;
        if (n > 0 && n < 100) {
            while (counter >= 1) {
                if (counter % n == 0)
                    System.out.println(counter);

                counter--;
            }
        } else {
            System.out.println("Enter positive integer less than 100");
        }
    }
}
