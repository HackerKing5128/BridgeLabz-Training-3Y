import java.util.*;

// Course class
class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    // Add student to course
    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.addCourse(this);
        }
    }

    // Display students in course
    public void showEnrolledStudents() {
        System.out.println("Course: " + courseName + " - Enrolled Students:");
        for (Student s : students) {
            System.out.println("  " + s.getName());
        }
        System.out.println();
    }

    public String getCourseName() {
        return courseName;
    }
}

// Student class
class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // getter to return Student name as we declare its scope - private
    public String getName() {
        return name;
    }

    // Add course (used by enrollStudent() in Course class)
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    // View courses student is enrolled in
    public void viewCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course c : courses) {
            System.out.println("  " + c.getCourseName());
        }
        System.out.println();
    }
}

// School class
class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Add student to school
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Show all students in school
    public void showStudents() {
        System.out.println("School: " + schoolName + " - Students:");
        for (Student s : students) {
            System.out.println("  " + s.getName());
        }
        System.out.println();
    }
}

// testing class
public class SchoolStudentAndCourses {
    public static void main(String[] args) {
        // Create school
        School school = new School("Horizon High");

        // Create students
        Student s1 = new Student("Nakul");
        Student s2 = new Student("Peter");
        Student s3 = new Student("Charlie");

        // Add students to school
        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);

        // Create courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");
        Course c3 = new Course("History");

        // Enroll students in courses (many-to-many association)
        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        c2.enrollStudent(s1);
        c2.enrollStudent(s3);
        c3.enrollStudent(s2);

        // Show school students
        school.showStudents();

        // Show each student's courses
        s1.viewCourses();
        s2.viewCourses();
        s3.viewCourses();

        // Show enrolled students in each course
        c1.showEnrolledStudents();
        c2.showEnrolledStudents();
        c3.showEnrolledStudents();
    }
}
