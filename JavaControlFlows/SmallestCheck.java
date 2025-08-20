import java.util.*;

public class SmallestCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int n1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int n2 = sc.nextInt();
        System.out.print("Enter third number: ");
        int n3 = sc.nextInt();

        if (n1 < n2 && n1 < n3)
            System.out.println("Is the first number the smallest? " + "Yes");
        else
            System.out.println("Is the first number the smallest? " + "No");
    }
}
