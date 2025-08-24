import java.util.Scanner;

public class Calendar {
    static String[] months = {"January","February","March","April","May","June",
            "July","August","September","October","November","December"};
    static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getFirstDay(int month, int year) {
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (d + x + (31*m0)/12) % 7;
    }

    public static void printCalendar(int month, int year) {
        if (isLeapYear(year))
            days[1] = 29;
        else
            days[1] = 28;

        System.out.println("\n   " + months[month-1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getFirstDay(month, year);
        for (int i = 0; i < startDay; i++)
            System.out.print("    ");

        for (int i = 1; i <= days[month-1]; i++) {
            System.out.printf("%3d ", i);
            if (((i + startDay) % 7 == 0) || i == days[month-1])
                System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int m = sc.nextInt();
        System.out.print("Enter year: ");
        int y = sc.nextInt();

        printCalendar(m, y);
    }
}
