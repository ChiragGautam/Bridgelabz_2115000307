import java.util.*;

public class Palindrome {
    public static String getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    public static boolean checkPalindrome(String str) {
        str = str.replace(" ", "").toLowerCase();
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static void main(String[] args) {
        String input = getInput();
        System.out.println(checkPalindrome(input) ? "It's a palindrome" : "Not a palindrome");
    }
}
