import java.util.*;

public class FactorialUsingRecursion {
    public static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    public static int calculateFactorial(int num) {
        return (num <= 1) ? 1 : num * calculateFactorial(num - 1);
    }

    public static void main(String[] args) {
        int num = getInput();
        System.out.println("Factorial: " + calculateFactorial(num));
    }
}
