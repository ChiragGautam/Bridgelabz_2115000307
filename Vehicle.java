public class Vehicle {
    private static double registrationFee = 500.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType) {
        this.registrationNumber = generateRegistrationNumber();
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }

    private String generateRegistrationNumber() {
        return "REG" + ((int)(Math.random() * 10000));
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Alice", "Car");
        Vehicle v2 = new Vehicle("Bob", "Motorcycle");
        Vehicle v3 = new Vehicle("Charlie", "Truck");

        v1.displayRegistrationDetails();
        v2.displayRegistrationDetails();
        v3.displayRegistrationDetails();

        updateRegistrationFee(600.0);

        v1.displayRegistrationDetails();
        v2.displayRegistrationDetails();
        v3.displayRegistrationDetails();
    }
}
