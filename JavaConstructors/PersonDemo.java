class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person(p1);

        p1.display();
        p2.display();
    }
}
