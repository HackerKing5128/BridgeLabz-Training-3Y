// Payable interface
interface Payable {
    double calculatePayment();
}

// Patient base class
class Patient {
    private String name;
    private int age;
    private String medicalHistory;
    protected String patientType; // "Emergency" or "Normal"

    public Patient(String name, int age) { // Normal
        this.name = name;
        this.age = age;
        this.patientType = "Normal";
    }

    public Patient(String name, int age, String emergencyDetail) { // Emergency
        this.name = name;
        this.age = age;
        this.patientType = "Emergency";
        this.medicalHistory = emergencyDetail;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void displayInfo() {
        System.out.println("Patient Name: " + name + ", Age: " + age + ", Type: " + patientType);
    }
}

// InPatient class
class InPatient extends Patient {
    private int roomNumber;

    public InPatient(String name, int age, int roomNumber) {
        super(name, age);
        this.roomNumber = roomNumber;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Room Number: " + roomNumber);
    }
}

// OutPatient class
class OutPatient extends Patient {
    private String appointmentDate;

    public OutPatient(String name, int age, String appointmentDate) {
        super(name, age);
        this.appointmentDate = appointmentDate;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Appointment Date: " + appointmentDate);
    }
}

// Doctor class
class Doctor {
    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void displayInfo() {
        System.out.println("Doctor Name: " + name + ", Specialization: " + specialization);
    }
}

// Bill class
class Bill implements Payable {
    private double consultationFee;
    private double medicineCost;
    private double taxRate;

    public Bill(double consultationFee, double medicineCost, double taxRate) {
        this.consultationFee = consultationFee;
        this.medicineCost = medicineCost;
        this.taxRate = taxRate;
    }

    @Override
    public double calculatePayment() {
        double subtotal = consultationFee + medicineCost;
        double tax = subtotal * taxRate / 100;
        double total = subtotal + tax;
        return total;
    }
}

// Main testing class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient p1 = new InPatient("Neeraj", 30, 101);
        Patient p2 = new OutPatient("Hitesh", 25, "2025-09-21");

        Doctor d1 = new Doctor("Dr. Sharma", "Cardiologist");

        Bill bill1 = new Bill(500, 200, 5); // consultation, medicines, tax%

        p1.displayInfo();
        System.out.println();
        p2.displayInfo();
        System.out.println();
        d1.displayInfo();
        System.out.println("Total Bill: Rs." + bill1.calculatePayment());
    }
}
