// Superclass
class Device {
    String deviceId;
    String status;  // ON / OFF

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status);
    }
}

// Subclass
class Thermostat extends Device {
    double temperatureSetting;

    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    void displayStatus() {
        System.out.println("Thermostat -> Device ID: " + deviceId +
                ", Status: " + status +
                ", Temperature: " + temperatureSetting + "°C");
    }
}

// Testing class
public class SmartHomeSystem {
    public static void main(String[] args) {
        Thermostat t1 = new Thermostat("T1001", "ON", 24.5);

        t1.displayStatus();
    }
}
