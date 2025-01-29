import java.util.*;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int low = 1, high = 100;
        
        System.out.println("Think a number 1-100");
        
        while (true) {
            int guess = generateGuess(low, high, rand);
            System.out.println("Your number " + guess + "? (H/L/C)");
            char feedback = sc.next().charAt(0);
            
            if (feedback == 'C' || feedback == 'c') {
                System.out.println("Guessed right!");
                break;
            }
            
            if (feedback == 'H' || feedback == 'h') {
                high = guess - 1;
            } else if (feedback == 'L' || feedback == 'l') {
                low = guess + 1;
            }
        }
    }

    private static int generateGuess(int low, int high, Random rand) {
        return low + rand.nextInt(high - low + 1);
    }
}
