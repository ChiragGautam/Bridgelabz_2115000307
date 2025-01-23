import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input for n
        int n = sc.nextInt();
        int sum = n * (n + 1) / 2;
        // Output the result
        System.out.println(sum);
    }
}
