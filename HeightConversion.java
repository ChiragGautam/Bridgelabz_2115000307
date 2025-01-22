import java.util.Scanner;

public class HeightConversion {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Ask user for height in cm
        System.out.print("Enter your height in cm: ");
        double heightCm = input.nextDouble();

        // Convert height to inches and feet
        double heightInches = heightCm / 2.54;
        double heightFeet = heightInches / 12;

        // Print the height in both units
        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + (int) heightFeet + " and inches is " + (heightInches % 12));
    }
}
