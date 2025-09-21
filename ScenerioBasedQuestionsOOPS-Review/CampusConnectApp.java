import java.util.*;

// Interface
interface ICourseActions {
    void enrollCourse(Course c);

    void dropCourse(Course c);
}

// Person Base class
abstract class Person {
    protected String name;
    protected String email;
    protected String id;

    public Person(String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public abstract void printDetails();
}

// Student class
class Student extends Person implements ICourseActions {
    private List<Course> courses = new ArrayList<>();
    private List<Double> grades = new ArrayList<>(); // private grades

    public Student(String name, String email, String id) {
        super(name, email, id);
    }

    @Override
    public void enrollCourse(Course c) {
        courses.add(c);
        c.addStudent(this);
        System.out.println(name + " enrolled in " + c.getCourseName());
    }

    @Override
    public void dropCourse(Course c) {
        courses.remove(c);
        c.removeStudent(this);
        System.out.println(name + " dropped " + c.getCourseName());
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    // GPA = sum of grades / count
    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        double total = 0;
        for (double g : grades) total += g;
        return total / grades.size();
    }

    @Override
    public void printDetails() {
        System.out.println("Student: " + name + " | ID: " + id + " | GPA: " + calculateGPA());
    }
}

// Faculty class
class Faculty extends Person {
    private List<Course> assignedCourses = new ArrayList<>();

    public Faculty(String name, String email, String id) {
        super(name, email, id);
    }

    public void assignCourse(Course c) {
        assignedCourses.add(c);
        c.setFaculty(this);
        System.out.println("Course " + c.getCourseName() + " assigned to " + name);
    }

    @Override
    public void printDetails() {
        System.out.println("Faculty: " + name + " | ID: " + id + " | Courses Assigned: " + assignedCourses.size());
    }
}

// Course class
class Course {
    private String courseName;
    private Faculty faculty;
    private List<Student> students = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public void printCourseDetails() {
        System.out.println("Course: " + courseName + " | Faculty: " +
                (faculty != null ? faculty.name : "Not Assigned") +
                " | Students Enrolled: " + students.size());
    }
}

// Demo testing class
public class CampusConnectApp {
    public static void main(String[] args) {
        // Create faculty
        Faculty f1 = new Faculty("Dr. Sharma", "sharma@uni.edu", "F101");

        // Create courses
        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Operating Systems");

        // Assign courses to faculty
        f1.assignCourse(c1);
        f1.assignCourse(c2);
        System.out.println();

        // Create students
        Student s1 = new Student("Yash", "yash@uni.edu", "S001");
        Student s2 = new Student("Charlie", "charlie@uni.edu", "S002");

        // Enroll students
        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s1.enrollCourse(c2);
        System.out.println();

        // Add grades
        s1.addGrade(8.5);
        s1.addGrade(9.0);
        s2.addGrade(7.5);

        // Print details
        f1.printDetails();
        c1.printCourseDetails();
        System.out.println();
        s1.printDetails();
        s2.printDetails();
    }
}
