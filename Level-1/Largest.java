import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking input for three numbers
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Checking the largest number
        if (a > b && a > c) System.out.println("A");
        else if (b > a && b > c) System.out.println("B");
        else System.out.println("C");
    }
}
