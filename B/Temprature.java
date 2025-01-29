import java.util.*;

public class Temperature {
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();
        
        System.out.print("1 for F to C, 2 for C to F: ");
        int choice = sc.nextInt();
        
        if (choice == 1) {
            System.out.println("In Celsius: " + fahrenheitToCelsius(temp));
        } else if (choice == 2) {
            System.out.println("In Fahrenheit: " + celsiusToFahrenheit(temp));
        } else {
            System.out.println("Invalid option.");
        }
    }
}
