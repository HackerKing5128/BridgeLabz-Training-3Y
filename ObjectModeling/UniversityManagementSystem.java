// Course Class
class Course {
    String courseName;
    Professor professor;

    Course(String courseName) {
        this.courseName = courseName;
    }

    // Assign professor to the course
    void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.name + " assigned to course " + courseName);
    }
}

// Professor Class
class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }

    void teachCourse(Course course) {
        course.assignProfessor(this);
    }
}

// Student Class
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    // Student enrolls in a course
    void enrollCourse(Course course) {
        System.out.println("Student " + name + " enrolled in course " + course.courseName);

        // If professor assigned, show the professor
        if (course.professor != null) {
            System.out.println("Course taught by Professor " + course.professor.name);
        } else {
            System.out.println("No professor assigned yet for " + course.courseName);
        }
    }
}

// testing class
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create objects
        Professor prof1 = new Professor("Dr. Sharma");
        Student student1 = new Student("Nakul");
        Student student2 = new Student("Aarav");

        Course course1 = new Course("Data Structures");
        Course course2 = new Course("Operating Systems");

        // Assign professor to courses
        prof1.teachCourse(course1);
        System.out.println();


        // Students enrolling in courses
        student1.enrollCourse(course1);
        System.out.println();
        student2.enrollCourse(course2);
    }
}
