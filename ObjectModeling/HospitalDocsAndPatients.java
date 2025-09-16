import java.util.*;

// Patient class
class Patient {
    private String name;
    private List<Doctor> doctors; // association with multiple doctors

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Add doctor
    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    // View doctors consulted
    public void viewDoctors() {
        System.out.println("Patient: " + name + " consulted with:");
        for (Doctor d : doctors) {
            System.out.println("  Dr. " + d.getName());
        }
        System.out.println();
    }
}

// Doctor class
class Doctor {
    private String name;
    private String specialization;
    private List<Patient> patients; // association with multiple patients

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public String getSpecialization() {
        return specialization;
    }

    // Consult a patient
    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
        System.out.println("Dr. " + name + " (" + specialization + ") is consulting patient " + patient.getName());
    }

    // View patients consulted
    public void viewPatients() {
        System.out.println("Dr. " + name + " has consulted:");
        for (Patient p : patients) {
            System.out.println("  " + p.getName());
        }
        System.out.println();
    }
}

// Hospital class
class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Add doctor to hospital
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Add patient to hospital
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Show hospital details
    public void showDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println(" Doctors:");
        for (Doctor d : doctors) {
            System.out.println("  Dr. " + d.getName() + " (" + d.getSpecialization() + ")");
        }
        System.out.println(" Patients:");
        for (Patient p : patients) {
            System.out.println("  " + p.getName());
        }
        System.out.println();
    }
}

// testing class
public class HospitalDocsAndPatients {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("L Prasad Hospital");

        // Create doctors
        Doctor d1 = new Doctor("Raghav", "Cardiologist");
        Doctor d2 = new Doctor("Nayan", "Neurologist");

        // Create patients
        Patient p1 = new Patient("Charlie");
        Patient p2 = new Patient("Yash");

        // Add to hospital
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // Consultations
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        // Show hospital details
        hospital.showDetails();

        // View associations
        d1.viewPatients();
        d2.viewPatients();
        p1.viewDoctors();
        p2.viewDoctors();
    }
}
