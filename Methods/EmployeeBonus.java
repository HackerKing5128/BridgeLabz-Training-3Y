
// Question 11: Employee Bonus Calculation with Totals
import java.util.Scanner;

class Employee {
    int id;
    String name;
    int years;
    double salary;
    double bonus;

    Employee(int id, String name, int years, double salary) {
        this.id = id;
        this.name = name;
        this.years = years;
        this.salary = salary;
        calculateBonus();
    }

    void calculateBonus() {
        if (years > 5)
            bonus = 0.05 * salary;
        else
            bonus = 0.02 * salary;
    }
}

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        Employee[] arr = new Employee[n];

        double totalBonus = 0, totalSalary = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter ID, Name, Years, Salary for employee " + (i + 1) + ":");
            int id = sc.nextInt();
            String name = sc.next();
            int years = sc.nextInt();
            double salary = sc.nextDouble();
            arr[i] = new Employee(id, name, years, salary);
        }

        System.out.printf("%-10s %-15s %-10s %-10s %-10s\n", "ID", "Name", "Years", "Salary", "Bonus");
        for (Employee e : arr) {
            System.out.printf("%-10d %-15s %-10d %-10.2f %-10.2f\n", e.id, e.name, e.years, e.salary, e.bonus);
            totalBonus += e.bonus;
            totalSalary += e.salary;
        }

        System.out.println("---------------------------------------------------------");
        System.out.printf("Total Salary: %.2f, Total Bonus: %.2f\n", totalSalary, totalBonus);
    }
}
