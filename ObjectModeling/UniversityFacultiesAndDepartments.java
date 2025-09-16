import java.util.*;

// Faculty class (
class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void displayFaculty() {
        System.out.println(" Faculty: " + name + " (" + specialization + ")");
    }
}

// Department class (tightly bound to University)
class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public void displayDepartment() {
        System.out.println(" Department: " + deptName);
    }

    public String getDeptName() {
        return deptName;
    }
}

// University class
class University {
    private String uniName;
    private List<Department> departments; // Composition
    private List<Faculty> faculties;      // Aggregation

    public University(String uniName) {
        this.uniName = uniName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    // Add department
    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    // Add faculty
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Show structure
    public void showStructure() {
        System.out.println("University: " + uniName);

        System.out.println(" Departments:");
        for (Department d : departments) {
            d.displayDepartment();
        }

        System.out.println(" Faculties:");
        for (Faculty f : faculties) {
            f.displayFaculty();
        }
        System.out.println();
    }

    // Delete university (removes all departments but not faculties)
    public void deleteUniversity() {
        departments.clear();
        System.out.println("University " + uniName + " deleted with all its departments.");
    }
}

// Testing class
public class UniversityFacultiesAndDepartments {
    public static void main(String[] args) {
        // Create university
        University uni = new University("TechHub University");

        // Add departments
        uni.addDepartment("Computer Science");
        uni.addDepartment("Electrical Engineering");

        // Create faculty members (Aggregation: can exist outside)
        Faculty f1 = new Faculty("Rahul", "AI Research");
        Faculty f2 = new Faculty("Vijay", "Circuits");
        Faculty f3 = new Faculty("Charlie", "Mathematics");

        // Add faculty to university
        uni.addFaculty(f1);
        uni.addFaculty(f2);

        // Show structure
        uni.showStructure();

        // Faculties can exist independently
        System.out.println("Independent Faculty:");
        f3.displayFaculty();
        System.out.println();

        // Delete university
        uni.deleteUniversity();

        // Faculties still exist
        System.out.println("Faculties still exist after University deletion:");
        f1.displayFaculty();
        f2.displayFaculty();
    }
}
