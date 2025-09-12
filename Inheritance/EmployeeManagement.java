// Base class
class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }
}

// Subclass Manager
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        System.out.println("Manager -> Name: " + name + ", ID: " + id +
                ", Salary: " + salary + ", Team Size: " + teamSize);
    }
}

// Subclass Developer
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        System.out.println("Developer -> Name: " + name + ", ID: " + id +
                ", Salary: " + salary + ", Language: " + programmingLanguage);
    }
}

// Subclass Intern
class Intern extends Employee {
    String university;

    Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }

    @Override
    void displayDetails() {
        System.out.println("Intern -> Name: " + name + ", ID: " + id +
                ", Salary: " + salary + ", University: " + university);
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Employee e1 = new Manager("Yash", 101, 80000, 5);
        Employee e2 = new Developer("Raghav", 102, 60000, "Java");
        Employee e3 = new Intern("Charlie", 103, 20000, "MIT");

        // Polymorphism in action
        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
    }
}
