import java.util.Scanner;

public class KilometersToMiles {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Ask user for distance in kilometers
        System.out.print("Enter distance in kilometers: ");
        double kilometers = input.nextDouble();

        // Convert kilometers to miles
        double miles = kilometers / 1.6;

        // Print the result
        System.out.println("The total miles is " + miles + " mile for the given " + kilometers + " km");
    }
}

