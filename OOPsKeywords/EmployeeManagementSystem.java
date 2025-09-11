class Employee {
    static String companyName = "Tech Solutions Pvt. Ltd.";
    static int totalEmployees = 0;

    String name;
    String designation;
    final int id;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    // Static method to display total employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details with instanceof
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }
}

// Testing
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Create employees
        Employee e1 = new Employee("Johnny English", 1001, "Software Engineer");
        Employee e2 = new Employee("Alice Smith", 1002, "Project Manager");

        // Display details
        e1.displayEmployeeDetails();
        System.out.println("-----------------");
        e2.displayEmployeeDetails();

        System.out.println("-----------------");
        // Show total employees
        Employee.displayTotalEmployees();
    }
}
