// Superclass Person
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

// Worker interface
interface Worker {
    void performDuties();
}

// Chef subclass
class Chef extends Person implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " (Chef) is preparing delicious meals.");
    }
}

// Waiter subclass
class Waiter extends Person implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " (Waiter) is serving customers.");
    }
}

// Testing class
public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Rahul", 101);
        Waiter waiter = new Waiter("Aman", 201);

        chef.displayInfo();
        chef.performDuties();

        System.out.println();

        waiter.displayInfo();
        waiter.performDuties();
    }
}
