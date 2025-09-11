class Student {
    static String universityName = "GLA University";
    static int totalStudents = 0;

    String name;
    final int rollNumber;
    String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to display student details
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    // Method to update grade safely (only if object is Student)
    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for " + name + " (Roll No: " + rollNumber + ")");
        }
    }
}

// Testing class
public class UniversityStudentManagement {
    public static void main(String[] args) {
        // Create student objects
        Student s1 = new Student("Rahul Sharma", 101, "A");
        Student s2 = new Student("Priya Singh", 102, "B");

        // Display details
        s1.displayStudentDetails();
        System.out.println("-----------------");
        s2.displayStudentDetails();

        // Update grade
        System.out.println("-----------------");
        s2.updateGrade("A+");

        // Display details again
        System.out.println("-----------------");
        s2.displayStudentDetails();

        // Display total students
        System.out.println("-----------------");
        Student.displayTotalStudents();
    }
}
