import java.util.Scanner;

public class DiscountedFee {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Ask user for the total fee
        System.out.print("Enter the fee: ");
        int fee = input.nextInt();

        // Ask user for the discount percentage
        System.out.print("Enter the discount percentage: ");
        int discountPercent = input.nextInt();

        // Calculate discount amount and final fee
        int discountAmount = (fee * discountPercent) / 100;
        int finalFee = fee - discountAmount;

        // Print the discount and final fee
        System.out.println("The discount amount is " + discountAmount + " and final discounted fee is " + finalFee);
    }
}
