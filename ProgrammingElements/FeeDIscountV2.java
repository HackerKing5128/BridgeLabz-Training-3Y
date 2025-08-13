import java.util.Scanner;

class FeeDIscountV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter fee amount: ");
        int fee = sc.nextInt();
        System.out.print("Enter discount percent: ");
        int discountPercent = sc.nextInt();

        int discount = fee * discountPercent / 100;
        int discountedFee = fee - discount;

        System.out.println("The discount amount is INR " + discount + " and the final discounted fee is INR " + discountedFee);

    }
}