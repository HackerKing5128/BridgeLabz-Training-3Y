import java.util.*;

public class UniqueOTPGenerator {

    // Generate 6-digit OTP
    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000);
    }

    // Check uniqueness of OTPs
    public static boolean checkUnique(int[] otps) {
        Set<Integer> set = new HashSet<>();
        for (int otp : otps) {
            if (!set.add(otp)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }

        System.out.println("Generated OTPs: " + Arrays.toString(otps));
        if (checkUnique(otps)) {
            System.out.println("All OTPs are unique ");
        } else {
            System.out.println("Some OTPs are duplicate ");
        }
    }
}
