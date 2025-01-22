// Creating a class named AgeCalculator to calculate a person's age
class AgeCalculator {
    public static void main(String[] args) {
        // Initialize the birth year 
        int birthYear = 2000;

        // Initialize the current year
        int currentYear = 2024;

        // Calculate the age by subtracting the birth year from the current year
        int age = currentYear - birthYear;

        // Display the calculated age 
        System.out.println("Harry's age in " + currentYear + " is " + age);
    }
}
