public class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int age, String ailment) {
        this.patientID = ++totalPatients;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("John", 30, "Fever");
        Patient p2 = new Patient("Alice", 25, "Cold");
        Patient p3 = new Patient("Bob", 40, "Headache");

        p1.displayPatientDetails();
        p2.displayPatientDetails();
        p3.displayPatientDetails();

        getTotalPatients();
    }
}
