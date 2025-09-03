// Employee class
class Employee {
    // Attributes
    String name;
    int id;
    double salary;

    // Constructor
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Salary : " + salary);
    }
}

// Main class
public class EmployeeDetails {
    public static void main(String[] args) {
        // Creating an employee object
        Employee emp1 = new Employee("Raghav Gupta", 101, 50000);
        // Displaying details
        emp1.displayDetails();
    }
}
