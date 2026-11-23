
import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;
    String doctor;

    Patient(int id, String name, int age, String disease, String doctor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.doctor = doctor;
    }

    void display() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
        System.out.println("Doctor: " + doctor);
        System.out.println("-----------------------------");
    }
}

public class HospitalManagement {

    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Remove Patient");
            System.out.println("5. Hospital Information");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    searchPatient();
                    break;

                case 4:
                    removePatient();
                    break;

                case 5:
                    hospitalInfo();
                    break;

                case 6:
                    System.out.println("Thank you for using Hospital Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    static void addPatient() {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println("Patient ID already exists!");
                return;
            }
        }

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();

        patients.add(new Patient(id, name, age, disease, doctor));

        System.out.println("Patient added successfully!");
    }

    static void viewPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }

        System.out.println("\n----- PATIENT DETAILS -----");

        for (Patient p : patients) {
            p.display();
        }
    }

    static void searchPatient() {

        System.out.print("Enter Patient ID to search: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println("Patient Found!");
                p.display();
                return;
            }
        }

        System.out.println("Patient not found!");
    }

    static void removePatient() {

        System.out.print("Enter Patient ID to remove: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.id == id) {
                patients.remove(p);
                System.out.println("Patient removed successfully!");
                return;
            }
        }

        System.out.println("Patient not found!");
    }

    static void hospitalInfo() {

        System.out.println("\n===== HOSPITAL INFORMATION =====");
        System.out.println("Hospital Name: City Care Hospital");
        System.out.println("Total Doctors: 10");
        System.out.println("Departments: General, Cardiology, Orthopedic");
        System.out.println("Working Hours: 9 AM to 5 PM");
    }
}

