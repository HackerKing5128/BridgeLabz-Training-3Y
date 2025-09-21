interface Controllable {
    void turnOn();

    void turnOff();
}

// Appliance base class
abstract class Appliance implements Controllable {
    private String name;
    private boolean isOn;
    private double powerUsage; // in Watts

    public Appliance(String name, double powerUsage) {
        this.name = name;
        this.powerUsage = powerUsage;
        this.isOn = false; // default off
    }

    public boolean isOn() {
        return isOn;
    }

    protected void setOn(boolean on) {
        this.isOn = on;
    }

    public double getPowerUsage() {
        return powerUsage;
    }

    public String getName() {
        return name;
    }

    // Abstract control methods
    @Override
    public abstract void turnOn();

    @Override
    public abstract void turnOff();
}

// Light class
class Light extends Appliance {
    public Light(String name, double powerUsage) {
        super(name, powerUsage);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " Light turned ON.");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " Light turned OFF.");
    }
}

// Fan class
class Fan extends Appliance {
    public Fan(String name, double powerUsage) {
        super(name, powerUsage);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " Fan turned ON.");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " Fan turned OFF.");
    }
}

// AC class
class AC extends Appliance {
    public AC(String name, double powerUsage) {
        super(name, powerUsage);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " AC turned ON.");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " AC turned OFF.");
    }
}

// UserController class
class UserController {
    private String userName;

    public UserController(String userName) {
        this.userName = userName;
    }

    public void controlAppliance(Appliance appliance, boolean turnOn) {
        System.out.println("User " + userName + " controlling " + appliance.getName());
        if (turnOn) appliance.turnOn();
        else appliance.turnOff();
    }

    // Compare energy usage
    public void compareEnergy(Appliance a1, Appliance a2) {
        if (a1.getPowerUsage() > a2.getPowerUsage())
            System.out.println(a1.getName() + " uses more energy than " + a2.getName());
        else if (a1.getPowerUsage() < a2.getPowerUsage())
            System.out.println(a1.getName() + " uses less energy than " + a2.getName());
        else
            System.out.println(a1.getName() + " and " + a2.getName() + " use the same energy");
    }
}

// Main testing class
public class SmartHomeSystem {
    public static void main(String[] args) {
        UserController user = new UserController("Kara");

        Appliance light = new Light("Living Room Light", 60);
        Appliance fan = new Fan("Bedroom Fan", 75);
        Appliance ac = new AC("Office AC", 1500);

        user.controlAppliance(light, true);
        System.out.println();
        user.controlAppliance(fan, true);
        System.out.println();
        user.controlAppliance(ac, true);
        System.out.println();

        user.controlAppliance(fan, false);
        System.out.println();

        user.compareEnergy(ac, fan);
        user.compareEnergy(light, fan);
    }
}
