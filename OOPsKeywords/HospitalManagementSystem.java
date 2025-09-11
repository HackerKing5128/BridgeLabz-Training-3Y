class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    String name;
    int age;
    String ailment;
    final int patientID;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    // Static method to get total patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Display patient details (with instanceof check)
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }
}

// Testing class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Create patient objects
        Patient p1 = new Patient("Rohit Kumar", 45, "Fever", 201);
        Patient p2 = new Patient("Anita Sharma", 30, "Fracture", 202);

        // Display details
        p1.displayPatientDetails();
        System.out.println("-------------------");
        p2.displayPatientDetails();

        // Show total patients
        System.out.println("-------------------");
        Patient.getTotalPatients();
    }
}
