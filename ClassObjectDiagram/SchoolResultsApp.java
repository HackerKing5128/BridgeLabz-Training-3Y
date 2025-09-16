import java.util.*;

// Subject class
class Subject {
    private String name;
    private int marks;

    public Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

// Student class
class Student {
    private String name;
    private List<Subject> subjects; // Aggregation: Student has multiple Subjects

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}

// GradeCalculator class
class GradeCalculator {
    public String calculateGrade(Student student) {
        int total = 0;
        for (Subject subject : student.getSubjects()) {
            total += subject.getMarks();
        }
        double average = total / (double) student.getSubjects().size();

        if (average >= 90) return "A";
        else if (average >= 75) return "B";
        else if (average >= 60) return "C";
        else if (average >= 40) return "D";
        else return "F";
    }
}

// Test class
public class SchoolResultsApp {
    public static void main(String[] args) {
        // Create student and subjects
        Student student = new Student("Raghav");
        student.addSubject(new Subject("Maths", 90));
        student.addSubject(new Subject("Science", 85));

        // Grade calculation
        GradeCalculator calculator = new GradeCalculator();
        String grade = calculator.calculateGrade(student);

        // Output
        System.out.println("Student: " + student.getName());
        for (Subject sub : student.getSubjects()) {
            System.out.println("Subject: " + sub.getName() + " | Marks: " + sub.getMarks());
        }
        System.out.println("Final Grade: " + grade);
    }
}
