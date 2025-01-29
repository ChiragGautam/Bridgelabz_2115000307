import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        if (num < 1) {
            System.out.println("Enter positive number");
        } else if (num == 1) {
            System.out.println("Fibonacci: 0");
        } else {
            fib(num);
        }
    }

    public static void fib(int num) {
        int first = 0, second = 1;
        System.out.print("Fibonacci: " + first + " " + second);
        
        for (int i = 3; i <= num; i++) {
            int next = first + second;
            System.out.print(" " + next);
            first = second;
            second = next;
        }
        System.out.println();
    }
}