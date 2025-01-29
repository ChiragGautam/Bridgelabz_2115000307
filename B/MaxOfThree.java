import java.util.*;

public class MaxOfThree {
    public static int getInput(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        return sc.nextInt();
    }

    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int num1 = getInput("Enter first: ");
        int num2 = getInput("Enter second: ");
        int num3 = getInput("Enter third: ");
        System.out.println("Max: " + findMax(num1, num2, num3));
    }
}
