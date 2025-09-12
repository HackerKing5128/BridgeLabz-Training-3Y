// Superclass
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    void displayRole() {
        System.out.println("General Person in School");
    }
}

// Subclass: Teacher
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Teacher, Subject: " + subject);
    }
}

// Subclass: Student
class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Student, Grade: " + grade);
    }
}

// Subclass: Staff
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Staff, Department: " + department);
    }
}

// Testing class
public class SchoolSystem {
    public static void main(String[] args) {
        Person p1 = new Teacher("Dhruva", 35, "Mathematics");

        Person p2 = new Student("Jatin", 16, "10th Grade");
        Person p3 = new Staff("Charlie", 40, "Administration");

        // Polymorphism in action
        p1.displayDetails();
        p1.displayRole();
        System.out.println();

        p2.displayDetails();
        p2.displayRole();
        System.out.println();

        p3.displayDetails();
        p3.displayRole();
    }
}

