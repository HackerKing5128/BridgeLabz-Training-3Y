import java.util.*;

// Employee class
class Employee {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void displayEmployee() {
        System.out.println("   Employee: " + name + " (" + position + ")");
    }
}

// Department class
class Department {
    private String deptName;
    private List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    // Add employee to department
    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
    }

    // Display department and employees
    public void displayDepartment() {
        System.out.println(" Department: " + deptName);
        for (Employee e : employees) {
            e.displayEmployee();
        }
    }

    // Clear employees when deleting department
    public void deleteDepartment() {
        employees.clear();
        System.out.println(" Department " + deptName + " deleted.");
    }
}

// Company class
class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    // Add department to company
    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    // Display all company details
    public void showCompanyStructure() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            d.displayDepartment();
        }
        System.out.println();
    }

    // Delete company (and all departments + employees)
    public void deleteCompany() {
        for (Department d : departments) {
            d.deleteDepartment();
        }
        departments.clear();
        System.out.println("Company " + companyName + " deleted along with all departments and employees.");
    }
}

// testing class
public class CompanyAndDepartments {
    public static void main(String[] args) {
        Company comp = new Company("TechTitans Pvt Ltd");

        Department d1 = new Department("IT");
        d1.addEmployee("Yash", "Developer");
        d1.addEmployee("Raghav", "Tester");

        Department d2 = new Department("HR");
        d2.addEmployee("Charlie", "HR Manager");

        comp.addDepartment(d1);
        comp.addDepartment(d2);

        // Show structure
        comp.showCompanyStructure();
        // Delete company (composition effect)
        comp.deleteCompany();
    }
}
