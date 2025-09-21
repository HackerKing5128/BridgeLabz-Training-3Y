import java.util.*;

// Interaction Interface
interface IInteractable {
    void feed();

    void play();

    void sleep();
}

// Base Pet class
abstract class Pet implements IInteractable {
    protected String name;
    protected String type;
    protected int age;

    // internal states (0 - 100)
    private int hunger;
    private int mood;
    private int energy;

    // Constructor with random default values
    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
        Random rand = new Random();
        this.hunger = rand.nextInt(50);   // moderately hungry
        this.mood = rand.nextInt(50) + 50; // okay mood
        this.energy = rand.nextInt(50) + 50; // moderate energy
    }

    // Constructor with user provided values
    public Pet(String name, String type, int age, int hunger, int mood, int energy) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.hunger = hunger;
        this.mood = mood;
        this.energy = energy;
    }


    public int getHunger() {
        return hunger;
    }

    public int getMood() {
        return mood;
    }

    public int getEnergy() {
        return energy;
    }

    // Protected setters
    protected void adjustHunger(int change) {
        hunger = Math.max(0, Math.min(100, hunger + change)); // keep in range 0–100
    }

    protected void adjustMood(int change) {
        mood = Math.max(0, Math.min(100, mood + change));
    }

    protected void adjustEnergy(int change) {
        energy = Math.max(0, Math.min(100, energy + change));
    }

    // override methods from interface
    @Override
    public void feed() {
        adjustHunger(-20);
        adjustMood(+5);
        System.out.println(name + " enjoyed the meal!");
    }

    @Override
    public void play() {
        adjustMood(+10);
        adjustEnergy(-15);
        adjustHunger(+10);
        System.out.println(name + " had fun playing!");
    }

    @Override
    public void sleep() {
        adjustEnergy(+30);
        adjustHunger(+5);
        System.out.println(name + " is well rested!");
    }


    public abstract void makeSound();

    // Display pet status
    public void showStatus() {
        System.out.println("Pet: " + name + " (" + type + ", age " + age + ")");
        System.out.println("Hunger: " + hunger + " | Mood: " + mood + " | Energy: " + energy);
        System.out.println("--------------------------------");
    }
}

// Dog class
class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, "Dog", age);
    }

    public Dog(String name, int age, int hunger, int mood, int energy) {
        super(name, "Dog", age, hunger, mood, energy);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }
}

// Cat class
class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, "Cat", age);
    }

    public Cat(String name, int age, int hunger, int mood, int energy) {
        super(name, "Cat", age, hunger, mood, energy);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow Meow!");
    }
}

// Bird class
class Bird extends Pet {
    public Bird(String name, int age) {
        super(name, "Bird", age);
    }

    public Bird(String name, int age, int hunger, int mood, int energy) {
        super(name, "Bird", age, hunger, mood, energy);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet Tweet!");
    }
}

// Demo test class
public class PetPalApp {
    public static void main(String[] args) {
        Pet dog = new Dog("Ghost", 3); // assign random values for hunger, mood & energy
        Pet cat = new Cat("Leo", 2, 56, 70, 81);  // assign explicit values for hunger, mood & energy
        Pet bird = new Bird("Twee", 1);

        dog.showStatus();
        cat.showStatus();
        bird.showStatus();

        // Interactions
        dog.feed();
        cat.play();
        bird.sleep();
        System.out.println();
        // Sounds
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
        System.out.println();

        // Updated status
        dog.showStatus();
        cat.showStatus();
        bird.showStatus();
    }
}
