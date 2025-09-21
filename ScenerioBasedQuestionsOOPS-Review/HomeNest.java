// Interface for controllable devices
interface IControllable {
    void turnOn();

    void turnOff();

    void reset();
}

// Base Device class
abstract class Device implements IControllable {
    private String deviceId;
    private boolean status;
    protected double energyUsage;  // kWh
    private StringBuilder firmwareLogs;

    public Device(String deviceId, double energyUsage) {
        this.deviceId = deviceId;
        this.energyUsage = energyUsage;
        this.status = false;
        this.firmwareLogs = new StringBuilder("Firmware logs:\n");
    }

    public String getDeviceId() {
        return deviceId;
    }

    public boolean isOn() {
        return status;
    }

    protected void setStatus(boolean status) {
        this.status = status;
    }

    protected void addFirmwareLog(String log) { // secure
        firmwareLogs.append(log).append("\n");
    }

    public String getFirmwareLogs() {
        return firmwareLogs.toString();
    }

    public double calculateMonthlyEnergy(int hoursPerDay) {
        return energyUsage * hoursPerDay * 30; // kWh/month
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [ID=" + deviceId + ", Status=" + (status ? "ON" : "OFF") + ", Energy=" + energyUsage + "kWh]";
    }
}

// Light device
class Light extends Device {
    public Light(String deviceId, double energyUsage) {
        super(deviceId, energyUsage);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println("Light " + getDeviceId() + " turned ON.");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Light " + getDeviceId() + " turned OFF.");
    }

    @Override
    public void reset() {
        System.out.println("Light " + getDeviceId() + " brightness reset to default.");
    }
}

// Camera device
class Camera extends Device {
    public Camera(String deviceId, double energyUsage) {
        super(deviceId, energyUsage);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println("Camera " + getDeviceId() + " is now recording.");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Camera " + getDeviceId() + " turned OFF.");
    }

    @Override
    public void reset() {
        System.out.println("Camera " + getDeviceId() + " settings reset to default.");
    }
}

// Thermostat device
class Thermostat extends Device {
    private int temperature;

    public Thermostat(String deviceId, double energyUsage, int temperature) {
        super(deviceId, energyUsage);
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println("Thermostat " + getDeviceId() + " set to " + temperature + " C.");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Thermostat " + getDeviceId() + " turned OFF.");
    }

    @Override
    public void reset() {
        temperature = 24; // default
        System.out.println("Thermostat " + getDeviceId() + " reset to 24 C.");
    }
}

// Lock device
class Lock extends Device {
    public Lock(String deviceId, double energyUsage) {
        super(deviceId, energyUsage);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println("Lock " + getDeviceId() + " is now LOCKED.");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Lock " + getDeviceId() + " is now UNLOCKED.");
    }

    @Override
    public void reset() {
        System.out.println("Lock " + getDeviceId() + " reset to factory security settings.");
    }
}

// Testing
public class HomeNest {
    public static void main(String[] args) {
        Device light = new Light("L001", 0.06);
        Device cam = new Camera("C101", 0.15);
        Device thermo = new Thermostat("T501", 1.2, 22);
        Device lock = new Lock("LK01", 0.01);

        light.turnOn();
        cam.turnOn();
        thermo.turnOn();
        lock.turnOn();
        System.out.println();

        System.out.println(light);
        System.out.println("Monthly energy: " + light.calculateMonthlyEnergy(5) + " kWh");

        System.out.println();
        thermo.reset();
        cam.reset();
        lock.reset();

        System.out.println();
        light.turnOff();
        lock.turnOff();
        System.out.println();

        // Secure firmware log update
        light.addFirmwareLog("Updated to v1.1");
        System.out.println(light.getFirmwareLogs());
    }
}
