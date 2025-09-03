// Student class
class Student {
    // Attributes
    String name;
    int rollNumber;
    double marks;

    // Constructor
    Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade
    char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 75) return 'B';
        else if (marks >= 60) return 'C';
        else if (marks >= 40) return 'D';
        else return 'F';
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + calculateGrade());
    }
}

// Main class
public class StudentsGrades {
    public static void main(String[] args) {
        // Create Student objects
        Student s1 = new Student("Raghav", 101, 92);
        Student s2 = new Student("Riya ", 102, 67);
        Student s3 = new Student("Yash", 103, 38);

        // Display reports
        s1.displayDetails();
        System.out.println();
        s2.displayDetails();
        System.out.println();
        s3.displayDetails();
    }
}
